package com.shreeganeshfinance.creditapplication.security.filter;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.shreeganeshfinance.creditapplication.exception.UserNotFoundException;
import com.shreeganeshfinance.creditapplication.pojo.User;
import com.shreeganeshfinance.creditapplication.security.SecurityConstant;
import com.shreeganeshfinance.creditapplication.service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class JWTAuthorizationFilter extends OncePerRequestFilter{


    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if(header == null || !header.startsWith(SecurityConstant.BEARER)){
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.replace(SecurityConstant.BEARER, "");
        String user = JWT.require(Algorithm.HMAC512(SecurityConstant.SECRET_KEY)).build().verify(token).getSubject();
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, Arrays.asList());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
    
}
