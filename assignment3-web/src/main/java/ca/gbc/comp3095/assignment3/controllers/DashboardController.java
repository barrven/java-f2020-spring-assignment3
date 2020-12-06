/* ******************************************************************************************
 Project: COMP3095 Channel5NewsTeam
 * Assignment: Assignment # 2
 * Author(s): Kevin Ufkes, Barrington Venables, Thiago Hissa
 * Student Number: 101197364, 101189284, 101176085
 * Date: Sunday November 8, 2020
 * Description: Redirects users to their respective dashboard page. Redirects users to pages under construction.
 ********************************************************************************************/

package ca.gbc.comp3095.assignment3.controllers;

import ca.gbc.comp3095.assignment3.domain.User;
import ca.gbc.comp3095.assignment3.repositories.UserRepository;
import ca.gbc.comp3095.assignment3.services.RoleService;
import ca.gbc.comp3095.assignment3.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final UserService userService;
    private final RoleService roleService;

    public DashboardController(UserService userService, RoleService roleService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @RequestMapping("/client")
    public String loadDashboard() {
        return "client/dashboard";
    }


    @GetMapping("/admin")
    public String getDashboard(Model model){
        User adminUser = userService.findByUsername("admin@isp.net");

        model.addAttribute("user", adminUser);


        return "admin/dashboard";
    }


    @RequestMapping(value = {"/tab2","/tab3","/tab4"})
    public String responseUnderCTabs(){
        return "construction";
    }

}

