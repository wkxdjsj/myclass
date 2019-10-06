package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/success")
    public String index() {
        User user = userService.checkUser("Jone");
        return "success";

    }

    @GetMapping("/login")
    public String postTest() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String userName,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        User user = userService.login(userName, password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);
            return "success";
        } else {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/login";
        }
    }
}

