package com.dcm.wxapplets.controller.pc;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: IndexCtl
 * @Description: 主页控制器
 * @Auther: dcm
 * @Date: 2018-5-25 9:10
 */

@Api(value = "/pc/index", description = "主页接口")
@Controller
public class IndexCtl {

    /**
      * @author dcm
      * @date 2018-5-30 18:50
      * @Description: 主页面
      * @return org.springframework.web.servlet.ModelAndView
      * @throws
      */
    @GetMapping("/pc/index")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView("/index");
        return modelAndView;
    }



}
