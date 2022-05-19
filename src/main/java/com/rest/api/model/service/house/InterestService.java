package com.rest.api.model.service.house;

import java.util.List;

import com.rest.api.model.dto.house.HouseInfoDto;
import com.rest.api.model.dto.house.InterestDto;
import com.rest.api.model.mapper.house.InterestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InterestService {

	private final InterestMapper interestMapper;

	@Transactional
	public void addInterest(InterestDto interestDto) throws Exception {
		interestMapper.addInterest(interestDto);
	}

	public List<HouseInfoDto> selectList(int no) throws Exception {
		return interestMapper.selectList(no);
	}

	public int checkInterest(int no, int aptCode) throws Exception {
		return interestMapper.checkInterest(no, aptCode);
	}

	@Transactional
	public void deleteInterest(int no, int aptCode) throws Exception {
		interestMapper.deleteInterest(no, aptCode);
	}

}
