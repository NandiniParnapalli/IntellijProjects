package com.kog.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
}
