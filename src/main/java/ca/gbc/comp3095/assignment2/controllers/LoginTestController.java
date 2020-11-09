/* ******************************************************************************************
 Project: COMP3095 Channel5NewsTeam
 * Assignment: Assignment # 2
 * Author(s): Kevin Ufkes, Barrington Venables, Thiago Hissa
 * Student Number: 101197364, 101189284, 101176085
 * Date: Sunday November 8, 2020
 * Description: <describe the java file and its purpose briefly only – 1 or 2 lines>
 ********************************************************************************************/

package ca.gbc.comp3095.assignment2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

//@RestController
//@RequestMapping("/principal")
public class LoginTestController {

    @GetMapping
    public Principal retrievePrincipal(Principal principal) {
        return principal;
    }

}
