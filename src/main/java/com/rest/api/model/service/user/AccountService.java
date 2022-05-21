package com.rest.api.model.service.user;

import com.rest.api.model.dto.user.AccountDto;
import com.rest.api.model.dto.user.auth.AuthDto;
import com.rest.api.model.mapper.user.AccountMapper;
import com.rest.api.model.service.user.auth.AuthService;
import com.rest.api.response.ApiResponse;
import com.rest.api.response.ResponseMap;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountMapper accountMapper;
    private final AuthService authService;

    public ApiResponse addAccount(AccountDto accountDto) {
        ResponseMap result = new ResponseMap();

        accountDto.setPassword(hashPassword(accountDto.getPassword()));
        accountMapper.insertAccount(accountDto);
        return result;
    }

    public AccountDto getAccount(String email) {
        return accountMapper.getAccount(email);
    }


    private String hashPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public ApiResponse socialLoginOrRegist(Map map) {

        ApiResponse responseMap = new ResponseMap();
        String email = map.get("email").toString();
        String openId = map.get("id").toString();

        // 사용자 조회해서 결과 있으면 로그인
        if(getAccount(email) == null) {
            // null 이라는거는 사용자가 없다는 얘기
            // 회원가입 진행
            responseMap.setCode(404);
            responseMap.setResult(map);

        } else {
            // null 이 아니면 가입이 되어있다는거
            AuthDto.LoginDto loginDto = new AuthDto.LoginDto(email, openId);
            responseMap = authService.login(loginDto);
        }
        return responseMap;
    }

}
