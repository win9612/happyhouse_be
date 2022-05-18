package com.rest.api.controller;

import com.rest.api.model.dto.BaseAddressDto;
import com.rest.api.model.dto.HouseInfoDto;
import com.rest.api.model.service.SearchService;
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
@RequestMapping("/apt-search")
@CrossOrigin("*")
public class SearchController {

    private final Logger logger = LoggerFactory.getLogger(SearchController.class);
    private final SearchService searchService;

    @ApiOperation(value = "입력keyword가 '구' 또는 '동'으로 끝날 때 해당하는 지역 리스트를 반환한다.", response = List.class)
    @GetMapping("/dong")
    public ResponseEntity<?> searchDongList(@RequestParam("keyword") String keyword) throws Exception {
        if(keyword.length() >= 2 &&
                keyword.substring(keyword.length()-1, keyword.length()).equals("구")){
            logger.debug("dongList by gugun : {}", searchService.getDongListByGugun(keyword));
            return new ResponseEntity<List<BaseAddressDto>>(searchService.getDongListByGugun(keyword), HttpStatus.OK);
        } else if(keyword.length() >= 2 &&
                keyword.substring(keyword.length()-1, keyword.length()).equals("동")){
            logger.debug("dongList by dong : {}", searchService.getDongListByDong(keyword));
            System.out.println(searchService.getDongListByDong(keyword).toString());
            return new ResponseEntity<List<BaseAddressDto>>(searchService.getDongListByDong(keyword), HttpStatus.OK);
        }
        // 글자 수가 1글자 이하고 구나 동으로 끝나지 않을 경우
        return null;
    }

    @ApiOperation(value = "입력keyword가 '동'으로 끝날 때 해당하는 아파트 리스트를 반환한다.", response = List.class)
    @GetMapping("/apt")
    public ResponseEntity<?> searchAptList(@RequestParam("keyword") String keyword) throws Exception {
        if(keyword.length() >= 2 &&
                keyword.substring(keyword.length()-1, keyword.length()).equals("동")){
            logger.debug("aptList : {}", searchService.getAptListByDong(keyword));
            return new ResponseEntity<List<HouseInfoDto>>(searchService.getAptListByDong(keyword), HttpStatus.OK);
        }
        return null;
    }

    @ApiOperation(value = "아파트 이름으로 검색하면 아파트 리스트 반환", response = List.class)
    @GetMapping("/aptName")
    public ResponseEntity<?> searcAptList(@RequestParam("keyword") String keyword) throws Exception {
        // 키워드 길이가 2이상
        if(keyword.length() >= 2) {
            return new ResponseEntity<>(searchService.getAptListBtAptName(keyword), HttpStatus.OK);
        }
        return null;
    }
}
