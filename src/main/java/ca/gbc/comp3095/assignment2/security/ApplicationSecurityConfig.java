/* ******************************************************************************************
 Project: < COMP3095 Channel5NewsTeam>
 * Assignment: < Assignment # 2 >
 * Author(s): < Kevin Ufkes, Barrington Venables, Thiago Hissa>
 * Student Number: < 101197364, 101189284, 101176085 >
 * Date: Sunday November 8, 2020
 * Description: Used to define various options for security currently also adding authorized
 * users because we haven't had time to properly integrate with the database yet
 ********************************************************************************************/

package ca.gbc.comp3095.assignment2.security;

import ca.gbc.comp3095.assignment2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/registration", "/logout", "/css/*", "/js/*").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/dashboard", true)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login");

//                to temp disable database block
                http.headers().frameOptions().disable();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails adminUser = User.builder()
                .username("admin@isp.net")
                .password(passwordEncoder.encode("P@ssword1"))
                .roles("Admin") //ROLE_STUDENT
                .build();

        UserDetails barryUser = User.builder()
                .username("client@isp.net")
                .password(passwordEncoder.encode("P@ssword1"))
                .roles("Client")
                .build();

        UserDetails testUser = User.builder()
                .username("test")
                .password(passwordEncoder.encode("test"))
                .roles("Admin")
                .build();

        return new InMemoryUserDetailsManager(
                adminUser,
                barryUser,
                testUser
        );
    }
}
