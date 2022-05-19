package com.rest.api.model.service.house;

import java.util.List;

import com.rest.api.model.dto.house.HouseInfoDto;
import com.rest.api.model.dto.house.SidoGugunCodeDto;
import com.rest.api.model.mapper.house.HouseMapMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HouseMapService {

	private final HouseMapMapper houseMapMapper;

	public List<SidoGugunCodeDto> getSido() throws Exception {
		return houseMapMapper.getSido();
	}

	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return houseMapMapper.getGugunInSido(sido);
	}

	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		return houseMapMapper.getDongInGugun(gugun);
	}

	public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
		return houseMapMapper.getAptInDong(dong);
	}

}
