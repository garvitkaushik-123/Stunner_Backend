package com.stunner.auth.dto;

import lombok.Data;

@Data
public class VerifyOTPDto {
    private String phoneNumber;
    private String otp;
}