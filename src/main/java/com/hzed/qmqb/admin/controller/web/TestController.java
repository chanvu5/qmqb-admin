package com.hzed.qmqb.admin.controller.web;

import com.hzed.qmqb.admin.application.service.DictService;
import com.hzed.qmqb.admin.persistence.auto.entity.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DictService dictService;

    @ApiOperation("测试")
    @GetMapping("/email/{code}")
    public void testEmail(@PathVariable String code) {
        log.error("=====测试++===========================");
        log.error("=====测试++===========================");
        System.out.println(code + "--------code----------");
    }

    @ApiOperation("放进缓存")
    @GetMapping("/redis/{code}")
    public Dict testRedis(@PathVariable String code) {
        return dictService.getDict(code);
    }

    @ApiOperation("清除缓存")
    @GetMapping("/clear/{code}")
    public void clearCache(@PathVariable String code) {
        dictService.clearCache(code);
    }

    @ApiOperation("防重")
    @GetMapping("/defensiveRepet/{code}")
    public void defensiveRepet(@PathVariable String code) {
        dictService.defensiveRepet(code);
    }
}