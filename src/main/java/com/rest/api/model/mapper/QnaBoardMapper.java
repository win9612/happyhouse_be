package com.rest.api.model.mapper;

import com.rest.api.model.dto.QnaBoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QnaBoardMapper {
    void addArticle(QnaBoardDto qnaBoardDto) throws Exception;
    List<QnaBoardDto> getArticleList() throws Exception;
    QnaBoardDto getArticle(@Param("bNo")int bNo) throws Exception;
    void updateArticle(QnaBoardDto qnaBoardDto) throws Exception;
    void deleteArticle(@Param("bNo")int bNo) throws Exception;
}
