package com.rest.api.model.mapper.board;

import com.rest.api.model.dto.board.QnaBoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QnaBoardMapper {
    void addArticle(QnaBoardDto qnaBoardDto) throws Exception;
    List<QnaBoardDto> getArticleList(@Param("start")int start, @Param("end")int end) throws Exception;
    QnaBoardDto getArticle(@Param("bNo")int bNo) throws Exception;
    void updateArticle(QnaBoardDto qnaBoardDto) throws Exception;
    void deleteArticle(@Param("bNo")int bNo) throws Exception;

    int getTotalCount() throws Exception;
}
