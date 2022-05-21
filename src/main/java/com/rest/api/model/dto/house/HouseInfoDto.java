package com.rest.api.model.dto.house;

public class HouseInfoDto {

	private long aptCode;
	private String apartmentName;
	private String dongCode;
	private String dong; // dongName
	private String sidoName;
	private String gugunName;
	private int buildYear;
	private String jibun;
	private String lat;
	private String lng;

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

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	public int getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}

	public String getJibun() {
		return jibun;
	}

	public void setJibun(String jibun) {
		this.jibun = jibun;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "HouseInfoDto{" +
				"aptCode=" + aptCode +
				", apartmentName='" + apartmentName + '\'' +
				", dongCode='" + dongCode + '\'' +
				", dong='" + dong + '\'' +
				", sidoName='" + sidoName + '\'' +
				", gugunName='" + gugunName + '\'' +
				", buildYear=" + buildYear +
				", jibun='" + jibun + '\'' +
				", lat='" + lat + '\'' +
				", lng='" + lng + '\'' +
				'}';
	}
}
