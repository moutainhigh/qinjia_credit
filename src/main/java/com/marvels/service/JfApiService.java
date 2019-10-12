package com.marvels.service;

import com.alibaba.fastjson.JSON;
import com.marvels.dto.jf.JfRequestDto;

public interface JfApiService {
    public static void main(String[] args) {
        JfRequestDto.JfHttpInterfaceHander indd = new JfRequestDto.JfHttpInterfaceHander();
        indd.setSysCode("123132");
        JfRequestDto aa = new JfRequestDto();
        aa.setHead(indd);
        System.out.println(JSON.toJSON(aa));
    }
}
