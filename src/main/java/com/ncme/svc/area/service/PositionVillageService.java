package com.ncme.svc.area.service;

import com.ncme.svc.area.entity.PositionVillage;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @Author: colin
 * @Date: 2019/3/21 11:01
 * @Description:
 * @Version: V1.0
 */
public interface PositionVillageService {
    /**
     * 获取 PositionVillage 集合
     * @return List<PositionVillage>
     */
    List<PositionVillage> getPositionVillageList();

    /**
     * 获取所有一级省份的名称
     * @return List<String>
     */
    List<String> findAllProvinceNameGroupByProvinceName();

    /**
     * 获取所有二级市的名称，根据身份名称
     * @return List<Map<String,String>>
     */
    List<Map<String,String>> findByProvinceNameGroupByCityNameAndCityCode(String provinceName);

    /**
     * 获取所有三级县的名称，根据市的名称
     * @return List<Map<String,String>>
     */
    List<Map<String,String>> findByCityNameGroupByCountyNameAndCountyCode(String cityName);

}
