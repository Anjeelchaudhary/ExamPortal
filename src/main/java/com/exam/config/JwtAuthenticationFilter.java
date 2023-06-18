package com.exam.config;

import com.exam.service.impl.UserDetailServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private UserDetailServiceImpl userDetailService;
    private JwtUtils jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");
        String username=null;
        String jwtToken=null;

        if (requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken=requestTokenHeader.substring(7);
            try {
                username = this.jwtUtil.extractUsername (jwtToken);
            }catch (ExpiredJwtException e) {
                e.printStackTrace();
                System.out.println("jwt token has expired");
            }catch (Exception e) {
                e.printStackTrace();
                System.out.println("error");
            }
        }else {
            System.out.println("Invalid token , not start with bearer string");
        }

        //validate
        if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
            final UserDetails userDetails = this.userDetailService.loadUserByUsername(username);
            if (jwtUtil.validateToken(jwtToken,userDetails)) {
                //token is valid
                UsernamePasswordAuthenticationToken usernamePasswordAuthentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            }else {
                System.out.println("Token is not valid");
            }
            filterChain.doFilter(request,response);
        }
    }
}
