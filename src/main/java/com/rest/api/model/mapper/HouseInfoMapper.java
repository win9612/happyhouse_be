package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.HouseInfoDto;

public interface HouseInfoMapper {

	HouseInfoDto getHouseInfo(int aptCode) throws SQLException;
	List<HouseDealDto> listHouseDeal(int aptCode) throws SQLException; // 아파트 상세정보 & 거래리스트
	
}
