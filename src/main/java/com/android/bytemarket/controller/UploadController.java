package com.android.bytemarket.controller;

import com.android.bytemarket.common.FileUpload;
import com.android.bytemarket.common.ServerResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author: 15760
 * @Date: 2019/12/1
 * @Descripe:
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping("/file")
    public ServerResponse upload(MultipartFile file) throws IOException {
        String s = FileUpload.upLoad(file);
        return ServerResponse.ofSuccess(s);
    }
}
