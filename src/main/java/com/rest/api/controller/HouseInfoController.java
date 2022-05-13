package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.service.HouseInfoService;

@Controller
@RequestMapping("/houseinfo")
@CrossOrigin("*")
public class HouseInfoController {
	
	private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);

	@Autowired
	private HouseInfoService houseInfoService;
	
	@GetMapping("/{aptCode}")
	public String house() throws Exception {
		return "house/houseinfo";
	}
	
	@GetMapping("/list/{aptCode}")
	@ResponseBody
	public ResponseEntity<HouseInfoDto> houseinfo(@PathVariable("aptCode") int aptCode) throws Exception{
		return new ResponseEntity<HouseInfoDto>(houseInfoService.getHouseInfo(aptCode), HttpStatus.OK);
	}
	
	@GetMapping("/deal/{aptCode}")
	@ResponseBody
	public ResponseEntity<List<HouseDealDto>> housedeal(@PathVariable("aptCode") int aptCode) throws Exception{
		return new ResponseEntity<List<HouseDealDto>>(houseInfoService.getHouseDealList(aptCode), HttpStatus.OK);
	}
	
}
