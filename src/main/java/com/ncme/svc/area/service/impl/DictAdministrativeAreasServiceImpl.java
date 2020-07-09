package com.ncme.svc.area.service.impl;

import com.ncme.svc.area.Respository.DictAdministrativeAreasRespository;
import com.ncme.svc.area.dto.DictAdministrativeAreasDTO;
import com.ncme.svc.area.entity.DictAdministrativeAreas;
import com.ncme.svc.area.service.DictAdministrativeAreasService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: colin
 * @Date: 2019/3/21 11:59
 * @Description:
 * @Version: V1.0
 */
@Service
public class DictAdministrativeAreasServiceImpl implements DictAdministrativeAreasService {

    public static final Integer INIT_PARENT_ID = 0;

    @Autowired
    private DictAdministrativeAreasRespository respository;

    @Override
    public void saveDictAdministrativeAreas(DictAdministrativeAreas administrativeAreas) {
        respository.save(administrativeAreas);
    }

    @Override
    public List<DictAdministrativeAreas> getDictAdministrativeAreasList() {
        return respository.findAll();
    }

    @Override
    public List<DictAdministrativeAreas> getProvinceList() {
        return respository.findAllByParentId(INIT_PARENT_ID);
    }

    @Override
    public List<DictAdministrativeAreas> getCityList(Integer provinceId) {
        return null;
    }

    @Override
    public List<DictAdministrativeAreas> getCountyList(Integer cityId) {
        return null;
    }

    @Override
    public List<DictAdministrativeAreasDTO> getAreaListByParentId(Integer parentId) {

        List<DictAdministrativeAreas> areasList = respository.findAllByParentId(parentId);
        List<DictAdministrativeAreasDTO> areasDTOList = areasList.stream().map(e -> {
            DictAdministrativeAreasDTO areasDTO = new DictAdministrativeAreasDTO();
            BeanUtils.copyProperties(e, areasDTO);
            return areasDTO;
        }).collect(Collectors.toList());
        return areasDTOList;
    }
}
