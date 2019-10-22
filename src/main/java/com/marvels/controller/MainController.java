package com.marvels.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统一入口
 * @author houyl
 * @date 2019/10/17 10:59
 */
@RestController
@RequestMapping
public class MainController {

    /**
     * 统一入口，解决url中的 http://xxx/error
     * @return
     */
    @RequestMapping("fincloud/common.intf")
    public Object commonIntf() {
        return null;
    }
}
