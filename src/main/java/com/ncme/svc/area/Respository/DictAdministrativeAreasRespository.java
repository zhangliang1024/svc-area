package com.ncme.svc.area.Respository;

import com.ncme.svc.area.entity.DictAdministrativeAreas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * @Author: colin
 * @Date: 2019/3/21 11:56
 * @Description:
 * @Version: V1.0
 */
public interface DictAdministrativeAreasRespository extends JpaRepository<DictAdministrativeAreas, Integer> {

    /**
     *  @Query("select d.id,d.parentId,d.areaCode,d.areaName from DictAdministrativeAreas d where d.parentId = (?1)")
     */
    @Query("select new com.ncme.svc.area.entity.DictAdministrativeAreas(d.id,d.parentId,d.areaCode,d.areaName) from DictAdministrativeAreas d where d.parentId = (?1)")
    List<DictAdministrativeAreas> findAllByParentId(Integer id);
}
