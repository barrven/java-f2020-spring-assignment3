/* ******************************************************************************************
 Project: COMP3095 Channel5NewsTeam
 * Assignment: Assignment # 2
 * Author(s): Kevin Ufkes, Barrington Venables, Thiago Hissa
 * Student Number: 101197364, 101189284, 101176085
 * Date: Sunday November 8, 2020
 * Description: Redirects users to their respective dashboard page. Redirects users to pages under construction.
 ********************************************************************************************/

package ca.gbc.comp3095.assignment3.controllers;

import ca.gbc.comp3095.assignment3.domain.Address;
import ca.gbc.comp3095.assignment3.domain.Role;
import ca.gbc.comp3095.assignment3.domain.SupportMessage;
import ca.gbc.comp3095.assignment3.domain.User;
import ca.gbc.comp3095.assignment3.services.AddressService;
import ca.gbc.comp3095.assignment3.services.RoleService;
import ca.gbc.comp3095.assignment3.services.SupportMessageService;
import ca.gbc.comp3095.assignment3.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final UserService userService;
    private final RoleService roleService;
    private final SupportMessageService supportMessageService;
    private final AddressService addressService;

    public DashboardController(
            UserService userService,
            RoleService roleService,
            SupportMessageService supportMessageService,
            AddressService addressService) {
        this.roleService = roleService;
        this.userService = userService;
        this.supportMessageService = supportMessageService;
        this.addressService = addressService;
    }

    @RequestMapping("/client")
    public String loadClientDashboard(Model model) {
        User user = userService.findByUsername("client@isp.net");
        Set<SupportMessage> messages = supportMessageService.findAll();

        List<Address> temp = new ArrayList<>(addressService.findAll());
        Set<Address> addresses = new HashSet<>();
        for (Address address : temp) {
            User u = address.getUser();
            if (u.equals(user)) {
                addresses.add(address);
            }
        }

        Address address1 = addresses.iterator().next();
        //Address address2 = addresses.iterator().next();
        Address address2 = address1;

        model.addAttribute("user", user);
        model.addAttribute("messages", messages);
        model.addAttribute("address1", address1);
        model.addAttribute("address2", address2);


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

