package com.rest.api.controller;

import com.rest.api.model.dto.QnaBoardDto;
import com.rest.api.model.dto.QnaCommentDto;
import com.rest.api.model.service.QnaBoardService;
import com.rest.api.model.service.QnaCommentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qna-comment")
@CrossOrigin("*")
public class QnaCommentController {
    private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);
    private final QnaCommentService qnaCommentService;

    @ApiOperation(value = "코멘트 등록")
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody QnaCommentDto qnaCommentDto) throws Exception {
        System.out.println(qnaCommentDto.toString());
        qnaCommentService.addComment(qnaCommentDto);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @ApiOperation(value = "코멘트 리스트 반환")
    @GetMapping("/getList")
    @ResponseBody
    public ResponseEntity<List<QnaCommentDto>> getList(@RequestParam("bNo")int bNo) throws Exception {
        return new ResponseEntity<List<QnaCommentDto>>(qnaCommentService.getCommentList(bNo), HttpStatus.OK);
    }

    @ApiOperation(value = "cNo에 해당하는 게시글 하나 반환")
    @GetMapping("/getOne")
    @ResponseBody
    public ResponseEntity<QnaCommentDto> getOne(@RequestParam("cNo")int cNo) throws Exception{
        return new ResponseEntity<QnaCommentDto>(qnaCommentService.getComment(cNo), HttpStatus.OK);
    }

    @ApiOperation(value = "코멘트 수정")
    @PutMapping("/modify")
    public ResponseEntity<String> modify(@RequestBody QnaCommentDto qnaCommentDto) throws Exception{
        qnaCommentService.updateComment(qnaCommentDto);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @ApiOperation(value = "cNo에 해당하는 게시글 삭제")
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam("cNo")int cNo) throws Exception{
        qnaCommentService.deleteComment(cNo);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
