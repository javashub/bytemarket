package com.android.bytemarket.common;

import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author: 15760
 * @Date: 2019/12/1
 * @Descripe:
 */
public class FileUpload {

    static String accessKey = "6sLzFMI1OuMEabWiej9QZ7p1NRK0OYR5tv808xVn";
    static String secretKey = "lmr9I8cQVlPEL8YVFNFkPVqCnkOZ--CHWBNxvj9X";
    //需要上传的空间名
    static String bucket = "bucket name";
    static String filePath = "";
    static String key = "file key";

    //图片文件后缀名
    //static final String[] fileSuffix = {"jpg", "jpeg", "png"};

    //密钥配置
    static Auth auth = Auth.create(accessKey, secretKey);
    //创建上传对象
    static UploadManager uploadManager = new UploadManager(new Configuration());

    //简单上传，使用默认策略，只需要设置上传的空间名即可
    public static String simpleUpload() {
        return auth.uploadToken(bucket);
    }

    /**
     * @param file
     * @return
     */
    public static String upLoad(MultipartFile file) throws IOException {

        return "";
    }
}
