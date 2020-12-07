/* ******************************************************************************************
 Project: COMP3095 Channel5NewsTeam
 * Assignment: Assignment # 2
 * Author(s): Kevin Ufkes, Barrington Venables, Thiago Hissa
 * Student Number: 101197364, 101189284, 101176085
 * Date: Sunday November 8, 2020
 * Description: Redirects users to their respective dashboard page. Redirects users to pages under construction.
 ********************************************************************************************/

package ca.gbc.comp3095.assignment3.controllers;

import ca.gbc.comp3095.assignment3.domain.SupportMessage;
import ca.gbc.comp3095.assignment3.domain.User;
import ca.gbc.comp3095.assignment3.services.RoleService;
import ca.gbc.comp3095.assignment3.services.SupportMessageService;
import ca.gbc.comp3095.assignment3.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final UserService userService;
    private final RoleService roleService;
    private final SupportMessageService supportMessageService;

    public DashboardController(
        UserService userService,
        RoleService roleService,
        SupportMessageService supportMessageService
    ) {
        this.roleService = roleService;
        this.userService = userService;
        this.supportMessageService = supportMessageService;
    }

    @RequestMapping("/client")
    public String loadClientDashboard() {
        return "client/dashboard";
    }


    @GetMapping("/admin")
    public String loadAdminDashboard(Model model){
        User adminUser = userService.findByUsername("admin@isp.net");
        Set<SupportMessage> messages = supportMessageService.findAll();
        Set<User> users = userService.findAll();

        model.addAttribute("user", adminUser);
        model.addAttribute("messages", messages);
        model.addAttribute("users", users);

        return "admin/dashboard";
    }


    @RequestMapping(value = {"/tab2","/tab3","/tab4"})
    public String responseUnderCTabs(){
        return "construction";
    }

}

