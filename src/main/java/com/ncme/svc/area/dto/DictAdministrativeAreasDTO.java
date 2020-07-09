package com.ncme.svc.area.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: colin
 * @Date: 2019/3/22 19:03
 * @Description:
 * @Version: V1.0
 */
@Data
public class DictAdministrativeAreasDTO implements Serializable {

    private Integer id;
    private String areaName;
    private String areaCode;

}
