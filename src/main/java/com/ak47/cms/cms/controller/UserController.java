package com.ak47.cms.cms.controller;

import com.ak47.cms.cms.entity.User;
import com.ak47.cms.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="homePage",method = RequestMethod.GET)
    public String toHomePage(){
        return "cms_layout/calendar_page";

    }


    @RequestMapping(value="saveUser",method = RequestMethod.POST)
    @ResponseBody
    public String saveUser(User user){

        userService.saveUser(user);
        return "true";

    }

    @RequestMapping(value="doLogin",method = RequestMethod.POST)
    @ResponseBody
    public String doLogin(User user , HttpSession session ){

        if(userService.doLogin(user)){
            session.setAttribute("currentUser",user.getUserName() );
            return "200";
        }
        return "false";

    }



    @RequestMapping(value="logout",method = RequestMethod.POST)
    @ResponseBody
    public String logout(User user , HttpSession session ){
        session.removeAttribute("currentUser");
        return "true";

    }


}
