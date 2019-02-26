package com.dcm.wxapplets.controller.pc;

import com.dcm.wxapplets.config.GlobalConstant;
import com.dcm.wxapplets.config.ResultCode;
import com.dcm.wxapplets.config.ResultVO;
import com.dcm.wxapplets.entity.SysUser;
import com.dcm.wxapplets.query.SysUserExample;
import com.dcm.wxapplets.service.SysUserService;
import com.dcm.wxapplets.utils.date.DateUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName: LoginCtl
 * @Description: 登录控制器
 * @Auther: dcm
 * @Date: 2018-5-16 17:00
 */

@Api(value = "/pc/login", description = "登录接口")
@Controller
@RequestMapping("/pc/login")
public class LoginCtl {

    private static final Logger log = LoggerFactory.getLogger(LoginCtl.class);

    @Autowired
    private SysUserService userService;

    /**
     * @author dcm
     * @date 2018-5-18 10:26
     * @Description: 导向用户登录页面
     * @throws
     */
    @GetMapping("/toLogin")
    public ModelAndView toLogin(){

        ModelAndView modelAndView = new ModelAndView("/toLogin");
        return modelAndView;
    }

   /**
     * @author dcm
     * @date 2018-6-1 11:11
     * @Description: 登录操作
     * @param: req
     * @param: res
     * @param: loginName 用户名
     * @param: password 密码
     * @throws
     */
    @PostMapping("loginIn")
    @ResponseBody
    public ResultVO<Object> loginIn(HttpServletRequest req, HttpServletResponse res, String loginName, String password) throws Exception {

        ResultVO<Object> vo = new ResultVO<>();
        vo.setServerTime(DateUtil.getCurrTimeStr());
        try {
            if (!StringUtils.isEmpty(loginName) && !StringUtils.isEmpty(password)) {
                SysUserExample example = new SysUserExample();
                example.createCriteria().andUserNameEqualTo(loginName);
                List<SysUser> users = userService.selectByExample(example);

                if(CollectionUtils.isEmpty(users) || users.get(0) == null) {
                    log.info("登录失败,没有这个用户");
                    vo.setStatus(ResultCode.CODE_405);
                    vo.setMessage("登录失败,没有这个用户");
                    return vo;
                } else {
                    SysUser user = users.get(0);
                    user = this.userService.selectByPrimaryKey(user.getId()); // 填充user的若干关联信息
                    if(password.equals(user.getPwd())){
                        if(user.getWorker() == 1){
                            log.info("登录失败，工人账号不允许登录系统");
                            vo.setStatus(ResultCode.CODE_501);
                            vo.setMessage("登录失败，工人账号不允许登录系统");
                            return vo;
                        } else {
                            log.info("登录成功，登录用户:" + loginName + " ; ===========>session Id： " + req.getSession().getId());
                            req.getSession().setAttribute(GlobalConstant.LOGIN_USER, user);
                            vo.setStatus(ResultCode.CODE_200);
                            vo.setMessage("登录成功");
                            vo.setData(user);
                            return vo;
                        }
                    } else {
                        log.info("登录失败，密码错误");
                        vo.setStatus(ResultCode.CODE_405);
                        vo.setMessage("登录失败，密码错误");
                        return vo;
                    }
                }
            } else {
                log.info("登录失败，用户名或密码为空");
                vo.setStatus(ResultCode.CODE_405);
                vo.setMessage("登录失败，用户名或密码为空");
                return vo;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("登录异常，登录用户；" + loginName, e);
            vo.setStatus(ResultCode.CODE_500);
            vo.setMessage("系统异常，请联系管理员");
            return vo;
        }
    }

    /**
      * @author dcm
      * @date 2018-5-18 11:48
      * @Description: 退出登录，定向到登录页面
      * @param: request
      * @throws
      */
    @GetMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/pc/login/toLogin";
    }

}
