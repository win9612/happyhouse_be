package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.InterestDto;
import com.ssafy.happyhouse.model.mapper.InterestMapper;

@Service
public class InterestServiceImpl implements InterestService{
	
	@Autowired
	private InterestMapper interestMapper;

	@Override
	@Transactional
	public void addInterest(InterestDto interestDto) throws Exception {
		interestMapper.addInterest(interestDto);
	}

	@Override
	public List<HouseInfoDto> selectList(int no) throws Exception {
		return interestMapper.selectList(no);
	}

	@Override
	public int checkInterest(int no, int aptCode) throws Exception {
		return interestMapper.checkInterest(no, aptCode);
	}

	@Override
	@Transactional
	public void deleteInterest(int no, int aptCode) throws Exception {
		interestMapper.deleteInterest(no, aptCode);
	}

}
