package com.rest.api.controller.house;

import java.util.List;

import com.rest.api.model.dto.house.HouseDealDto;
import com.rest.api.model.dto.house.HouseInfoDto;
import com.rest.api.model.service.house.HouseInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/houseinfo")
@CrossOrigin("*")
public class HouseInfoController {
	
	private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);
	private final HouseInfoService houseInfoService;

	@ApiOperation(value = "aptCode에 해당하는 아파트 정보를 반환한다.", response = HouseInfoDto.class)
	@GetMapping("/list/{aptCode}")
	@ResponseBody
	public ResponseEntity<HouseInfoDto> houseinfo(@PathVariable("aptCode") long aptCode) throws Exception{
		return new ResponseEntity<HouseInfoDto>(houseInfoService.getHouseInfo(aptCode), HttpStatus.OK);
	}

	@ApiOperation(value = "aptCode에 해당하는 아파트의 거래 정보 리스트를 반환한다.", response = List.class)
	@GetMapping("/deal/{aptCode}")
	@ResponseBody
	public ResponseEntity<List<HouseDealDto>> housedeal(@PathVariable("aptCode") long aptCode) throws Exception{
		return new ResponseEntity<List<HouseDealDto>>(houseInfoService.getHouseDealList(aptCode), HttpStatus.OK);
	}
}
