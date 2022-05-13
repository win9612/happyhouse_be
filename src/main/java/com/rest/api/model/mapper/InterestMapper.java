package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.InterestDto;

public interface InterestMapper {

	void addInterest(InterestDto interestDto) throws Exception;
	List<HouseInfoDto> selectList(@Param("no")int no) throws Exception;
	int checkInterest(@Param("no")int no, @Param("aptCode")int aptCode) throws Exception;
	void deleteInterest(@Param("no")int no, @Param("aptCode")int aptCode) throws Exception;
}
