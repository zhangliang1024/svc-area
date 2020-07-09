package com.ncme.svc.area.Respository;

import com.ncme.svc.area.entity.PositionVillage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @Author: colin
 * @Date: 2019/3/21 10:58
 * @Description:
 * @Version: V1.0
 */
public interface PositionVillageRespository extends JpaRepository<PositionVillage,Integer> {

    @Query("select p.provinceName As provinceName from PositionVillage p GROUP BY p.provinceName")
    List<String> findAllProvinceNameGroupByProvinceName();


    @Query("select p.cityName As cityName,p.cityCode As cityCode from PositionVillage p where p.provinceName = (?1)GROUP BY p.cityName,p.cityCode")
    List<Map<String,String>> findByProvinceNameGroupByCityNameAndCityCode(String provinceName);

    @Query("select p.countyName As countyName,p.countyCode As countyCode from PositionVillage p where p.cityName = (?1)GROUP BY p.countyName,p.countyCode")
    List<Map<String,String>> findByCityNameGroupByCountyNameAndCountyCode(String cityName);

}
