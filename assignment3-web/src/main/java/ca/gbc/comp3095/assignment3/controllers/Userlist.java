package ca.gbc.comp3095.assignment3.controllers;

import ca.gbc.comp3095.assignment3.domain.SupportMessage;
import ca.gbc.comp3095.assignment3.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ca.gbc.comp3095.assignment3.services.UserService;

import java.util.Set;

@Controller
public class Userlist {

    private final UserService userService;

    public Userlist(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/admin/users-listing")
    public String getUserList(Model model){
        Set<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin/dashboard";
    }

}
