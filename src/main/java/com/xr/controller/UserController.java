package com.xr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xurui
 * @create 2023-05-15 23:47
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ModelAndView getUser() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","欢迎来到springMVC");
        // 相当于执行 request.getRequestDispather("/show.jsp").forward(...)
        mv.setViewName("show");
        return mv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(String username, String male) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("username",username );
        mv.addObject("male", male);
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping(value = "/findUserByUser",method = RequestMethod.GET)
    public ModelAndView findUserByUserId(
            @RequestParam(value = "username",required = true) String name,
            @RequestParam(value = "male", required = false) String sex) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("sex",sex);
        mv.setViewName("hello");
        return mv;
    }

}
