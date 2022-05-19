package com.rest.api.model.service.board;

import com.rest.api.model.dto.board.QnaBoardDto;
import com.rest.api.model.mapper.board.QnaBoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
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
        int totalCount = qnaBoardMapper.getTotalCount(); // 게시글 83개
        int totalPage = (int) Math.ceil((double)totalCount / 10); // 페이지 수 9개
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

    public List<QnaBoardDto> getArticleList(int page) throws Exception{
        int start = (page * 10) - 10; // 고정된 수치. 이대로 해도 됨
        int end = 10; // 한 페이지당 몇 개를 리턴할 것인지

        return qnaBoardMapper.getArticleList(start, end);
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
