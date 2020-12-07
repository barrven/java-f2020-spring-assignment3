/* ******************************************************************************************
 Project: COMP3095 Channel5NewsTeam
 * Assignment: Assignment # 3
 * Author(s): Kevin Ufkes, Barrington Venables, Thiago Hissa
 * Student Number: 101197364, 101189284, 101176085
 * Date: Saturday December 5, 2020
 * Description: View and/or delete users. List of users will be displayed
 ********************************************************************************************/

package ca.gbc.comp3095.assignment3.controllers;

import ca.gbc.comp3095.assignment3.domain.SupportMessage;
import ca.gbc.comp3095.assignment3.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ca.gbc.comp3095.assignment3.services.UserService;

import java.util.Set;

@Controller
public class UserlistController {

    private final UserService userService;

    public UserlistController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/admin/users-listing")
    public String getUserList(Model model){
        Set<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin/users";
    }

}
