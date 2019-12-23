package com.dc.backend.service.impl;

import com.dc.backend.entity.Device;
import com.dc.backend.service.MonitorService;
import com.dc.backend.util.ExecUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MonitorServiceImpl implements MonitorService {
    @Override
    public Device getDevice(String name) {
        log.info("{} monitor", name);
        List<Device> deviceInfo = ExecUtil.getDeviceInfo();
        Optional<Device> first = deviceInfo.stream().filter(a -> name.equals(a.getName())).findFirst();
        Device device = first.get();
        return device;
    }
}
