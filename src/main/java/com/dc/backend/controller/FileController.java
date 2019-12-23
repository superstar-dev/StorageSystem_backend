package com.dc.backend.controller;

import com.dc.backend.params.FileParam;
import com.dc.backend.service.impl.FileServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class FileController {


    @Autowired
    FileServiceImpl fileService;

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @RequestMapping("/file/upload")
    public HashMap<String, String> handleFileUpload(MultipartFile file) {
        log.info("{} enter...", file.getOriginalFilename());
        return fileService.handleFileUpload(file);
    }

    /**
     * 返回文件列表
     *
     * @return
     */
    @RequestMapping("/file/list")
    public HashMap<String, Object> listFile() {
        return fileService.listFile();
    }

    @RequestMapping("/file/header")
    public List<HashMap<String, String>> getHeader(@RequestBody FileParam param) {
        log.info("{} get header...", param.getFilename());
        return fileService.getHeader(param.getFilename());
    }

}
