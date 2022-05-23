package com.rest.api.model.service;

import com.rest.api.model.dto.OverlayDto;
import com.rest.api.model.mapper.OverlayMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OverlayService {

    private final OverlayMapper overlayMapper;

    public List<OverlayDto> getSidoList() {
        return overlayMapper.getSidoList();
    }

    public List<OverlayDto> getGugunList() {
        return overlayMapper.getGugunList();
    }

    public List<OverlayDto> getDongList(String startLat, String startLng, String endLat, String endLng) {
        return overlayMapper.getDongList(startLat, startLng, endLat, endLng);
    }

    public List<OverlayDto> getAptList(String startLat, String startLng, String endLat, String endLng) {
        return overlayMapper.getAptList(startLat, startLng, endLat, endLng);
    }
}
