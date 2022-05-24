package com.rest.api.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

@Mapper
public interface RecommandMapper {
    int updateRegion(@Param("email") String email,@Param("aptCode") String aptCode) throws SQLException;
    String selectRegion(@Param("email") String email) throws SQLException;
}
