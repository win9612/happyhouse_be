package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.BaseAddressDto;

public interface BaseAddressMapper {

	BaseAddressDto getBaseAddressOne(String dongCode) throws SQLException;
	List<BaseAddressDto> getBaseAddressBySido(String sidoName) throws SQLException;
}
