package com.rest.api.controller;

import com.rest.api.model.dto.QnaBoardDto;
import com.rest.api.model.service.QnaBoardService;
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
@RequestMapping("/qna-board")
@CrossOrigin("*")
public class QnaBoardController {
    private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);
    private final QnaBoardService qnaBoardService;

    @ApiOperation(value = "게시글 등록")
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody QnaBoardDto qnaBoardDto) throws Exception {
        System.out.println(qnaBoardDto.getbTitle());
        qnaBoardService.addArticle(qnaBoardDto);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 리스트 반환")
    @GetMapping("/getList")
    @ResponseBody
    public ResponseEntity<List<QnaBoardDto>> getList() throws Exception {
        return new ResponseEntity<List<QnaBoardDto>>(qnaBoardService.getArticleList(), HttpStatus.OK);
    }

    @ApiOperation(value = "bNo에 해당하는 게시글 하나 반환")
    @GetMapping("/getOne")
    @ResponseBody
    public ResponseEntity<QnaBoardDto> getOne(@RequestParam("bNo")String bNo) throws Exception{
        return new ResponseEntity<QnaBoardDto>(qnaBoardService.getArticle(Integer.parseInt(bNo)), HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 수정")
    @PutMapping("/modify")
    public ResponseEntity<String> modify(@RequestBody QnaBoardDto qnaBoardDto) throws Exception{
        qnaBoardService.updateArticle(qnaBoardDto);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @ApiOperation(value = "bNo에 해당하는 게시글 삭제")
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam("bNo")String bNo) throws Exception{
        qnaBoardService.deleteArticle(Integer.parseInt(bNo));
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
