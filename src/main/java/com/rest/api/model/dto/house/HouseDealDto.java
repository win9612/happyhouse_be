package com.rest.api.model.dto.house;

public class HouseDealDto {
	private long no; // 거래 번호
	private long aptCode; // 거래 아파트 코드
	private String apartmentName; // 아파트 이름
	private String dong; // 동 이름
	private String jibun; // 지번
	private int buildYear; // 건축년도
	private int dealYear; // 거래년도
	private int dealMonth; // 거래월
	private int dealDay; // 거래일
	private String dealAmount; // 거래 가격
	private String area; // 면적
	private String floor; // 층

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public long getAptCode() {
		return aptCode;
	}

	public void setAptCode(long aptCode) {
		this.aptCode = aptCode;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getJibun() {
		return jibun;
	}

	public void setJibun(String jibun) {
		this.jibun = jibun;
	}

	public int getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}

	public int getDealYear() {
		return dealYear;
	}

	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}

	public int getDealMonth() {
		return dealMonth;
	}

	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}

	public int getDealDay() {
		return dealDay;
	}

	public void setDealDay(int dealDay) {
		this.dealDay = dealDay;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return "HouseDealDto{" +
				"no=" + no +
				", aptCode=" + aptCode +
				", apartmentName='" + apartmentName + '\'' +
				", dong='" + dong + '\'' +
				", jibun='" + jibun + '\'' +
				", buildYear=" + buildYear +
				", dealYear=" + dealYear +
				", dealMonth=" + dealMonth +
				", dealDay=" + dealDay +
				", dealAmount='" + dealAmount + '\'' +
				", area='" + area + '\'' +
				", floor='" + floor + '\'' +
				'}';
	}
}
