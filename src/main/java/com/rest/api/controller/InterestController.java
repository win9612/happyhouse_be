package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.InterestDto;
import com.ssafy.happyhouse.model.service.InterestService;

@RestController
@RequestMapping("/interest")
public class InterestController {
	
	private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);
	
	@Autowired
	private InterestService interestService;
	
	@PostMapping("/add")
	public ResponseEntity addInterest(@RequestParam("no")String no, @RequestParam("aptCode")String aptCode) throws Exception {
		InterestDto dto = new InterestDto();	
		dto.setNo(Integer.parseInt(no));
		dto.setAptCode(Integer.parseInt(aptCode));
		interestService.addInterest(dto);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/check")
	public ResponseEntity<Integer> checkInterest(@RequestParam("no")String no, @RequestParam("aptCode")String aptCode) throws Exception{
		int result = interestService.checkInterest(Integer.parseInt(no), Integer.parseInt(aptCode));
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<HouseInfoDto>> selectList(@RequestParam("no")String no) throws NumberFormatException, Exception{
		List<HouseInfoDto> list = interestService.selectList(Integer.parseInt(no));
		return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity deleteInterest(@RequestParam("no")String no, @RequestParam("aptCode")String aptCode) throws Exception {
		
		System.out.println("no = "+no);
		interestService.deleteInterest(Integer.parseInt(no), Integer.parseInt(aptCode));
		return new ResponseEntity(HttpStatus.OK);
	}
}
