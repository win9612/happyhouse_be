package com.rest.api.model.service.user;

import com.rest.api.model.dto.user.AccountDto;
import com.rest.api.model.mapper.user.AccountMapper;
import com.rest.api.response.ApiResponse;
import com.rest.api.response.ResponseMap;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountMapper accountMapper;

    public ApiResponse addAccount(AccountDto accountDto) {
        ResponseMap result = new ResponseMap();

        accountDto.setPassword(hashPassword(accountDto.getPassword()));
        accountMapper.insertAccount(accountDto);
        return result;
    }

    private String hashPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

}
