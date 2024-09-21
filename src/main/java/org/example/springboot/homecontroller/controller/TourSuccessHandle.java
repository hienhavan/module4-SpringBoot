//package org.example.springboot.homecontroller.controller;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.example.springboot.model.minitest.ROLE;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.DefaultRedirectStrategy;
//import org.springframework.security.web.RedirectStrategy;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Component
//
//public class TourSuccessHandle extends SimpleUrlAuthenticationSuccessHandler {
//    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//
//    protected String dieuhuong(Authentication authentication) {
//        Collection<? extends GrantedAuthority> au = authentication.getAuthorities();
//        List<String> roles = new ArrayList<String>();
//        for (GrantedAuthority a : au) {
//            roles.add(a.getAuthority());
//        }
//        if (roles.contains(ROLE.ROLE_ADMIN.toString())) {
//            return "/admin";
//        }
//        if (roles.contains(ROLE.ROLE_USER.toString())) {
//            return "/user";
//        }
//        return "";
//    }
//
//    @Override
//    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        String targetUrl = dieuhuong(authentication);
//        if (targetUrl != null && !targetUrl.equals("")) {
//            redirectStrategy.sendRedirect(request, response, targetUrl);
//        } else {
//            super.handle(request, response, authentication);
//        }
//    }
//}