package com.rest.api.model.dto.house;

public class BaseAddressDto {
	private int no;
	private String sidoName;
	private String gugunName;
	private String dongName;
	private String dongCode;
	private String lat;
	private String lng;

	public BaseAddressDto() {
		super();
	}

	public BaseAddressDto(int no, String sidoName, String gugunName, String dongName, String dongCode, String lat,
			String lng) {
		this.no = no;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
		this.dongCode = dongCode;
		this.lat = lat;
		this.lng = lng;
	}

	public BaseAddressDto(String sidoName, String gugunName, String dongName, String dongCode, String lat, String lng) {
		super();
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
		this.dongCode = dongCode;
		this.lat = lat;
		this.lng = lng;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getDongname() {
		return dongName;
	}

	public void setDongname(String dongname) {
		this.dongName = dongname;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
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
		return "BaseAddressDto [sidoName=" + sidoName + ", gugunName=" + gugunName + ", dongname=" + dongName
				+ ", dongCode=" + dongCode + ", lat=" + lat + ", lng=" + lng + "]";
	}

}
