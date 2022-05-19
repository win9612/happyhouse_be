package com.rest.api.model.service.board;

import com.rest.api.model.dto.board.QnaCommentDto;
import com.rest.api.model.mapper.board.QnaCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QnaCommentService {

    private final QnaCommentMapper qnaCommentMapper;

    @Transactional
    public void addComment(QnaCommentDto qnaCommentDto) throws Exception{
        qnaCommentMapper.addComment(qnaCommentDto);
    }

    public List<QnaCommentDto> getCommentList(int bNo) throws Exception{
        return qnaCommentMapper.getCommentList(bNo);
    }

    public QnaCommentDto getComment(int cNo) throws Exception{
        return qnaCommentMapper.getComment(cNo);
    }

    @Transactional
    public void updateComment(QnaCommentDto qnaCommentDto) throws Exception{
        qnaCommentMapper.updateComment(qnaCommentDto);
    }

    @Transactional
    public void deleteComment(int cNo) throws Exception {
        qnaCommentMapper.deleteComment(cNo);
    }
}
