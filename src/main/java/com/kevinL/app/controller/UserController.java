package com.eyric.app.controller;

import com.eyric.app.entity.User;
import com.eyric.app.service.UserService;
import com.eyric.base.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;

    @RequestMapping("/save")
    @ResponseBody
    public Json save() {
        Json json = new Json();
        User user = new User("张三", "123456", new Date());
        if (userService.saveUser(user)) {
            json.setSuccess(true);
            json.setMsg("ok");
            json.setObj(user);
        } else {
            json.setSuccess(false);
            json.setMsg("err");
            json.setObj(null);
        }


        return json;
    }

    @RequestMapping("/find")
    @ResponseBody
    public Json findUser() {
        Json json = new Json();
        User user = userService.findUserByUname("eyric");
        json.setSuccess(true);
        json.setObj(user);
        return json;
    }

    @RequestMapping("/test")
    @ResponseBody
    public Json test() {
        userService.delete(8L);

        Json json = new Json();
        json.setSuccess(true);
        return json;
    }
}
