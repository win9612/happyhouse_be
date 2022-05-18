package com.rest.api.model.dto;

public class QnaBoardDto {
    private int bNo; // 게시글 번호
    private String bWriterEmail; // 글 작성자 이메일
    private String bWriterName; // 글 작성자 이름
    private String bTitle; // 글 제목
    private String bContent; // 글 내용
    private int bHits; // 글 조회수
    private String bWriteDate; // 글 작성일시
    private String bModifyDate; // 글 수정일시

    public int getbNo() {
        return bNo;
    }

    public void setbNo(int bNo) {
        this.bNo = bNo;
    }

    public String getbWriterEmail() {
        return bWriterEmail;
    }

    public void setbWriterEmail(String bWriterEmail) {
        this.bWriterEmail = bWriterEmail;
    }

    public String getbWriterName() {
        return bWriterName;
    }

    public void setbWriterName(String bWriterName) {
        this.bWriterName = bWriterName;
    }

    public String getbTitle() {
        return bTitle;
    }

    public void setbTitle(String bTitle) {
        this.bTitle = bTitle;
    }

    public String getbContent() {
        return bContent;
    }

    public void setbContent(String bContent) {
        this.bContent = bContent;
    }

    public int getbHits() {
        return bHits;
    }

    public void setbHits(int bHits) {
        this.bHits = bHits;
    }

    public String getbWriteDate() {
        return bWriteDate;
    }

    public void setbWriteDate(String bWriteDate) {
        this.bWriteDate = bWriteDate;
    }

    public String getbModifyDate() {
        return bModifyDate;
    }

    public void setbModifyDate(String bModifyDate) {
        this.bModifyDate = bModifyDate;
    }
}
