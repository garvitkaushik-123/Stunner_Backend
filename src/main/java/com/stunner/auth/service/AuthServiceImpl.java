package com.stunner.auth.service;

import com.stunner.auth.dto.LoginOtpRequestDto;
import com.stunner.auth.dto.SignupOtpRequestDto;
import com.stunner.auth.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String requestSignupOtp(SignupOtpRequestDto dto) {
        boolean exists = userRepository.findByPhoneNumber(dto.getPhoneNumber()).isPresent();

        if (exists) {
            return "User already exists. Please login.";
        }

        // For now we do not create user here — we only store OTP later
        return "Signup OTP initiated (dummy response, OTP yet to be implemented)";
    }

    @Override
    public String requestLoginOtp(LoginOtpRequestDto dto) {
        boolean exists = userRepository.findByPhoneNumber(dto.getPhoneNumber()).isPresent();

        if (!exists) {
            return "User does not exist. Please signup.";
        }

        return "Login OTP initiated (dummy response, OTP yet to be implemented)";
    }
}
