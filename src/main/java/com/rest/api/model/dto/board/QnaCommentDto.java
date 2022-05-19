package com.rest.api.model.dto.board;

import org.springframework.stereotype.Repository;

@Repository
public class QnaCommentDto {
    private int cNo; // 코멘트 번호
    private int bNo; // 게시물 번호
    private String cWriterEmail; // 작성자 이메일
    private String cWriterName; // 작성자 이름
    private String cContent; // 내용
    private String cWriteDate; // 작성일시
    private String cModifyDate; // 수정일시

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

    public String getcWriteDate() {
        return cWriteDate;
    }

    public void setcWriteDate(String cWriteDate) {
        this.cWriteDate = cWriteDate;
    }

    public String getcModifyDate() {
        return cModifyDate;
    }

    public void setcModifyDate(String cModifyDate) {
        this.cModifyDate = cModifyDate;
    }

    @Override
    public String toString() {
        return "QnaCommentDto{" +
                "cNo=" + cNo +
                ", bNo=" + bNo +
                ", cWriterEmail='" + cWriterEmail + '\'' +
                ", cWriterName='" + cWriterName + '\'' +
                ", cContent='" + cContent + '\'' +
                ", cWriteDate='" + cWriteDate + '\'' +
                ", cModifyDate='" + cModifyDate + '\'' +
                '}';
    }
}
