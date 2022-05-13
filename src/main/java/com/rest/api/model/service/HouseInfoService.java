package com.rest.api.model.service;

import java.util.List;

import com.rest.api.model.dto.HouseDealDto;
import com.rest.api.model.dto.HouseInfoDto;
import com.rest.api.model.mapper.HouseInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class HouseInfoServiceImpl implements HouseInfoService{

	private final HouseInfoMapper houseInfoMapper;

	@Override
	public HouseInfoDto getHouseInfo(int aptCode) throws Exception {
		return houseInfoMapper.getHouseInfo(aptCode);
	}

	@Override
	public List<HouseDealDto> getHouseDealList(int aptCode) throws Exception {
		return houseInfoMapper.listHouseDeal(aptCode);
	}
}
