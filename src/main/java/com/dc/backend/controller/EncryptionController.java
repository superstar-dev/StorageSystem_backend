package com.dc.backend.controller;

import com.dc.backend.service.EncryptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class EncryptionController {
    EncryptionService encryptionService;

    @RequestMapping
    public void encrypt() {

    }
}
