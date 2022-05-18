package com.rest.api.model.dto;

import org.springframework.stereotype.Repository;

@Repository
public class QnaCommentDto {
    private int cNo; // 코멘트 번호
    private int bNo; // 게시물 번호
    private String cWriterEmail; // 작성자 이메일
    private String cWriterName; // 작성자 이름
    private String cContent; // 내용
    private String bWriteDate; // 작성일시
    private String bModifyDate; // 수정일시

    public int getbNo() {
        return bNo;
    }

    public void setbNo(int bNo) {
        this.bNo = bNo;
    }

    public int getcNo() {
        return cNo;
    }

    public void setcNo(int cNo) {
        this.cNo = cNo;
    }

    public String getcWriterEmail() {
        return cWriterEmail;
    }

    public void setcWriterEmail(String cWriterEmail) {
        this.cWriterEmail = cWriterEmail;
    }

    public String getcWriterName() {
        return cWriterName;
    }

    public void setcWriterName(String cWriterName) {
        this.cWriterName = cWriterName;
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
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
