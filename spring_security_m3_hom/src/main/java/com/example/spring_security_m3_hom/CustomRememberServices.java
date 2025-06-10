package com.example.spring_security_m3_hom;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

public class CustomRememberServices extends PersistentTokenBasedRememberMeServices {


    public CustomRememberServices(String key, UserDetailsService userDetailsService, PersistentTokenRepository tokenRepository) {
        super(key, userDetailsService, tokenRepository);
    }

    @Override
      protected void onLoginSuccess(HttpServletRequest request, HttpServletResponse httpServletResponse, Authentication authentication) {
        String durationStr = request.getParameter("remember-duration");
        try {
           int seconds =  Integer.parseInt(durationStr);
           setTokenValiditySeconds(seconds);
        } catch (NumberFormatException e) {
            setTokenValiditySeconds(super.getTokenValiditySeconds());
        }
        super.onLoginSuccess(request, httpServletResponse, authentication);
    }
}
