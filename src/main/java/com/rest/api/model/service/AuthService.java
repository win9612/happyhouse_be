package com.rest.api.model.service;


import com.rest.api.config.security.JwtProvider;
import com.rest.api.exception.AuthenticationException;
import com.rest.api.exception.ErrorCode;
import com.rest.api.model.dao.RefreshToken;
import com.rest.api.model.dto.AuthDto;
import com.rest.api.model.mapper.AuthMapper;
import com.rest.api.response.ApiResponse;
import com.rest.api.response.ResponseMap;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;
    private final AuthMapper authMapper;

    public ApiResponse login(AuthDto.LoginDto loginDto) {
        ResponseMap result = new ResponseMap();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
            );
            Map createToken = createTokenReturn(loginDto);
            result.setResponseData("accessToken", createToken.get("accessToken"));
            result.setResponseData("refreshIdx", createToken.get("refreshIdx"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthenticationException(ErrorCode.UsernameOrPasswordNotFoundException);
        }
        return result;
    }

    public ApiResponse newAccessToken(AuthDto.GetNewAccessTokenDto getNewAccessTokenDTO, HttpServletRequest request) {
        ResponseMap result = new ResponseMap();
        String refreshToken = authMapper.findRefreshTokenByIdx(getNewAccessTokenDTO.getRefreshIdx());
        // AccessToken은 만료되었지만 RefreshToken은 만료되지 않은 경우
        if (jwtProvider.validateJwtToken(request, refreshToken)) {
            String email = jwtProvider.getUserInfo(refreshToken);
            AuthDto.LoginDto loginDTO = new AuthDto.LoginDto();
            loginDTO.setEmail(email);
            Map createToken = createTokenReturn(loginDTO);
            result.setResponseData("accessToken", createToken.get("accessToken"));
            result.setResponseData("refreshIdx", createToken.get("refreshIdx"));
        } else {
            // RefreshToken 또한 만료된 경우는 로그인을 다시 진행해야 한다.
            result.setResponseData("code", ErrorCode.ReLogin.getCode());
            result.setResponseData("message", ErrorCode.ReLogin.getMessage());
            result.setResponseData("HttpStatus", ErrorCode.ReLogin.getStatus());
        }
        return result;
    }


    // 토큰 생성해서 반환
    private Map createTokenReturn(AuthDto.LoginDto loginDto) {
        Map result = new HashMap();

        String accessToken = jwtProvider.createAccessToken(loginDto);
        String refreshToken = jwtProvider.createRefreshToken(loginDto).get("refreshToken");
        String refreshTokenExpirationAt = jwtProvider.createRefreshToken(loginDto).get("refreshTokenExpirationAt");

        RefreshToken insertRefreshToken = RefreshToken.builder()
                .userEmail(loginDto.getEmail())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .refreshTokenExpirationAt(refreshTokenExpirationAt)
                .build();

        authMapper.insertOrUpdateRefreshToken(insertRefreshToken);

        result.put("accessToken", accessToken);
        result.put("refreshIdx", insertRefreshToken.getIdx());


        return result;
    }
}
