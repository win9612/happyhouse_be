package com.rest.api.model.mapper;

import com.rest.api.model.dto.QnaCommentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QnaCommentMapper {
    void addComment(QnaCommentDto qnaCommentDto) throws Exception;
    List<QnaCommentDto> getCommentList(@Param("bNo")int bNo) throws Exception;
    QnaCommentDto getComment(@Param("cNo")int cNo) throws Exception;
    void updateComment(QnaCommentDto qnaCommentDto) throws Exception;
    void deleteComment(@Param("cNo")int cNo) throws Exception;
}
