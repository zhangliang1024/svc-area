package com.ncme.svc.area.service;

import com.ncme.svc.area.dto.DictAdministrativeAreasDTO;
import com.ncme.svc.area.entity.DictAdministrativeAreas;

import java.util.List;

/**
 * @Author: colin
 * @Date: 2019/3/21 11:57
 * @Description:
 * @Version: V1.0
 */
public interface DictAdministrativeAreasService {

    /**
     * 保存行政区域数据
     * @param administrativeAreas
     */
    void saveDictAdministrativeAreas(DictAdministrativeAreas administrativeAreas);

    /**
     * 查询所有行政区域数据
     * @return
     */
    List<DictAdministrativeAreas> getDictAdministrativeAreasList();

    /**
     * 根据上级行政区域Id，查询下级行政区域集合
     * @param parentId
     * @return
     */
    List<DictAdministrativeAreasDTO> getAreaListByParentId(Integer parentId);

    /**
     * 查询所有的省级行政区域集合 TODO
     * @return
     */
    List<DictAdministrativeAreas> getProvinceList();

    /**
     * 根据上级省份行政区域Id，查询下级城市行政区域集合 TODO
     * @param provinceId
     * @return
     */
    List<DictAdministrativeAreas> getCityList(Integer provinceId);

    /**
     * 根据上级城市行政区域Id，查询下级区县行政区域集合 TODO
     * @param cityId
     * @return
     */
    List<DictAdministrativeAreas> getCountyList(Integer cityId);

}
