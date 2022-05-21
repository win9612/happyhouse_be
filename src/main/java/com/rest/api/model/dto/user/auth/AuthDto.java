package com.rest.api.model.dto.user.auth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDto {

    @Getter
    @Setter
    public static class LoginDto {

        @ApiModelProperty(value = "아이디", example = "admin@naver.com", required = true)
        private String email;

        @ApiModelProperty(value="비밀번호", example = "1235", required = true)
        private String password;

        public LoginDto(String email, String password) {
            this.email = email;
            this.password = password;
        }
        public LoginDto() {
        }
    }

    @Getter
    @Setter
    public static class GetNewAccessTokenDto {

        @ApiModelProperty(value = "Refresh Token index", example = "1", required = true)
        private long refreshIdx;
    }

}
