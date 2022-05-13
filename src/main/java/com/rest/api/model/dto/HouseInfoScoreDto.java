package com.rest.api.model.dto;

public class HouseInfoScoreDto {
	private HouseInfoDto houseinfo;
	private int score;
	
	public HouseInfoScoreDto() {
	}

	public HouseInfoDto getHouseinfo() {
		return houseinfo;
	}

	public void setHouseinfo(HouseInfoDto houseinfo) {
		this.houseinfo = houseinfo;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
