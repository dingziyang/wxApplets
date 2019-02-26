package com.dcm.wxapplets.utils;

import com.dcm.wxapplets.config.GlobalConstant;
import com.dcm.wxapplets.entity.SysUser;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: SessionUserUtil
 * @Description: 从session中获取用户信息的工具类
 * @Auther: dcm
 * @Date: 2018-8-10 14:26
 */

public class SessionUserUtil {

    /**
      * @author dcm
      * @date 2018-8-10 14:29
      * @Description: 获取用户ID
      * @param: request
      * @return java.lang.Long
      * @throws
      */
    public static Long getUserId (HttpServletRequest request) {
        return getUser(request).getId();
    }

    /**
      * @author dcm
      * @date 2018-8-10 14:30
      * @Description: 获取用户信息
      * @param: request
      * @return com.sdcm.common.entity.admin.User
      * @throws
      */
    public static SysUser getUser(HttpServletRequest request) {
        SysUser user = (SysUser) request.getSession().getAttribute(GlobalConstant.LOGIN_USER);
        return user;
    }
}
