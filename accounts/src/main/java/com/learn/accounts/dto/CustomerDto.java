package com.learn.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {
    @NotEmpty(message = "Name should be most between 5 to 30 characters")
    @Size(min=5, max = 30, message = "Name should be most between 5 to 30 characters")
    private String name;

    @NotEmpty(message = "Email field not empty")
    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit")
    private String mobileNumber;

    private AccountDto accountDto;
}
