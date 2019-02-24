package com.dcm.wxapplets.config;

import com.dcm.wxapplets.entity.SwtUser;
import com.dcm.wxapplets.utils.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: AutoLoginFilter
 * @Description: 自动登录过滤器
 * @Auther: dcm
 * @Date: 2018-5-16 17:00
 */

@Configuration
@WebFilter(filterName = "autoLoginFilter", urlPatterns = "/*")
public class AutoLoginFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(AutoLoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("[------自定义filter init......]");
        // this.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        //log.info("[------自定义filter do......]");
        // 获取出需要使用的对象
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        // 对请求进行判断,去除静态路径
        String url = request.getRequestURI().substring(request.getContextPath().length());
        //log.info("---------url:" + url);

        // 登录相关操作不拦截
        if (url.startsWith("/pc/login/")) {
            chain.doFilter(request, response);//不拦截
            return;
        }

        // swagger api相关操作不拦截
        if (url.startsWith("/swagger") || url.startsWith("/v2/api-docs") || url.startsWith("/webjars")) {
            chain.doFilter(request, response);//不拦截
            return;
        }

        // actuator监控相关操作不拦截admin
        if (url.startsWith("/actuator")) {
            if(isAdmin(request)) {
                chain.doFilter(request, response);//不拦截
                return;
            } else {
                response.sendRedirect("/error/403");
            }
        }

        // druid 数据源监控相关操作不拦截admin
        if (url.startsWith("/druid")) {
            if(isAdmin(request)) {
                chain.doFilter(request, response);//不拦截
                return;
            } else {
                response.sendRedirect("/error/403");
            }
        }

        // 项目静态资源不拦截
        if (url.startsWith("/css") || url.startsWith("/fonts") || url.startsWith("/image") || url.startsWith("/js") || url.startsWith("/login") || url.startsWith("/plugin")) {
            chain.doFilter(request, response);
            return;
        } else { // 非静态资源
            log.info("---------url:" + url);
            SwtUser user = (SwtUser) request.getSession().getAttribute(GlobalConstant.LOGIN_USER);
            if (user != null) { // 用户已登录
                if (url.equals("/")) { // 已登录，访问根路径，自动跳转到主页面
                    response.sendRedirect( "/pc/index");
                    return;
                }
                chain.doFilter(request, response);//不拦截
                return;
            } else {
                if(GlobalConstant.X_REQUESTED_WITH_AJAX_VALUE.equals(request.getHeader(GlobalConstant.X_REQUESTED_WITH))) {
                    log.info("ajax请求时，session中没有用户信息，response返回ResultVo！");
                    String result = "{ \"status\" : " + ResultCode.CODE_401 +", \"message\" : \"Session is invalid! Please login!\", \"data\" : {}, \"serverTime\" : \"" + DateUtil.getCurrTimeStr() + "\"}";
                    response.getOutputStream().write(result.getBytes("UTF-8"));
                } else {
                    log.info("session中没有用户信息，跳转到login页面");
                    // 其它情况，跳转到登录页
                    response.sendRedirect("/pc/login/toLogin");
                }
            }
        }

    }

    @Override
    public void destroy() {
        log.info("[------自定义filter destroy......]");
        //this.destroy();
    }

    private boolean isAdmin(HttpServletRequest request) {
        SwtUser user = (SwtUser) request.getSession().getAttribute(GlobalConstant.LOGIN_USER);
        if( user != null && "admin".equals(user.getUsername())) {
            return true;
        } else {
            return false;
        }
    }
}
