package com.dc.backend.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

public interface FileService {
    HashMap<String, String> handleFileUpload(MultipartFile file);

    public HashMap<String, Object> listFile();

    public List<HashMap<String, String>> getHeader(String filename);
}
