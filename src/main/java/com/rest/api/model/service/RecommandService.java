package com.rest.api.model.service;

import com.rest.api.model.dto.house.BaseAddressDto;
import com.rest.api.model.mapper.RecommandMapper;
import com.rest.api.model.mapper.house.BaseAddressMapper;
import com.rest.api.model.mapper.house.HouseInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RecommandService {

    private final RecommandMapper recommandMapper;
    private final BaseAddressMapper baseAddressMapper;
    private final HouseInfoMapper houseInfoMapper;

    public int updateRegion(String email, String aptCode) throws Exception {

        String[] region = null;
        String newRegionCode = houseInfoMapper.getHouseInfo(Long.parseLong(aptCode)).getDongCode();

        try {
            region = this.getRegion(email).split(",");
        } catch (Exception e) {
            return recommandMapper.updateRegion(email, aptCode);
        }


        if (region.length == 10) { // 추가하려는데 이미 지역 갯수가 10개인경우
            for (int j = 0; j < 9; j++) {
                region[j] = region[j + 1];
            }
            region[9] = newRegionCode;
        } else { // 지역갯수 10개 미만
            String[] result = Arrays.copyOf(region, region.length + 1);
            result[result.length - 1] = newRegionCode;
            region = result;
        }

        String result = "";

        for (String str : region)
            result += str + ",";

//		System.out.println(result);
        return recommandMapper.updateRegion(email, result);
    }
    public String getRegion(String email) throws Exception {
        return recommandMapper.selectRegion(email);
    }

    public List<BaseAddressDto> recommandRegion(String email) throws Exception {
        String region = this.getRegion(email);
        Map<String, Double> recommandMap = new HashMap();
        List<BaseAddressDto> result = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(region == null ? "" : region, ",");
        while (st.hasMoreTokens()) {
            String code = st.nextToken();
            BaseAddressDto baDto = baseAddressMapper.getBaseAddressOne(code); // 동 정보
            System.out.println("dong=> " + baDto.toString());
            String sidoName = baDto.getSidoName();
            List<BaseAddressDto> list = baseAddressMapper.getBaseAddressBySido(sidoName); // 추천 후보 목록

            for (BaseAddressDto ba : list) { // 추천 후보목록 결과 Map에 저장

                double dist = getDistance(Double.parseDouble(ba.getLat()), Double.parseDouble(ba.getLng()),
                        Double.parseDouble(baDto.getLat()), Double.parseDouble(baDto.getLng()));

                if (recommandMap.containsKey(ba.getDongCode())) { // 맵에 있으면
                    double defaultValue = recommandMap.get(ba.getDongCode());
                    recommandMap.put(ba.getDongCode(), dist > defaultValue ? defaultValue : dist);
                } else {
                    recommandMap.put(ba.getDongCode(), dist);
                }
            }
        }

        List<Map.Entry<String, Double>> entryList = new LinkedList<Map.Entry<String, Double>>(recommandMap.entrySet());

        entryList.sort(Map.Entry.comparingByValue()); // 거리순서로 정렬

        int i = 0;
        for (Map.Entry<String, Double> entry : entryList) { // 가장 가까운 지역 5개 리스트에 추가
            if (i == 5)
                break;
            result.add(baseAddressMapper.getBaseAddressOne(entry.getKey()));
            i++;
        }

        return result;
    }

    public double getDistance(double x, double y, double x1, double y1) {
        double d;
        double xd, yd;
        yd = Math.pow(y1 - y, 2);
        xd = Math.pow(x1 - x, 2);
        d = Math.sqrt(yd + xd);
        return d;
    }
}
