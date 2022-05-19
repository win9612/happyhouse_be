package com.rest.api.model.service.house;

import java.util.List;

import com.rest.api.model.dto.house.BaseAddressDto;
import com.rest.api.model.mapper.house.BaseAddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseAddressService {

	private final BaseAddressMapper baMapper;

	public BaseAddressDto getBaseAddressOne(String dongCode) throws Exception {
		return baMapper.getBaseAddressOne(dongCode);
	}

	public List<BaseAddressDto> getBaseAddressBySido(String sidoName) throws Exception {
		return baMapper.getBaseAddressBySido(sidoName);
	}



}
