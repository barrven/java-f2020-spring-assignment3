/* ******************************************************************************************
 Project: COMP3095 Channel5NewsTeam
 * Assignment: Assignment # 2
 * Author(s): Kevin Ufkes, Barrington Venables, Thiago Hissa
 * Student Number: 101197364, 101189284, 101176085
 * Date: Sunday November 8, 2020
 * Description: <Directs users to the login page. Directs users to the Registration page.>
 ********************************************************************************************/

package ca.gbc.comp3095.assignment3.controllers;

import ca.gbc.comp3095.assignment3.domain.Role;
import ca.gbc.comp3095.assignment3.domain.User;
import ca.gbc.comp3095.assignment3.repositories.UserRepository;
import ca.gbc.comp3095.assignment3.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    public UserService userService;

    public LoginController(){

    }

    public LoginController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping({"/","/login"})
    public String response(Model model){
        return "login";
    }

//Trying Something

//    @PostMapping("/login")
//    public String processCreationForm(@ModelAttribute @Valid User user, Model model) {
//         userService.findByUsername(user.getUsername());
//         if(user.getRoles().contains("Admin")){
//             return "admin/dashboard";
//         } else {
//             return "client/dashboard";
//         }
//
//    }


}
