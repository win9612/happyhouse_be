package com.rest.api.model.service.board;

import com.rest.api.model.dto.board.NoticeBoardDto;
import com.rest.api.model.mapper.board.NoticeBoardMapper;;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeBoardService {

    private final NoticeBoardMapper noticeBoardMapper;

    @Transactional
    public void addArticle(NoticeBoardDto noticeBoardDto) throws Exception{
        noticeBoardMapper.addArticle(noticeBoardDto);
    }

    public int getTotalPage() throws Exception {
        int totalCount = noticeBoardMapper.getTotalCount();
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

    public List<NoticeBoardDto> getArticleList(int page) throws Exception{
        int start = (page * 10) - 10; // 고정된 수치. 이대로 해도 됨
        int end = 10; // 한 페이지당 몇 개를 리턴할 것인지

        return noticeBoardMapper.getArticleList(start, end);
    }

    public NoticeBoardDto getArticle(int bNo) throws Exception{
        return noticeBoardMapper.getArticle(bNo);
    }

    @Transactional
    public void updateArticle(NoticeBoardDto noticeBoardDto) throws Exception{
        noticeBoardMapper.updateArticle(noticeBoardDto);
    }

    @Transactional
    public void deleteArticle(int bNo) throws Exception {
        noticeBoardMapper.deleteArticle(bNo);
    }
}
