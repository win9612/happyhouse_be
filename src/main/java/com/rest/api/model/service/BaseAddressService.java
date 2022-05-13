package com.rest.api.model.service;

import java.util.List;

import com.rest.api.model.dto.BaseAddressDto;
import com.rest.api.model.mapper.BaseAddressMapper;
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
