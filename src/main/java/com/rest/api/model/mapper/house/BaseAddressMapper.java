package com.rest.api.model.mapper.house;

import com.rest.api.model.dto.house.BaseAddressDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface BaseAddressMapper {

	BaseAddressDto getBaseAddressOne(String dongCode) throws SQLException;
	List<BaseAddressDto> getBaseAddressBySido(String sidoName) throws SQLException;
}
