package com.ncme.svc.area.response;

import lombok.Data;

/**
 * @Author: colin
 * @Date: 2019/3/25 09:52
 * @Description:
 * @Version: V1.0
 */
@Data
public class SimpleResponse {

    private Object content;

    public SimpleResponse(Object content){
        this.content = content;
    }

}
