package com.rest.api.controller;

import com.rest.api.model.dto.house.BaseAddressDto;
import com.rest.api.model.service.RecommandService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@Api(tags = {"추천 컨트롤러"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/recommand")
@CrossOrigin
public class RecommandControlller {

    private final RecommandService recommandService;

    @GetMapping("/dong")
    public ResponseEntity<?> recommandDong(@RequestHeader("token")String token) throws Exception {
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String[] chunks = token.split("\\.");

        String payload = new String(decoder.decode((chunks[1])));

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(payload);

        String email = (String) jsonObject.get("email");
        return new ResponseEntity<List<BaseAddressDto>>(recommandService.recommandRegion(email), HttpStatus.OK);
    }

}
