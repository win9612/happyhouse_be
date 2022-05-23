package com.rest.api.controller.house;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rest.api.model.dto.house.HouseInfoDto;
import com.rest.api.model.dto.house.InterestDto;
import com.rest.api.model.service.house.InterestService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/interest")
@CrossOrigin("*")
public class InterestController {
	
	private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);
	private final InterestService interestService;

	@ApiOperation(value = "유저번호 no와 아파트번호 aptCode를 관심목록에 입력한다.", response = String.class)
	@PostMapping("/add")
	public ResponseEntity addInterest(@RequestBody InterestDto interestDto) throws Exception {
		interestService.addInterest(interestDto);
		return new ResponseEntity(HttpStatus.OK);
	}

	@ApiOperation(value = "유저번호 no와 아파트번호 aptCode에 해당하는 Interest가 존재하는지 확인한다. 존재할 경우 1을 반환하고, 없을 경우 0을 반환한다.", response = Integer.class)
	@GetMapping("/check")
	public ResponseEntity<Integer> checkInterest(@RequestParam("no")String no, @RequestParam("aptCode")String aptCode) throws Exception{
		int result = interestService.checkInterest(Integer.parseInt(no), Long.parseLong(aptCode));
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	@ApiOperation(value = "유저번호 no에 해당하는 관심목록 리스트를 반환한다.", response = List.class)
	@GetMapping("/list")
	public ResponseEntity<List<HouseInfoDto>> selectList(@RequestParam("no")String no) throws Exception{
		List<HouseInfoDto> list = interestService.selectList(Integer.parseInt(no));
		return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
	}

	@ApiOperation(value = "유저번호 no와 아파트번호 aptCode에 해당하는 Interest를 관심목록에서 삭제한다.", response = String.class)
	@DeleteMapping("/delete")
	public ResponseEntity deleteInterest(@RequestBody InterestDto interestDto) throws Exception {
		interestService.deleteInterest(interestDto);
		return new ResponseEntity(HttpStatus.OK);
	}
}
