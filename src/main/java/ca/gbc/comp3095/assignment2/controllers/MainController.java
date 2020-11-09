/* ******************************************************************************************
 Project: COMP3095 Channel5NewsTeam
 * Assignment: Assignment # 2
 * Author(s): Kevin Ufkes, Barrington Venables, Thiago Hissa
 * Student Number: 101197364, 101189284, 101176085
 * Date: Sunday November 8, 2020
 * Description: <Directs users to the login page. Directs users to the Registration page.>
 ********************************************************************************************/

package ca.gbc.comp3095.assignment2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    public MainController(){

    }

    @RequestMapping({"/","/login"})
    public String response(Model model){
        return "login";
    }



    @RequestMapping("/registration")
    public String initRegistration() {
        return "client/registration";
    }

}
