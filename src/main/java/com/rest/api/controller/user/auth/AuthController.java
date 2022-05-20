package com.rest.api.controller.user.auth;

import com.rest.api.model.dto.user.auth.AuthDto;
import com.rest.api.model.service.user.auth.AuthService;
import com.rest.api.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(tags = "인증관리")
@RequestMapping("/app/auth")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    @ApiOperation(value="로그인")
    @PostMapping("/login")
    public ApiResponse login(@RequestBody @Valid AuthDto.LoginDto loginDto){
        return authService.login(loginDto);
    }
    @ApiOperation(value="리프레쉬 토큰 발급")
    @PostMapping("/refreshToken")
    public ApiResponse newAccessToken(@RequestBody @Valid AuthDto.GetNewAccessTokenDto getNewAccessTokenDTO, HttpServletRequest request) {
        return authService.newAccessToken(getNewAccessTokenDTO, request);
    }

}
