package com.example.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.modules.User;
import com.example.modules.enums.UserRole;
import com.example.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.controllers.AuthController.*;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin("http://localhost:4200")
public class UserController {
    private UserService us;

    public UserController() {
    }

    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }

    @PostMapping("/register/customer")
    @ResponseBody
    public User createCustomer(@RequestBody User p, HttpSession session) {
        p.setRoleid(UserRole.Customer);
        User u = us.register(p);
        setSession(u, session);
        return u;

    }

    @PostMapping("/register/seller")
    @ResponseBody
    public User createSeller(@RequestBody User p, HttpSession session) {
        p.setRoleid(UserRole.Seller);
        User u = us.register(p);
        setSession(u, session);
        return u;
    }

    @PostMapping("/login")
    public User LoginCus(@RequestBody User p, HttpSession session) {
        User u = us.Login(p.getUsername(), p.getPassword());
        setSession(u, session);
        return u;
    }

    @PostMapping("/logout")
    public void Logout(HttpSession session) {
        clearSession(session);
    }

    @GetMapping("/islogin")
    public User isloged(HttpSession session) {
        return isLogin(session);
    }

    @PutMapping("/update")
    public User update(@RequestBody User u, HttpSession session) {
        User p = isLogin(session);
        u.setUser_id(p.getUser_id());
        u.setRoleid(p.getRoleid());
        return us.update(u);
    }

    // @GetMapping("/")
    // public List<User> getAllUsers(){
    // return us.getAllUsers();
    // }

    // @GetMapping("/{id}")
    // @ResponseBody
    // User getPersonById(@PathVariable("id")int id){
    // return us.getPersonById(id);
    // }
}
