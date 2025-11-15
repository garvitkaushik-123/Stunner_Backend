package com.stunner.auth.service;

import com.stunner.auth.dto.LoginOtpRequestDto;
import com.stunner.auth.dto.SignupOtpRequestDto;

public interface AuthService {
    String requestSignupOtp(SignupOtpRequestDto dto);
    String requestLoginOtp(LoginOtpRequestDto dto);
}
