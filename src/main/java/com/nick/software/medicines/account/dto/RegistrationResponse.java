package com.nick.software.medicines.account.dto;

import lombok.Data;

@Data
public class RegistrationResponse {

    private boolean status;

    private String message;

    private Exception exception;
}
