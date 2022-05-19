package com.rest.api.model.mapper.house;

import com.rest.api.model.dto.house.HouseDealDto;
import com.rest.api.model.dto.house.HouseInfoDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface HouseInfoMapper {

	HouseInfoDto getHouseInfo(int aptCode) throws SQLException;
	List<HouseDealDto> listHouseDeal(int aptCode) throws SQLException; // 아파트 상세정보 & 거래리스트
	
}
