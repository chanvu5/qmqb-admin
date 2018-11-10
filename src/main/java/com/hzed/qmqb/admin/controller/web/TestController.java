package com.hzed.qmqb.admin.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 暂无描述
 *
 * @author wuchengwu
 * @since 2018/11/10
 */

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/email")
    public void testEmail(){
        log.error("测试++===========================");
        log.error("测试++===========================");
    }
}