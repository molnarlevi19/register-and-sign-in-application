package com.registersignin.registersignin.demo;

import com.registersignin.registersignin.auth.AuthenticationRequest;
import com.registersignin.registersignin.auth.AuthenticationResponse;
import com.registersignin.registersignin.auth.AuthenticationService;
import com.registersignin.registersignin.auth.RegisterRequest;
import com.registersignin.registersignin.model.User;
import com.registersignin.registersignin.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/log/")
public class LogController {

    private final AuthenticationService authenticationService;

    public LogController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /*
    @PostMapping("/can/register")
    public String registering(@ModelAttribute User user, HttpSession session) {

        AuthenticationResponse response = authenticationService.register(
                new RegisterRequest(
                        user.getFirstname(),
                        user.getLastname(),
                        user.getEmail(),
                        user.getPassword()
                )
        );

        //userRepository.save(user);

        return "redirect:/api/app/";
    }

    @PostMapping("http://localhost:8080/api/v1/auth/authenticate")
    public String signing(@ModelAttribute User user, HttpSession session) {
        AuthenticationResponse response = authenticationService.authenticate(
                new AuthenticationRequest(
                        user.getEmail(),
                        user.getPassword()
                )
        );

        System.out.println("JWT Token: " + response.getToken());

        return "redirect:/api/app/";
    }*/
}
