package com.dc.backend.service;

import com.dc.backend.entity.Device;

public interface MonitorService {
    Device getDevice(String name);
}
