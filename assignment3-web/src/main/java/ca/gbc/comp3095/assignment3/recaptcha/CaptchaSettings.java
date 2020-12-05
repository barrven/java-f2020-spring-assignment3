/* ******************************************************************************************
 Project: COMP3095 Channel5NewsTeam
 * Assignment: Assignment # 2
 * Author(s): Kevin Ufkes, Barrington Venables, Thiago Hissa
 * Student Number: 101197364, 101189284, 101176085
 * Date: Sunday November 8, 2020
 * Description: Defines Captcha settings for ReCaptcha functionality on login page
 ********************************************************************************************/

package ca.gbc.comp3095.assignment3.recaptcha;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix= "google.recaptcha.key")
public class CaptchaSettings {
    private String site;
    private String secret;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
