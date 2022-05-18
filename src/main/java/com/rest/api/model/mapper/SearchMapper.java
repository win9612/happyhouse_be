package com.rest.api.model.mapper;

import com.rest.api.model.dto.BaseAddressDto;
import com.rest.api.model.dto.HouseInfoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {

    // 구군까지 입력했을 때 필터링된 동 반환
    List<BaseAddressDto> getDongListByGugun(String gugun) throws Exception;

    // 동까지 입력했을 때 필터링된 동 반환
    List<BaseAddressDto> getDongListByDong(String dong) throws Exception;

    // 동까지 입력했을 때 필터링된 아파트 반환
    List<HouseInfoDto> getAptListByDong(String dong) throws Exception;

    // 아파트 이름 입력했을 때 필터리된 아파트 반환
    List<HouseInfoDto> getAptListByAptName(String aptName) throws Exception;
}
