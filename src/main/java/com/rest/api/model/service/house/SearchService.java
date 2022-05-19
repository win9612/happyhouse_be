package com.rest.api.model.service.house;

import com.rest.api.model.dto.house.BaseAddressDto;
import com.rest.api.model.dto.house.HouseInfoDto;
import com.rest.api.model.mapper.house.SearchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchMapper searchMapper;

    public List<BaseAddressDto> getDongListByGugun(String gugun) throws Exception {
        return searchMapper.getDongListByGugun(gugun);
    }

    public List<BaseAddressDto> getDongListByDong(String dong) throws Exception{
        return searchMapper.getDongListByDong(dong);
    }

    public List<HouseInfoDto> getAptListByDong(String dong) throws Exception{
        return searchMapper.getAptListByDong(dong);
    }

    public List<HouseInfoDto> getAptListBtAptName(String aptName) throws  Exception {
        return searchMapper.getAptListByAptName(aptName);
    }

}
