package com.hzed.qmqb.admin.controller.web;

import com.hzed.qmqb.admin.application.service.AliyunService;
import com.hzed.qmqb.admin.application.service.DictService;
import com.hzed.qmqb.admin.application.service.FileService;
import com.hzed.qmqb.admin.infrastructure.model.FileRequest;
import com.hzed.qmqb.admin.infrastructure.utils.PicUtil;
import com.hzed.qmqb.admin.persistence.auto.entity.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
    @Autowired
    private FileService fileService;
    @Autowired
    private AliyunService aliyunService;

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

    @ApiOperation("上传文件阿里云")
    @PostMapping("/uploadFile")
    public void uploadFileToAliyunOss(@RequestParam("file") CommonsMultipartFile file) throws Throwable {
        String s = fileService.uploadFileToAliyunOss(file);
        System.out.println(s);
    }

    @ApiOperation("上传base64文件到阿里云")
    @PostMapping("/upload")
    public void uploadBase64File( FileRequest request) throws Exception {
        String picUrl = request.getPicUrl();
        String base64Img = PicUtil.picToBase64(request.getPicUrl());
        String filePix=picUrl.substring(picUrl.indexOf('.')+1);
        String path = aliyunService.uploadBase64PicStr(base64Img, filePix);
        System.out.println("阿里云地址"+ path);

    }



}