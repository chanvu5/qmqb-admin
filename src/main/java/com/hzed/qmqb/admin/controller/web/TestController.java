package com.hzed.qmqb.admin.controller.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 暂无描述
 *
 * @author wuchengwu
 * @since 2018/11/10
 */

@Slf4j
@Api(tags = "测试接口")
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation("测试")
    @GetMapping("/email/{code}")
    public void testEmail(@PathVariable String code){
        log.error("=====测试++===========================");
        log.error("=====测试++===========================");
        System.out.println(code+ "--------code----------");
    }
}