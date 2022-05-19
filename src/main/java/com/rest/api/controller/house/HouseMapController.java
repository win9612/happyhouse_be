package com.rest.api.controller.house;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.rest.api.model.dto.house.BaseAddressDto;
import com.rest.api.model.dto.house.HouseInfoDto;
import com.rest.api.model.dto.house.SidoGugunCodeDto;
import com.rest.api.model.service.house.BaseAddressService;
import com.rest.api.model.service.house.HouseMapService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8080/swagger-ui.html
@RestController
@RequiredArgsConstructor
@RequestMapping("/map")
@CrossOrigin("*")
public class HouseMapController {
	
	private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);
	private final HouseMapService haHouseMapService;
	private final BaseAddressService baService;

	@ApiOperation(value = "시도 리스트를 반환한다.", response = List.class)
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> sidoList() throws Exception {
		logger.debug("sido : {}", haHouseMapService.getSido());
		return new ResponseEntity<List<SidoGugunCodeDto>>(haHouseMapService.getSido(), HttpStatus.OK);
	}

	@ApiOperation(value = "sido에 해당하는 gugun 리스트를 반환한다.", response = List.class)
	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunCodeDto>> gugunList(@RequestParam("sido") String sido) throws Exception {
		return new ResponseEntity<List<SidoGugunCodeDto>>(haHouseMapService.getGugunInSido(sido), HttpStatus.OK);
	}

	@ApiOperation(value = "gugun에 해당하는 dong 리스트를 반환한다.", response = List.class)
	@GetMapping("/dong")
	public ResponseEntity<List<HouseInfoDto>> dongList(@RequestParam("gugun") String gugun) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getDongInGugun(gugun), HttpStatus.OK);
	}

	@ApiOperation(value = "dong에 존재하는 아파트 리스트를 반환한다.", response = List.class)
	@GetMapping("/apt")
	public ResponseEntity<List<HouseInfoDto>> aptList(@RequestParam("dong") String dong, HttpSession session) throws Exception {
		System.out.println("/map/apt?dong= " + dong + " => " + haHouseMapService.getSido().toString());
		return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getAptInDong(dong), HttpStatus.OK);
	}

	@ApiOperation(value = "dongCode에 해당하는 동 객체를 반환한다.")
	@GetMapping("/dong-info")
	public ResponseEntity<BaseAddressDto> dongOne(@RequestParam("dong") String dong) throws Exception{
		System.out.println(baService.getBaseAddressOne(dong));
		return new ResponseEntity<BaseAddressDto>(baService.getBaseAddressOne(dong), HttpStatus.OK);
	}

	@ApiOperation(value = "상권 점수 반환한다. #작업중", response = List.class)
	@GetMapping("/score")
	public ResponseEntity<List<HouseInfoDto>> scoreList(@RequestParam("dong") String dong) throws Exception{
		//return new ResponseEntity<List<HouseInfoScoreDto>>(haHouseMapService.getScoreList(dong), HttpStatus.OK);
		return null;
	}
}
