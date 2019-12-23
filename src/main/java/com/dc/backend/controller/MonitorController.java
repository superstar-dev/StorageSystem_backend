package com.dc.backend.controller;

import com.dc.backend.entity.Device;
import com.dc.backend.service.MonitorService;
import com.dc.backend.util.ExecUtil;
import com.dc.backend.util.MySSHUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class MonitorController {

    @Autowired
    MonitorService monitorService;

    @RequestMapping("/device/{name}")
    public Device info(@PathVariable(value = "name") String name) {
        log.info("{} start monitor...", name);
        return monitorService.getDevice(name);
    }

    @RequestMapping("/device/init/{name}")
    public List<Device> init(@PathVariable(value = "name") String name) {
        List<Device> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(monitorService.getDevice(name));
        }
        return list;
    }

    @RequestMapping("/test")
    public void test() {
    }
}
