package com.marvels.service.impl;

import com.marvels.service.XyqbService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("xyqbService")
public class XyqbServiceImpl implements XyqbService{

    @Override
    @Async("asyncPromiseExecutor")
    public void test() {

        System.out.println("service start");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("service end");
    }
}
