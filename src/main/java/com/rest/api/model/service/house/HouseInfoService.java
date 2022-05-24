package com.rest.api.model.service.house;

import java.util.List;
import java.util.Map;

import com.rest.api.model.dto.house.ChatDataDto;
import com.rest.api.model.dto.house.HouseDealDto;
import com.rest.api.model.dto.house.HouseInfoDto;
import com.rest.api.model.mapper.house.HouseInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class HouseInfoService {

    private final HouseInfoMapper houseInfoMapper;

    public HouseInfoDto getHouseInfo(long aptCode) throws Exception {
        return houseInfoMapper.getHouseInfo(aptCode);
    }

    public List<HouseDealDto> getHouseDealList(long aptCode) throws Exception {
        return houseInfoMapper.listHouseDeal(aptCode);
    }

    public List<ChatDataDto> getChartDataList(long aptCode) throws Exception {
		return houseInfoMapper.getChartData(aptCode);
    }
}
