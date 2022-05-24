package com.rest.api.model.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class MailRequestDto {
    private String[] receiveUsers;
    private String newPassword;

    @Override
    public String toString() {
        return "MailRequestDto{" +
                "receiveUsers=" + Arrays.toString(receiveUsers) +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
