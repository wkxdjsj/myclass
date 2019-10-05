package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserLogin;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index() {
        User user = userService.checkUser("Jone");
        return "index";

    }

    @Autowired
    private UserLogin userLogin;
    @RequestMapping(path = "/login")
    public @ResponseBody
    String addUser(@RequestParam String username, @RequestParam String password) {
        UserLogin user = userLogin.login(username, password);

        return "SUCCESS!";
    }
//    @PostMapping
//    public String postTest(){
//
//    }


}
