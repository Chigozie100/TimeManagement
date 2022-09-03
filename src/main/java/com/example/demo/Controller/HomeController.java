package com.example.demo.Controller;

import com.example.demo.Entity.Task;
import com.example.demo.Service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
   private ITaskService iTaskService;
    @GetMapping
    private String home(HttpSession session,Model model){
        if(session.getAttribute("user") == null)return "redirect:/login";
        return "home";
    }
}
