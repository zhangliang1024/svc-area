package com.ncme.svc.area.controller;

import com.ncme.svc.area.dto.DictAdministrativeAreasDTO;
import com.ncme.svc.area.entity.DictAdministrativeAreas;
import com.ncme.svc.area.service.DictAdministrativeAreasService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: colin
 * @Date: 2019/3/21 18:05
 * @Description:
 * @Version: V1.0
 */
@RestController
@RequestMapping("/api/v1/area")
@Api(description = "行政区域公共接口")
@ApiResponses({
        @ApiResponse(code=500,message="服务器内部错误")
})
public class AdministrativeAreasController {

    @Autowired
    private DictAdministrativeAreasService service;

    @GetMapping("/list/{parentId}")
    @ApiOperation("根据城市ID获取当前城市下级城市名集合")
    @ApiImplicitParam(paramType = "path",name = "parentId" ,value="城市ID",dataType = "int",defaultValue = "0",required = false)
    public List<DictAdministrativeAreasDTO> getListByParentId(@PathVariable("parentId") Integer parentId){
        return service.getAreaListByParentId(parentId);
    }


}
