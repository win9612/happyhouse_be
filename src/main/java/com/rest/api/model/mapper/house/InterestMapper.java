package com.rest.api.model.mapper.house;

import java.util.List;
import java.util.Map;

import com.rest.api.model.dto.house.HouseInfoDto;
import com.rest.api.model.dto.house.InterestDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InterestMapper {

	void addInterest(InterestDto interestDto) throws Exception;
	List<HouseInfoDto> selectList(@Param("no")int no) throws Exception;
	int checkInterest(InterestDto interestDto) throws Exception;
	void deleteInterest(InterestDto interestDto) throws Exception;
}
