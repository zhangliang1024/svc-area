package com.ncme.svc.area.service.impl;

import com.ncme.svc.area.Respository.PositionVillageRespository;
import com.ncme.svc.area.entity.PositionVillage;
import com.ncme.svc.area.service.PositionVillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: colin
 * @Date: 2019/3/21 11:03
 * @Description:
 * @Version: V1.0
 */
@Service
public class PositionVillageServiceImpl implements PositionVillageService {

    @Autowired
    private PositionVillageRespository respository;

    @Override
    public List<PositionVillage> getPositionVillageList() {
        return respository.findAll();
    }

    @Override
    public List<String> findAllProvinceNameGroupByProvinceName() {
        return respository.findAllProvinceNameGroupByProvinceName();
    }

    @Override
    public List<Map<String, String>> findByProvinceNameGroupByCityNameAndCityCode(String provinceName) {
        return respository.findByProvinceNameGroupByCityNameAndCityCode(provinceName);
    }

    @Override
    public List<Map<String, String>> findByCityNameGroupByCountyNameAndCountyCode(String cityName) {
        return respository.findByCityNameGroupByCountyNameAndCountyCode(cityName);
    }


}
