package com.android.bytemarket.common;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * @author: 15760
 * @Date: 2019/12/1
 * @Descripe:
 */
public class FileUpload {

    static String accessKey = "6sLzFMI1OuMEabWiej9QZ7p1NRK0OYR5tv808xVn";
    static String secretKey = "lmr9I8cQVlPEL8YVFNFkPVqCnkOZ--CHWBNxvj9X";
    static String bucket = "bucket name";//需要上传的空间名
    static String filePath = "";
    static String key = "file key";

    public static void upLoad() {

        Auth auth = Auth.create(accessKey, secretKey);
        StringMap putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
        long expireSeconds = 3600;
        String upToken = auth.uploadToken(bucket, null, expireSeconds, putPolicy);
        System.out.println(upToken);

    }
}
