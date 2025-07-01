package com.example.spring_security_jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.security.interfaces.RSAPublicKey;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Collections;

public class JwtFilter extends OncePerRequestFilter {

    private RSAPublicKey publicKey;

    public JwtFilter() {
        try {
            publicKey = RSAUtil.loadPublicKey("E:\\SynologyDrive\\Dokumenty\\BootCamp\\projekty\\Spring Boot2 Course\\spring_security_jwt\\src\\main\\resources\\public_key.pem");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //for JWT RSA

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = getUseNamePasswordAuthToken(authorization);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        filterChain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getUseNamePasswordAuthToken(String auth) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.RSA256(publicKey, null)).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(auth.substring(7));
        System.out.println(decodedJWT.getToken());
        String name = decodedJWT.getClaim("name").asString();
        boolean isAdmin = decodedJWT.getClaim("admin").asBoolean();
        String role = "ROLE_USER";
        if (isAdmin) {
            role = "ROLE_ADMIN";
        }
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);
        return new UsernamePasswordAuthenticationToken(name, null, Collections.singleton(simpleGrantedAuthority));
    }


    //for JWT HMAC512

    /*@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
   String authorization =  request.getHeader("Authorization");
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = getUseNamePasswordAuthToken(authorization);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        filterChain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getUseNamePasswordAuthToken (String auth) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC512("T0JjcDZzZUdLa0x0VzAybGxGc3RUMXJjS3RWMkFkVXZ1U0t0bndXZjh0ZmNldnB3")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(auth.substring(7));
        System.out.println(decodedJWT.getToken());
        String name = decodedJWT.getClaim("name").asString();
        boolean isAdmin = decodedJWT.getClaim("admin").asBoolean();
        String role = "ROLE_USER";
        if(isAdmin) {
            role = "ROLE_ADMIN";
        }
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);
         return new UsernamePasswordAuthenticationToken(name, null, Collections.singleton(simpleGrantedAuthority));

    }*/
}
