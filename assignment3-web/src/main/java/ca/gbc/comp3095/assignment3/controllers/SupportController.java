/* ******************************************************************************************
 Project: COMP3095 Channel5NewsTeam
 * Assignment: Assignment # 3
 * Author(s): Kevin Ufkes, Barrington Venables, Thiago Hissa
 * Student Number: 101197364, 101189284, 101176085
 * Date: Saturday December 5, 2020
 * Description: Allows a client to send message to support.
 ********************************************************************************************/

package ca.gbc.comp3095.assignment3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SupportController {
//    @RequestMapping("/admin-support")
//    public String loadAdminSupport(){
//        return "admin/support";
//    }

    @RequestMapping("/support")
    public String loadUserSupport(){
        // TODO Check if user is admin, if so, return "admin/support"
        return "client/support";
    }
}
