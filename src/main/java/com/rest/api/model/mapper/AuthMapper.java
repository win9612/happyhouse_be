package com.rest.api.model.mapper;

import com.rest.api.model.dao.RefreshToken;
import com.rest.api.model.dao.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {

    // userDetailService 클래스에서 사용
    User findByEmail(String email);

    // AuthService에서 리프레쉬 토큰 발급시 사용
    String findRefreshTokenByIdx(long idx);

    // 리프레쉬 토큰 발급시 insert or update 시 사용
    void insertOrUpdateRefreshToken(RefreshToken refreshToken);
    
}
