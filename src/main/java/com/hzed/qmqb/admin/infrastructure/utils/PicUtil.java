package com.hzed.qmqb.admin.infrastructure.utils;


import org.apache.commons.codec.binary.Base64;

import java.awt.*;
import java.io.*;
import java.util.Random;


/**
 * @author guichang
 */
public class PicUtil {
    private static String basePath = PicUtil.class.getResource("/").getPath();

//    static {
//        // 初始化存放目录
//        basePath += "tempImgs";
//        new File(basePath).mkdirs();
//    }

    /**
     * 将base64编码字符串转换为图片
     *
     * @param base64ImgStr base64编码字符串
     * @param picSuffix    图片文件后缀如：jpg,png
     * @return 生成文件的完整路径
     */
    public static String uploadImage(String base64ImgStr, String picSuffix) throws Exception {
        String imgPathAbs = basePath + File.separator + IdentifierGenerator.nextId() + "." + picSuffix;
        return uploadImageAbs(base64ImgStr, imgPathAbs);

    }

    /**
     * 将base64编码字符串转换为图片
     *
     * @param base64ImgStr base64编码字符串
     * @param absFilePath  保存的绝对路径 如 c:/123.png
     * @return 保存的绝对路径
     */
    public static String uploadImageAbs(String base64ImgStr, String absFilePath) throws Exception {
        // 不存在就创建目录
        String fileDir = absFilePath.substring(0, absFilePath.lastIndexOf("/"));
        new File(fileDir).mkdirs();
        // 解密
        byte[] b = Base64.decodeBase64(base64ImgStr);
        // 处理数据
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {
                b[i] += 256;
            }
        }
        // 生成文件的完整路径
        OutputStream out = new FileOutputStream(absFilePath);
        out.write(b);
        out.flush();
        out.close();
        return absFilePath;

    }

    /**
     * 图片生成base64编码
     *
     * @param imgPath
     * @return
     */
    public static String picToBase64(String imgPath) throws Exception {
        InputStream in = new FileInputStream(new File(imgPath));
        byte[] data = new byte[in.available()];
        //读取图片字节数组  
        in.read(data);
        in.close();
        return Base64.encodeBase64String(data);
    }

    public static String getFileName(String imgPathAbs) {
        return imgPathAbs.substring(imgPathAbs.lastIndexOf(File.separator) + 1, imgPathAbs.length());
    }


    /**
     * 随机字符串
     */
    private static String codeStr = "1234567890";

    /**
     * 绘制字符串
     */
    private static String drowString(Graphics g, String randomString, int i) {

        Random random = new Random();
        g.setFont(new Font("Default", Font.CENTER_BASELINE, 18));
        g.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
        String rand = String.valueOf(getRandomString(random.nextInt(codeStr.length())));
        randomString += rand;
        g.translate(random.nextInt(3), random.nextInt(3));
        g.drawString(rand, 13 * i, 16);
        return randomString;
    }

    /**
     * 获取随机的字符
     */
    public static String getRandomString(int num) {
        return String.valueOf(codeStr.charAt(num));
    }



}
