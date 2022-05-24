package com.rest.api.model.mapper.user;

import com.rest.api.model.dto.user.AccountDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    void insertAccount(AccountDto accountDto);
    AccountDto getAccount(String email);
    int isExistAccountByEmailAndName(String email, String name);
    void modifyName(String email, String name);
    void modifyPassword(String email, String hash);
    void deleteAccount(String email);
}
