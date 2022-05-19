package com.rest.api.model.mapper.user;

import com.rest.api.model.dto.user.AccountDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    void insertAccount(AccountDto accountDto);
}
