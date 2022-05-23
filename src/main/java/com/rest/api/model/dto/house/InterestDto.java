package com.rest.api.model.dto.house;

public class InterestDto {

	private int interestNo;
	private int no; // 사용자 번호
	private long aptCode; // 아파트 번호

	public int getInterestNo() { return interestNo; }
	public void setInterestNo(int interestNo) { this.interestNo = interestNo; }
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public long getAptCode() {
		return aptCode;
	}
	public void setAptCode(long aptCode) {
		this.aptCode = aptCode;
	}

	@Override
	public String toString() {
		return "InterestDto{" +
				"interestNo=" + interestNo +
				", no=" + no +
				", aptCode=" + aptCode +
				'}';
	}
}
