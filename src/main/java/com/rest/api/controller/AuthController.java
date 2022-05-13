package com.rest.api.controller;

import com.rest.api.model.dto.AuthDto;
import com.rest.api.model.service.AuthService;
import com.rest.api.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(tags = "Auth / 로그인")
@RequestMapping("/app/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @ApiOperation(value="로그인")
    public ApiResponse login(@RequestBody @Valid AuthDto.LoginDto loginDto){
        return authService.login(loginDto);
    }
    @PostMapping("/refreshToken")
    @ApiOperation(value="새로운 토큰 발급")
    public ApiResponse newAccessToken(@RequestBody @Valid AuthDto.GetNewAccessTokenDto getNewAccessTokenDTO, HttpServletRequest request) {
        return authService.newAccessToken(getNewAccessTokenDTO, request);
    }

}
