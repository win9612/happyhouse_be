package com.rest.api.model.mapper.board;

import com.rest.api.model.dto.board.QnaBoardDto;
import com.rest.api.model.dto.board.SearchParameter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QnaBoardMapper {
    void addArticle(QnaBoardDto qnaBoardDto) throws Exception;
    List<QnaBoardDto> getArticleList(SearchParameter searchParameter) throws Exception;
    List<QnaBoardDto> getArticleListByKeyword(SearchParameter searchParameter);
    QnaBoardDto getArticle(@Param("bNo")int bNo) throws Exception;
    void updateArticle(QnaBoardDto qnaBoardDto) throws Exception;
    void deleteArticle(@Param("bNo")int bNo) throws Exception;

    int getTotalCount() throws Exception;
    int getTotalCountByKeyword(@Param("keyword")String keyword) throws Exception;
}
