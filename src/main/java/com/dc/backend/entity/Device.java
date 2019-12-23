package com.dc.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Device {
    private String containerId;
    private String name;
    private String cpu;
    private String curMemory;
    private String maxMemory;
    private String memory;
    private String netIn;
    private String netOut;
    private String blockIn;
    private String blockOut;
    private String pids;
    private Date curDate;

}
