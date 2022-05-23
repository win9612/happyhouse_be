package com.rest.api.controller;

import com.rest.api.model.dto.OverlayDto;
import com.rest.api.model.service.OverlayService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"overlay 찍을 데이터 api"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/overlay")
@CrossOrigin
public class OverlayController {

    private final OverlayService overlayService;

    @GetMapping("/sidoList")
    public ResponseEntity<List<OverlayDto>> sidoList() {
        return new ResponseEntity<List<OverlayDto>>(overlayService.getSidoList(), HttpStatus.OK);
    }
    @GetMapping("/gugunList")
    public ResponseEntity<List<OverlayDto>> gugunList() {
        return new ResponseEntity<List<OverlayDto>>(overlayService.getGugunList(), HttpStatus.OK);
    }

    @GetMapping("/dongList")
    public ResponseEntity<List<OverlayDto>> dongList(@RequestParam("startLat")String startLat, @RequestParam("startLng")String startLng,
                                                     @RequestParam("endLat")String endLat, @RequestParam("endLng")String endLng) {
        return new ResponseEntity<List<OverlayDto>>(overlayService.getDongList(startLat, startLng, endLat, endLng), HttpStatus.OK);
    }

    @GetMapping("/aptList")
    public ResponseEntity<List<OverlayDto>> aptList(@RequestParam("startLat")String startLat, @RequestParam("startLng")String startLng,
                                                     @RequestParam("endLat")String endLat, @RequestParam("endLng")String endLng) {
        return new ResponseEntity<List<OverlayDto>>(overlayService.getAptList(startLat, startLng, endLat, endLng), HttpStatus.OK);
    }
}
