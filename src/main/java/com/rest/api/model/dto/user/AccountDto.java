package com.rest.api.model.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {
    private long idx;
    private String email;
    private String password;
    private String role="USER";
    private String name;
    private String social="local";
}
