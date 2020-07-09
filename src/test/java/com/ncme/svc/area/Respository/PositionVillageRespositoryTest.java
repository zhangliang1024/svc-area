package com.ncme.svc.area.Respository;

import com.ncme.svc.area.SvcAreaApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class PositionVillageRespositoryTest extends SvcAreaApplicationTests {

    @Autowired
    private PositionVillageRespository positionVillageRespository;
    @Test
    public void findAllProvinceNameGroupByProvinceName() {
        List<String> byProvinceNameList = positionVillageRespository.findAllProvinceNameGroupByProvinceName();
        System.out.println(byProvinceNameList);
    }

    @Test
    public void findByProvinceNameGroupByCityNameAndCityCode() {
        List<Map<String,String>> list =
                positionVillageRespository.findByProvinceNameGroupByCityNameAndCityCode("四川省");
        for (Map<String, String> map : list) {
            String cityName = map.get("cityName");
            Object cityCode = map.get("cityCode");
            System.out.println(cityName + cityCode );
        }
    }

    @Test
    public void findByCityNameGroupByCountyNameAndCountyCode() {
        List<Map<String,String>> list =
                positionVillageRespository.findByCityNameGroupByCountyNameAndCountyCode("内江市");
        for (Map<String, String> map : list) {
            String cityName = map.get("countyName");
            String cityCode = map.get("countyCode");
            System.out.println(cityName + cityCode );
        }
    }
}