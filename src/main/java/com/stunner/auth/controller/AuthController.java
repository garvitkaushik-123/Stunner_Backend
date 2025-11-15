package com.stunner.auth.controller;

import com.stunner.auth.dto.LoginOtpRequestDto;
import com.stunner.auth.dto.SignupOtpRequestDto;
import com.stunner.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;


    @PostMapping("/signup/request-otp")
    public String requestSignupOtp(@RequestBody SignupOtpRequestDto dto) {
        return authService.requestSignupOtp(dto);
    }

    @PostMapping("/login/request-otp")
    public String requestLoginOtp(@RequestBody LoginOtpRequestDto dto) {
        return authService.requestLoginOtp(dto);
    }
}
