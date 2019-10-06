package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.model.UserLoginInfo;
import com.example.demo.service.UserLogin;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@RestController
public class AdminController {

    @Autowired
    private UserService userService;
    private UserLogin userLogin;

    @GetMapping("/index")
    public String index() {
        User user = userService.checkUser("Jone");
        return "index";

    }

    @PostMapping("/login")
    public String userLogin(@RequestParam String username,
                   @RequestParam String password,
                   HttpSession session,
                   RedirectAttributes redirectAttributes) {
        UserLoginInfo user = userLogin.userLogin(username, password);

        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);
            return "admin/index";
        } else {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/admin";
        }
    }
//    @PostMapping
//    public String postTest(){
//
//    }


}
