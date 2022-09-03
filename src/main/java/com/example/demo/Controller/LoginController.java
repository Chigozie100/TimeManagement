package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    IUserService iUserService;
    @GetMapping("/login")
    public String viewLogin(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("invalid", null);
        return "login";
    }
    @PostMapping("/login")
    public String login(HttpSession session, User user, Model model){
        Optional<User> newUser ;
        newUser = iUserService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        if (newUser.isEmpty()){
            //error if email exist but wrong password provided
            model.addAttribute("invalid", "incorrect email or password");
            return "login";
        }
        session.setAttribute("user", newUser);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String login(HttpSession session, Model model){
        if (session != null){
            session.invalidate();
        }
        model.addAttribute("user", new User());
        model.addAttribute("invalid", null);
        return "redirect:/login";
    }
}
