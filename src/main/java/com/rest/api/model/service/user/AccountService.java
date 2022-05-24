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

import java.security.SecureRandom;
import java.util.Date;
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

    public String makeNewPassword(){
        char[] charSet = new char[] {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        StringBuilder sb = new StringBuilder();
        SecureRandom sr = new SecureRandom();
        sr.setSeed(new Date().getTime());
        int size = 15; // 패스워드의 길이
        int len = charSet.length;
        int idx = 0;
        for(int i = 0 ; i < size ; i++){
            idx = sr.nextInt(len);
            sb.append(charSet[idx]);
        }
        return sb.toString();
    }

    public ApiResponse modifyName(String email, String name){
        ResponseMap result = new ResponseMap();
        accountMapper.modifyName(email, name);
        result.setCode(200);
        return result;
    }

    public ApiResponse modifyPassword(String email, String password){
        ResponseMap result = new ResponseMap();
        String hash = hashPassword(password);
        accountMapper.modifyPassword(email, hash);

        result.setCode(200);
        return result;
    }

    public ApiResponse deleteAccount(String email){
        ResponseMap result = new ResponseMap();
        accountMapper.deleteAccount(email);
        result.setCode(200);
        return result;
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

    public int isExistAccount(String email, String name){
        return accountMapper.isExistAccountByEmailAndName(email, name);
    }

    public int checkSamePassword(String email, String password){
        String hash = hashPassword(password);
        //System.out.println("password => " + password);
        //System.out.println("hash => " + hash);
        return accountMapper.checkSamePassword(email, password);
    }
}
