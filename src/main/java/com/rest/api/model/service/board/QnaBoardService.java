package com.rest.api.model.service.board;

import com.rest.api.model.dto.board.QnaBoardDto;
import com.rest.api.model.dto.board.SearchParameter;
import com.rest.api.model.mapper.board.QnaBoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QnaBoardService {

    private final QnaBoardMapper qnaBoardMapper;

    @Transactional
    public void addArticle(QnaBoardDto qnaBoardDto) throws Exception{
        qnaBoardMapper.addArticle(qnaBoardDto);
    }

    public int getTotalPage() throws Exception {
        int totalCount = qnaBoardMapper.getTotalCount();
        int totalPage = (int) Math.ceil((double)totalCount / 10);
        return totalPage;
    }

    public int getTotalPageByKeyword(String keyword) throws Exception {
        int totalCount = qnaBoardMapper.getTotalCountByKeyword(keyword);
        int totalPage = (int) Math.ceil((double)totalCount / 10);
        return totalPage;
    }

    public int getPageNaviStartPage(int currentPage) throws Exception {
        if(currentPage <= 10){
            return 1;
        }
        double p = (double) currentPage / 10 - 0.1;
        p = Math.floor(p) + 0.1;
        int result = (int) p*10 + 1;

        return result;
    }

    public int getPageNaviEndPage(int currentPage) throws Exception {
        int result = getPageNaviStartPage(currentPage) + 9;
        if(result > getTotalPage()){
            result = getTotalPage();
        }

        return result;
    }

    public int getPageNaviEndPage(int currentPage, String keyword) throws Exception {
        int result = getPageNaviStartPage(currentPage) + 9;
        if(result > getTotalPageByKeyword(keyword)){
            result = getTotalPageByKeyword(keyword);
        }

        return result;
    }

    public List<QnaBoardDto> getArticleList(int page) throws Exception{
        int start = (page * 10) - 10; // 고정된 수치. 이대로 해도 됨
        int end = 10; // 한 페이지당 몇 개를 리턴할 것인지

        SearchParameter searchParameter = new SearchParameter();
        searchParameter.setStart(start);
        searchParameter.setEnd(end);
        return qnaBoardMapper.getArticleList(searchParameter);
    }

    public List<QnaBoardDto> getArticleListByKeyword(int page, String keyword) throws Exception{
        int start = (page * 10) - 10; // 고정된 수치. 이대로 해도 됨
        int end = 10; // 한 페이지당 몇 개를 리턴할 것인지

        SearchParameter searchParameter = new SearchParameter();
        searchParameter.setStart(start);
        searchParameter.setEnd(end);
        searchParameter.setKeyword(keyword);
        return qnaBoardMapper.getArticleListByKeyword(searchParameter);
    }

    public QnaBoardDto getArticle(int bNo) throws Exception{
        return qnaBoardMapper.getArticle(bNo);
    }

    @Transactional
    public void updateArticle(QnaBoardDto qnaBoardDto) throws Exception{
        qnaBoardMapper.updateArticle(qnaBoardDto);
    }

    @Transactional
    public void deleteArticle(int bNo) throws Exception {
        qnaBoardMapper.deleteArticle(bNo);
    }
}
