package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class signupController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/signup")
    public String showSignUpForm(Model model){
        User user = new User();
        model.addAttribute("user1", user);
        model.addAttribute("invalid", null);
        return "signup";
    }

    @PostMapping("/process_signup")
    public String processRegister(@ModelAttribute("user1") User user, Model model) {
        User user1 = iUserService.getUserByEmail(user.getEmail());
        if(user1 != null){
            // Through error if email is already registered
            model.addAttribute("invalid", "user already exist");
            return "signup";
        }
        if (user1 == null){
            //if user empty, insert details
            model.addAttribute("user", "signup successful");
        }
        iUserService.saveUser(user);
        return "redirect:/login";
    }
}
