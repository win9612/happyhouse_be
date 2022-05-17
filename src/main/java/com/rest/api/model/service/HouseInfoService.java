package com.rest.api.model.service;

import java.util.List;

import com.rest.api.model.dto.HouseDealDto;
import com.rest.api.model.dto.HouseInfoDto;
import com.rest.api.model.mapper.HouseInfoMapper;
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
