package com.rest.api.controller;

import com.rest.api.model.dto.BaseAddressDto;
import com.rest.api.model.dto.HouseInfoDto;
import com.rest.api.model.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apt-search")
@CrossOrigin("*")
@RequiredArgsConstructor
public class SearchController {

    private final Logger logger = LoggerFactory.getLogger(SearchController.class);
    private final SearchService searchService;

    @GetMapping("/dong/{keyword}")
    public ResponseEntity<?> searchDongList(@PathVariable("keyword") String keyword) throws Exception {
        System.out.println(keyword);
        System.out.println(keyword.length());
        System.out.println(keyword.substring(keyword.length()-1, keyword.length()));
        if(keyword.length() >= 2 &&
                keyword.substring(keyword.length()-1, keyword.length()).equals("구")){
            logger.debug("dongList by gugun : {}", searchService.getDongListByGugun(keyword));
            System.out.println(searchService.getDongListByGugun(keyword).toString());
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

    @GetMapping("/apt/{keyword}")
    public ResponseEntity<?> searchAptList(@PathVariable("keyword") String keyword) throws Exception {
        if(keyword.length() >= 2 &&
                keyword.substring(keyword.length()-1, keyword.length()).equals("동")){
            logger.debug("aptList : {}", searchService.getAptListByDong(keyword));
            return new ResponseEntity<List<HouseInfoDto>>(searchService.getAptListByDong(keyword), HttpStatus.OK);
        }
        return null;
    }
}
