package com.ncme.svc.area.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: colin
 * @Date: 2019/3/21 11:55
 * @Description:
 * @Version: V1.0
 */
@Data
@Entity
public class DictAdministrativeAreas {

    /**
     * 异常： springBoot+jpa 测试自增时数据库报错Springboot-jpa Table 'sell.hibernate_sequence' doesn't exist
     *
     *    --- ：需要在@GeneratedValue中添加strategy = GenerationType.IDENTITY
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer parentId;
    private String areaName;
    private String areaCode;

    /**
     * Hibrenate中，如果要在SQL中使用对象，该对象要有相对应的构造器
     *
     * ★
     * 这是出现错误的地方使用的HQL：
     *      String hql="select new User(u.userName,u.userAge) from User u";
     *      当查询某个实体类的部分属性然后封装成List时，需要该属性构成的构造器。
     */
    public DictAdministrativeAreas() {
    }

    public DictAdministrativeAreas(Integer id,Integer parentId,String areaName,String areaCode) {
        this.id = id;
        this.parentId = parentId;
        this.areaName = areaName;
        this.areaCode = areaCode;
    }
}
