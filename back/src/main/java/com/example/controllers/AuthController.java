package com.example.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.modules.User;
import com.example.modules.enums.UserRole;

public class AuthController {
    public AuthController() {
    }

    static public void setSession(User u, HttpSession session) {
        session.setAttribute("user", u);
    }

    static public User isLogin(HttpSession session) {
        // return new User();
        Object user = session.getAttribute("user");
        if (user != null) {
            return (User) session.getAttribute("user");
        }
        return null;
    }

    static public boolean isCustomer(User u) {
        // return true;
        if (u.getRoleid() == UserRole.Customer)
            return true;
        return false;
    }

    static public void clearSession(HttpSession session) {
        session.invalidate();
    }
}
