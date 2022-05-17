package com.rest.api.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.rest.api.model.dto.HouseInfoDto;
import com.rest.api.model.dto.SidoGugunCodeDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HouseMapMapper {

	List<SidoGugunCodeDto> getSido() throws SQLException;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws SQLException;
	List<HouseInfoDto> getDongInGugun(String gugun) throws SQLException;
	List<HouseInfoDto> getAptInDong(String dong) throws SQLException;
	
}
