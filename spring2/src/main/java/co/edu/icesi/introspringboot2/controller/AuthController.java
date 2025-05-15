package co.edu.icesi.introspringboot2.controller;

import co.edu.icesi.introspringboot2.entity.User;
import co.edu.icesi.introspringboot2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "features/auth/signup";
    }

    @PostMapping("/signup")
    public String signupCreate(@ModelAttribute User user) {
        try {
            userService.createUser(user);
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            return "redirect:/signup?emailAlreadyExists";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "features/auth/login";
    }

    @GetMapping("/home")
    public String home() {
        return "features/auth/home";
    }


}
