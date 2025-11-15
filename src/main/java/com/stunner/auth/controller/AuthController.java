package com.stunner.auth.controller;

import com.stunner.auth.dto.LoginOtpRequestDto;
import com.stunner.auth.dto.SignupOtpRequestDto;
import com.stunner.auth.service.interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("/signup/request-otp")
    public ResponseEntity<String> requestSignupOtp(@RequestBody SignupOtpRequestDto dto) {
        return authService.requestSignupOtp(dto);
    }

    @PostMapping("/login/request-otp")
    public String requestLoginOtp(@RequestBody LoginOtpRequestDto dto) {
        return authService.requestLoginOtp(dto);
    }
}
