package com.ncme.svc.area.service;

import com.ncme.svc.area.SvcAreaApplicationTests;
import com.ncme.svc.area.entity.DictAdministrativeAreas;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Slf4j
public class DictAdministrativeAreasServiceTest extends SvcAreaApplicationTests {

    public static final String INIT_PROVINCE_CODE = "110000000000";
    public static final int INIT_PARENT_ID = 0;
    @Autowired
    private DictAdministrativeAreasService areasService;

    @Autowired
    private PositionVillageService positionVillageService;

    @Test
    public void saveDictAdministrativeAreas() {
        DictAdministrativeAreas areas = new DictAdministrativeAreas();
        areas.setAreaName("test1");
        areas.setAreaCode("000001");
        areas.setParentId(2);
        areasService.saveDictAdministrativeAreas(areas);
    }

    @Test
    public void batchInsertData(){
        //保存一级省份数据
        saveProviceData();
        //保存市级数据
        saveCityData();
        //保存县级数据
        saveCountyData();
    }

    private void saveCountyData() {
        log.info("==========>>>>>>>>>>: {}","保存县级数据开始..." );
        // 省级名集合
        List<String> byProvinceNameList = positionVillageService.findAllProvinceNameGroupByProvinceName();
        List<DictAdministrativeAreas> areasList = areasService.getDictAdministrativeAreasList();
        for (String provinceName : byProvinceNameList) {
            for (DictAdministrativeAreas areas : areasList) {
                // 省份名称相同
                if(provinceName.equals(areas.getAreaName())){
                    // 城市名集合
                    List<Map<String, String>> cityList = positionVillageService.findByProvinceNameGroupByCityNameAndCityCode(provinceName);
                    List<DictAdministrativeAreas> cityAreaList = areasService.getDictAdministrativeAreasList();
                    for (Map<String, String> map : cityList) {
                        for (DictAdministrativeAreas city : cityAreaList) {
                            // 市名称一致
                            if(map.get("cityName").equals(city.getAreaName())){
                                //县级名集合
                                List<Map<String, String>> countyList = positionVillageService.findByCityNameGroupByCountyNameAndCountyCode(city.getAreaName());
                                for (Map<String, String> countMap : countyList) {
                                    DictAdministrativeAreas countyArea = new DictAdministrativeAreas();
                                    if(countMap.get("countyCode") != null){
                                        countyArea.setAreaName(countMap.get("countyName"));
                                        countyArea.setAreaCode(countMap.get("countyCode"));
                                        countyArea.setParentId(city.getId());
                                        areasService.saveDictAdministrativeAreas(countyArea);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void saveCityData() {
        log.info("==========>>>>>>>>>>: {}","保存市级数据开始..." );
        List<String> byProvinceNameList = positionVillageService.findAllProvinceNameGroupByProvinceName();
        List<DictAdministrativeAreas> areasList = areasService.getDictAdministrativeAreasList();
        for (String provinceName : byProvinceNameList) {
            for (DictAdministrativeAreas areas : areasList) {
                // 省份名称相同
                if(provinceName.equals(areas.getAreaName())){
                    List<Map<String, String>> cityList = positionVillageService.findByProvinceNameGroupByCityNameAndCityCode(provinceName);
                    for (Map<String, String> map : cityList) {
                        DictAdministrativeAreas cityArea = new DictAdministrativeAreas();
                        cityArea.setAreaName(map.get("cityName"));
                        cityArea.setAreaCode(String.valueOf(map.get("cityCode")));
                        cityArea.setParentId(areas.getId());
                        areasService.saveDictAdministrativeAreas(cityArea);
                    }
                }
            }
        }
    }

    private void saveProviceData() {
        log.info("==========>>>>>>>>>>: {}","保存省级数据开始..." );
        List<String> byProvinceNameList = positionVillageService.findAllProvinceNameGroupByProvinceName();
        for (String provinceName : byProvinceNameList) {
            DictAdministrativeAreas areas = new DictAdministrativeAreas();
            areas.setAreaName(provinceName);
            areas.setAreaCode(INIT_PROVINCE_CODE);
            areas.setParentId(INIT_PARENT_ID);
            areasService.saveDictAdministrativeAreas(areas);
        }
    }
}