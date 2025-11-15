package com.stunner.auth.dto;

import lombok.Data;

@Data
public class SignupOtpRequestDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
