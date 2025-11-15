package com.stunner.auth.service.interfaces;

import com.stunner.auth.dto.LoginOtpRequestDto;
import com.stunner.auth.dto.SignupOtpRequestDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<String> requestSignupOtp(SignupOtpRequestDto dto);
    ResponseEntity<String> requestLoginOtp(LoginOtpRequestDto dto);
}
