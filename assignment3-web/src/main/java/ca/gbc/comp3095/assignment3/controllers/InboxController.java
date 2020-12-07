package ca.gbc.comp3095.assignment3.controllers;

import ca.gbc.comp3095.assignment3.domain.User;
import ca.gbc.comp3095.assignment3.services.SupportMessageService;
import ca.gbc.comp3095.assignment3.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/inbox")
public class InboxController {

    private UserService userService;
    private SupportMessageService supportMessageService;

    public InboxController(SupportMessageService supportMessageService, UserService userService) {
        this.userService = userService;
        this.supportMessageService = supportMessageService;
    }

    @RequestMapping("/client")
    public String viewClientInbox(Model model) {
        User tempUser = userService.findByUsername("client@isp.net");
        model.addAttribute("messages", tempUser.getSupportMessages());
        return "client/inbox";
    }

    @RequestMapping("/admin")
    public String viewAdminInbox(Model model) {
        model.addAttribute("messages", supportMessageService.findAll());
        return "admin/inbox";
    }
}
