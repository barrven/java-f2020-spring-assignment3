/*******************************************************************************************
 Project: < COMP3095 Channel5NewsTeam>
 * Assignment: < Assignment # 2 >
 * Author(s): < Kevin Ufkes, Barrington Venables, Thiago Hissa>
 * Student Number: < 101197364, 101189284, 101176085 >
 * Date: Sunday November 8, 2020
 * Description: <describe the java file and its purpose briefly only – 1 or 2 lines>
 ********************************************************************************************/

package ca.gbc.comp3095.assignment2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
