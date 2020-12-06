/* ******************************************************************************************
 Project: COMP3095 Channel5NewsTeam
 * Assignment: Assignment # 3
 * Author(s): Kevin Ufkes, Barrington Venables, Thiago Hissa
 * Student Number: 101197364, 101189284, 101176085
 * Date: Saturday December 5, 2020
 * Description: Allows a client to send message to support.
 ********************************************************************************************/

package ca.gbc.comp3095.assignment3.controllers;

import ca.gbc.comp3095.assignment3.domain.Role;
import ca.gbc.comp3095.assignment3.domain.SupportMessage;
import ca.gbc.comp3095.assignment3.domain.User;
import ca.gbc.comp3095.assignment3.services.SupportMessageService;
import ca.gbc.comp3095.assignment3.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class SupportMessageController {

    private final SupportMessageService supportMessageService;
    private final UserService userService;

    public SupportMessageController(SupportMessageService supportMessageService, UserService userService) {
        this.supportMessageService = supportMessageService;
        this.userService = userService;
    }

//    @RequestMapping("/admin-support")
//    public String loadAdminSupport(){
//        return "admin/support";
//    }

    @GetMapping("/supportmessage")
    public String initCreateForm(ModelMap model) {
        SupportMessage supportMessage = new SupportMessage();
        model.put("supportmessage", supportMessage);
        return "client/support";
    }

    @PostMapping("/supportmessage")
    public String processCreationForm(User tempUser, @ModelAttribute @Valid SupportMessage supportMessage, BindingResult bindingResult, ModelMap model) {
        if(bindingResult.hasErrors()) {
            return "client/dashboard";
        } else {
            supportMessage.setDate(LocalDate.now());
            tempUser = userService.findByUsername("client@isp.net");
            tempUser.getSupportMessages().add(supportMessage);
            supportMessage.setUser(tempUser);
            supportMessageService.save(supportMessage);
            userService.save(tempUser);
            return "client/dashboard";
        }
    }

    @RequestMapping("/supportmessage")
    public String loadUserSupport(){
        // TODO Check if user is admin, if so, return "admin/support"
        return "client/support";
    }
}
