package com.infopost.com.infopostaccountservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDTO {
    private String username;
    private BigDecimal balance;

}
