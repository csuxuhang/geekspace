package com.csu.geekspace.detectsoftware.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author xuhang
 * @date 2018/4/17 18:52
 */
public interface UploadService {
    public String importExcel(String filename,MultipartFile file);
}
