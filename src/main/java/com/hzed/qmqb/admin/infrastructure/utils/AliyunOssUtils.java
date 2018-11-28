package com.hzed.qmqb.admin.infrastructure.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * 上传阿里云工具类
 *
 * @author wuchengwu
 * @since 2018/11/28
 */
@Slf4j
public class AliyunOssUtils {

    private static OSSClient ossClient;

    @Value("${aliyun.oss.endpoint}")
    private static String endpoint;
    @Value("${aliyun.oss.accessKeyId}")
    private static String accessKeyId;
    @Value("${aliyun.oss.accessKeySecret}")
    private static String accessKeySecret;
    @Value("${aliyun.oss.bucketName}")
    private static String  bucketName;

    private static void init(){
        if(ossClient==null){
            ossClient=new OSSClient(endpoint, accessKeyId,accessKeySecret);
        }
    }



    public static String upload(String key, String uploadFile) throws Throwable {
        init();
        UploadFileRequest uploadFileRequest = new UploadFileRequest(bucketName, key);
        uploadFileRequest.setUploadFile(uploadFile);
        uploadFileRequest.setTaskNum(5);
        uploadFileRequest.setPartSize(1024 * 1024 * 1L);
        uploadFileRequest.setEnableCheckpoint(true);
        UploadFileResult uploadResult = ossClient.uploadFile(uploadFileRequest);
        uploadResult.getMultipartUploadResult();
        log.info(uploadFile + " upload to " + bucketName + "/" + key + " successful at " + new Date());
        String ds = endpoint.replaceAll("http://", "");
        String path = "http://" + bucketName + "." + ds + "/" + key;
        return path;


    }

    public void download(String key, String downloadFile) {

        try {
            init();
            DownloadFileRequest downloadFileRequest = new DownloadFileRequest(bucketName, key);
            // Sets the local file to download to
            downloadFileRequest.setDownloadFile(downloadFile);
            // Sets the concurrent task thread count 5. By default it's 1.
            downloadFileRequest.setTaskNum(5);
            // Sets the part size, by default it's 100K.
            downloadFileRequest.setPartSize(1024 * 1024 * 1L);
            // Enable checkpoint. By default it's false.
            downloadFileRequest.setEnableCheckpoint(true);
            DownloadFileResult downloadResult = ossClient.downloadFile(downloadFileRequest);
            ObjectMetadata objectMetadata = downloadResult.getObjectMetadata();
            log.info(downloadFile + " download from " + bucketName + "/" + key + " successful at " + new Date());
        } catch (OSSException oe) {
            log.error(oe.getMessage(), oe);
        } catch (ClientException ce) {
            log.error(ce.getMessage(), ce);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        }
    }
}