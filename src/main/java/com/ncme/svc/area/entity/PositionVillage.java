package com.ncme.svc.area.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: colin
 * @Date: 2019/3/21 10:53
 * @Description:
 * @Version: V1.0
 */
@Data
@Entity
public class PositionVillage {
    @Id
    @GeneratedValue
    private Integer id;
    private Long provinceCode;
    private String provinceName;
    private Long cityCode;
    private String cityName;
    private String countyCode;
    private String countyName;
    private String townCode;
    private String townName;
    private String villageCode;
    private String villageName;
    private String cityTownClassifyCode;

}
