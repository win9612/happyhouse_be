package com.rest.api.controller.board;

import com.rest.api.controller.house.HouseMapController;
import com.rest.api.model.dto.board.NoticeBoardDto;
import com.rest.api.model.dto.board.QnaBoardDto;
import com.rest.api.model.service.board.NoticeBoardService;
import com.rest.api.response.ApiResponse;
import com.rest.api.response.ResponseMap;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notice-board")
@CrossOrigin("*")
public class NoticeBoardController {
    private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);
    private final NoticeBoardService noticeBoardService;

    @ApiOperation(value = "게시글 등록")
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody NoticeBoardDto noticeBoardDto) throws Exception {
        noticeBoardService.addArticle(noticeBoardDto);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 리스트 반환")
    @GetMapping("/getList")
    @ResponseBody
    public ApiResponse getList(@RequestParam("page")String page) throws Exception {
        /* page 변수 전처리 */
        if(page==null || page.equals(""))
            page = "1";

        /* 현재 페이지의 게시글 목록, 총 페이지 수, 현재 페이지 계산 */
        List<NoticeBoardDto> list = noticeBoardService.getArticleList(Integer.parseInt(page));
        int totalPage = noticeBoardService.getTotalPage();
        int currentPage = Integer.parseInt(page);

        /* 현재 페이지 기준 Navi바 구성 계산 */
        int pageNaviStartPage = noticeBoardService.getPageNaviStartPage(currentPage);
        int pageNaviEndPage = noticeBoardService.getPageNaviEndPage(currentPage);

        ResponseMap result = new ResponseMap();
        result.setResponseData("articleList", list);
        result.setResponseData("totalPage", totalPage);
        result.setResponseData("currentPage", currentPage);
        result.setResponseData("startPage", pageNaviStartPage);
        result.setResponseData("endPage", pageNaviEndPage);
        result.setCode(200);

        return result;
    }

    @ApiOperation(value = "키워드로 게시글 검색")
    @GetMapping("/search")
    @ResponseBody
    public ApiResponse getListByKeyword(@RequestParam("page")String page, @RequestParam("keyword")String keyword) throws Exception {
        /* page 변수 전처리 */
        if(page==null || page.equals(""))
            page = "1";

        /* 현재 페이지의 게시글 목록, 총 페이지 수, 현재 페이지 계산 */
        List<NoticeBoardDto> list = noticeBoardService.getArticleListByKeyword(Integer.parseInt(page), keyword);
        int totalPage = noticeBoardService.getTotalPageByKeyword(keyword);
        int currentPage = Integer.parseInt(page);

        /* 현재 페이지 기준 Navi바 구성 계산 */
        int pageNaviStartPage = noticeBoardService.getPageNaviStartPage(currentPage);
        int pageNaviEndPage = noticeBoardService.getPageNaviEndPage(currentPage, keyword);

        ResponseMap result = new ResponseMap();
        result.setResponseData("articleList", list);
        result.setResponseData("totalPage", totalPage);
        result.setResponseData("currentPage", currentPage);
        result.setResponseData("startPage", pageNaviStartPage);
        result.setResponseData("endPage", pageNaviEndPage);
        result.setCode(200);

        return result;
    }

    @ApiOperation(value = "bNo에 해당하는 게시글 하나 반환")
    @GetMapping("/getOne")
    @ResponseBody
    public ResponseEntity<NoticeBoardDto> getOne(@RequestParam("bNo")String bNo) throws Exception{
        return new ResponseEntity<NoticeBoardDto>(noticeBoardService.getArticle(Integer.parseInt(bNo)), HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 수정")
    @PutMapping("/modify")
    public ResponseEntity<String> modify(@RequestBody NoticeBoardDto noticeBoardDto) throws Exception{
        noticeBoardService.updateArticle(noticeBoardDto);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @ApiOperation(value = "bNo에 해당하는 게시글 삭제")
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam("bNo")String bNo) throws Exception{
        noticeBoardService.deleteArticle(Integer.parseInt(bNo));
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
