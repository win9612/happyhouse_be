package com.rest.api.model.mapper.board;

import com.rest.api.model.dto.board.NoticeBoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeBoardMapper {
    void addArticle(NoticeBoardDto qnaBoardDto) throws Exception;
    List<NoticeBoardDto> getArticleList(@Param("start")int start, @Param("end")int end) throws Exception;
    NoticeBoardDto getArticle(@Param("bNo")int bNo) throws Exception;
    void updateArticle(NoticeBoardDto noticeBoardDto) throws Exception;
    void deleteArticle(@Param("bNo")int bNo) throws Exception;

    int getTotalCount() throws Exception;
}
