package com.rest.api.model.dto.user.auth;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RefreshToken {

    private long idx;
    private String userEmail;
    private String accessToken;
    private String refreshToken;
    private String refreshTokenExpirationAt;
}
