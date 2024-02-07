package com.registersignin.registersignin.demo;

import com.registersignin.registersignin.auth.AuthenticationRequest;
import com.registersignin.registersignin.auth.AuthenticationResponse;
import com.registersignin.registersignin.auth.AuthenticationService;
import com.registersignin.registersignin.auth.RegisterRequest;
import com.registersignin.registersignin.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/api/app/")
public class AppController {

    private final AuthenticationService authenticationService;

    public AppController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/can/register")
    public String register(Model model) {

        model.addAttribute("app_user", new User());
        return "register";
    }

    @GetMapping("/can/signin")
    public String signin(Model model) {
        model.addAttribute("app_user", new AuthenticationRequest());
        return "signin";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/cant/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/cant/user")
    public String user() {
        return "user";
    }

    @PostMapping("/can/register")
    public String registering(@ModelAttribute User user) {

        AuthenticationResponse response = authenticationService.register(
                new RegisterRequest(
                        user.getFirstname(),
                        user.getLastname(),
                        user.getEmail(),
                        user.getPassword()
                )
        );

        return "redirect:/api/app/home";
    }

    @PostMapping("/can/signin")
    public String signing(@ModelAttribute User user, HttpSession session) {
        AuthenticationResponse response = authenticationService.authenticate(
                new AuthenticationRequest(
                        user.getEmail(),
                        user.getPassword()
                )
        );


        String jwtToken = response.getToken();
        System.out.println(jwtToken);
        session.setAttribute("jwtToken", jwtToken);

        return "redirect:/api/app/home";
    }
}
