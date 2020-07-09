package com.ncme.svc.area.Respository;

import com.ncme.svc.area.SvcAreaApplicationTests;
import com.ncme.svc.area.entity.DictAdministrativeAreas;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DictAdministrativeAreasRespositoryTest extends SvcAreaApplicationTests {

    @Autowired
    private DictAdministrativeAreasRespository respository;

    @Test
    public void findAllByParentId() {
        List<DictAdministrativeAreas> list = respository.findAllByParentId(5);
        for (DictAdministrativeAreas areas : list) {
            System.out.println(areas);
        }
    }
}