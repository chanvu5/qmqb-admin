package com.hzed.qmqb.admin.controller.web;

import com.hzed.qmqb.admin.infrastructure.annotation.ModuleFunc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @ModuleFunc("测试")
    @GetMapping("/email/{code}")
    public void testEmail(@PathVariable String code){
        /*log.error("=====测试++===========================");
        log.error("=====测试++===========================");*/
        System.out.println(code+ "--------code----------");
    }
}