/* ******************************************************************************************
 Project: COMP3095 Channel5NewsTeam
 * Assignment: Assignment # 3
 * Author(s): Kevin Ufkes, Barrington Venables, Thiago Hissa
 * Student Number: 101197364, 101189284, 101176085
 * Date: Saturday December 5, 2020
 * Description:
    Allows a client to add/delete/update/viewone-to-many credit card profile under
    their account and configure one card as the default (or preferred) card/
 ********************************************************************************************/

package ca.gbc.comp3095.assignment3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreditController {

    @RequestMapping("/credit")
    public String loadCreditProfile(){ return "client/credit"; }
}
