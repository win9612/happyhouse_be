package com.rest.api.model.mapper;

import com.rest.api.model.dto.OverlayDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OverlayMapper {
    public List<OverlayDto> getSidoList();

    public List<OverlayDto> getGugunList();

    public List<OverlayDto> getDongList(@Param("startLat") String startLat, @Param("startLng") String startLng,
                                        @Param("endLat") String endLat, @Param("endLng") String endLng);

    public List<OverlayDto> getAptList(@Param("startLat") String startLat, @Param("startLng") String startLng,
                                       @Param("endLat") String endLat, @Param("endLng") String endLng);
}
