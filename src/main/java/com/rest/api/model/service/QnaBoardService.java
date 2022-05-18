package com.rest.api.model.service;

import com.rest.api.model.dto.QnaBoardDto;
import com.rest.api.model.mapper.QnaBoardMapper;
import com.rest.api.model.mapper.QnaCommentMapper;
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

    public List<QnaBoardDto> getArticleList() throws Exception{
        return qnaBoardMapper.getArticleList();
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
