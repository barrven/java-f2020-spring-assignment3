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

import ca.gbc.comp3095.assignment3.domain.CreditCard;
import ca.gbc.comp3095.assignment3.domain.SupportMessage;
import ca.gbc.comp3095.assignment3.domain.User;
import ca.gbc.comp3095.assignment3.services.CreditCardService;
import ca.gbc.comp3095.assignment3.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class CreditController {

    private final UserService userService;
    private final CreditCardService creditCardService;

    public CreditController(UserService userService, CreditCardService creditCardService) {
        this.userService = userService;
        this.creditCardService = creditCardService;
    }

    @GetMapping("/credit")
    public String loadCreditProfile(ModelMap model){
        User tempUser = userService.findByUsername("client@isp.net");
        model.put("credit_profiles", tempUser.getCreditCards());
        CreditCard creditCard = new CreditCard();
        model.put("creditCard", creditCard);
        return "client/credit";
    }

    @PostMapping("/credit")
    public String processCreditForm(User tempUser, @ModelAttribute @Valid CreditCard creditCard, BindingResult bindingResult, ModelMap model) {
        tempUser = userService.findByUsername("client@isp.net");
        tempUser.getCreditCards().add(creditCard);
        creditCard.setUser(tempUser);
        creditCardService.save(creditCard);
        userService.save(tempUser);
        return "client/dashboard";
    }
}
