package com.stunner.auth.service;

import com.stunner.auth.dto.LoginOtpRequestDto;
import com.stunner.auth.dto.SignupOtpRequestDto;
import com.stunner.auth.entity.User;
import com.stunner.auth.repository.UserRepository;
import com.stunner.auth.service.interfaces.AuthService;
import com.stunner.auth.service.interfaces.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OtpService otpService;

    @Override
    public ResponseEntity<String> requestSignupOtp(@RequestBody SignupOtpRequestDto dto) {

        boolean exists = userRepository.findByPhoneNumber(dto.getPhoneNumber()).isPresent();

        if (exists) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("User already exists. Please login."); // User already exists
        }

        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhoneNumber(dto.getPhoneNumber());

        // otpService.generateOtp(dto.getPhoneNumber()); // future step if not generate handle appropriately

        userRepository.save(user);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("User created successfully. Signup OTP initiated (dummy).");
    }

    @Override
    public ResponseEntity<String> requestLoginOtp(@RequestBody LoginOtpRequestDto dto) {

        boolean exists = userRepository.findByPhoneNumber(dto.getPhoneNumber()).isPresent();

        if (!exists) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("User does not exist. Please signup.");
        }

        // otpService.generateOtp(dto.getPhoneNumber()); // future step if not generate handle appropriately

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Login OTP initiated.");
    }
}
