package com.rest.api.model.service.house;

import java.util.List;

import com.rest.api.model.dto.house.HouseDealDto;
import com.rest.api.model.dto.house.HouseInfoDto;
import com.rest.api.model.mapper.house.HouseInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class HouseInfoService {

	private final HouseInfoMapper houseInfoMapper;

	public HouseInfoDto getHouseInfo(int aptCode) throws Exception {
		return houseInfoMapper.getHouseInfo(aptCode);
	}

	public List<HouseDealDto> getHouseDealList(int aptCode) throws Exception {
		return houseInfoMapper.listHouseDeal(aptCode);
	}
}
