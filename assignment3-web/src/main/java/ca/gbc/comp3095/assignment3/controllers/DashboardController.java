/* ******************************************************************************************
 Project: COMP3095 Channel5NewsTeam
 * Assignment: Assignment # 2
 * Author(s): Kevin Ufkes, Barrington Venables, Thiago Hissa
 * Student Number: 101197364, 101189284, 101176085
 * Date: Sunday November 8, 2020
 * Description: Redirects users to their respective dashboard page. Redirects users to pages under construction.
 ********************************************************************************************/

package ca.gbc.comp3095.assignment3.controllers;

import ca.gbc.comp3095.assignment3.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    private final UserRepository userRepository;

    public DashboardController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/dashboard")
    public String loadDashboard() {
        return "client/dashboard";
    }
//
//    @RequestMapping("/logout")
//    public String test(){
//        return "logout";
//    }

    @RequestMapping(value = {"/tab2","/tab3","/tab4"})
    public String responseUnderCTabs(){
        return "construction";
    }

}

