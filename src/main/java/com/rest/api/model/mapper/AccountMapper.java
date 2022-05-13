package com.rest.api.model.mapper;

import com.rest.api.model.dto.AccountDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    void insertAccount(AccountDto accountDto);
}
