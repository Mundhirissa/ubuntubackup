package com.example.demo.config;


import com.example.demo.Sersvisers.JWTServics;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private final JWTServics jwtServics;

    private final UserServics userServics;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;


        if(StringUtils.isEmpty(authHeader) || !org.apache.commons.lang.StringUtils.startsWith(authHeader,"Bearer")){

            filterChain.doFilter(request,response);
            return;
        }
    }
}
