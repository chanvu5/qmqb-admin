package com.hzed.qmqb.admin.application.service;

import com.hzed.qmqb.admin.infrastructure.model.FileModel;
import com.hzed.qmqb.admin.infrastructure.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;

/**
 * 文件操作
 *
 * @author wuchengwu
 * @since 2018/11/27
 */
@Slf4j
@Service
public class FileService {

    @Value("${system.imgUploadPath}")
    private static String imgUploadPath;

    @Value("${servlet.context-path}")
    private String contextPath;
    @Value("${system.path}")
    private static String basePath;


    /**
     * 上传base64编码的图片到服务器目录
     *
     * @param base64Img 图片
     * @param picSuffix 后缀 如png、jpg
     * @return 服务器路径
     */
    public String uploadBase64Img(String base64Img, String picSuffix) throws Exception {
        // 请求url
        StringBuffer requestURL = RequestUtil.getHttpServletRequest().getRequestURL();
        // 取有效路径 如 http://localhost:8150/hzed
        String requestPath = requestURL.substring(0, requestURL.indexOf(contextPath) + contextPath.length());
        // 文件地址 如 /20180612/3214234234234.png
        String suffixPath = "/" + DateUtil.localDateTimeToStr3(LocalDateTime.now()) + "/" + IdentifierGenerator.nextId() + "." + picSuffix;
        // 可访问地址 如 http://localhost:8150/hzed/20180612/3214234234234.png
        String returnUrl = requestPath + suffixPath;
        log.info("可访问路径：{}", returnUrl);
        // 上传至 配置的 imgUploadPath 目录
        PicUtil.uploadImageAbs(base64Img, imgUploadPath + suffixPath);
        return returnUrl;
    }

    /**
     * 上传文件到阿里云
     * @param file
     * @return
     * @throws Throwable
     */
    public  String uploadFileToAliyunOss(CommonsMultipartFile file) throws Throwable{
        FileModel fileModel = FileService.uploadFile(file);
        if (fileModel != null) {
            return AliyunOssUtils.upload(fileModel.getFileName(),fileModel.getFilePath());
        }
        throw new RuntimeException("上传失败,获取上传文件为空");


    }
    /**
     * 文件上传
     * @param file
     * @return
     */
    public static FileModel uploadFile(CommonsMultipartFile file){
        FileModel fileModel = null;
        if(file==null){
            return null;
        }
        OutputStream out =null;
        InputStream in=null;
        String oldfilename=file.getFileItem().getName();
        if(StringUtils.isBlank(oldfilename)){
            return null;
        }
        String filepix=oldfilename.substring(oldfilename.indexOf('.')+1);
        try {
            String filename=IdentifierGenerator.nextId()+"."+filepix;
            out = new FileOutputStream(imgUploadPath+File.separator+filename);
            in=file.getInputStream();
            byte[] bs=new byte[1204*1024*100];
            while(true){
                int x=in.read(bs);
                if(x<0){
                    break;
                }
                out.write(bs, 0, x);
            }
            fileModel = new FileModel();
            fileModel.setFileName(filename);
            fileModel.setFilePath(imgUploadPath+File.separator+filename);

        } catch (Exception e) {
            log.error("error:",e);
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    out.close();
                }
            } catch (Exception e2) {
                log.error("error:",e2);
            }
        }

        return fileModel;

    }


}