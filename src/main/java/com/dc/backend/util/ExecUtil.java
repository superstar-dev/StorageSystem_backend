package com.dc.backend.util;

import com.dc.backend.entity.Device;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
public class ExecUtil {
    public static List<Device> getDeviceInfo() {
        List<Device> list = new ArrayList<>();
        Device device = new Device();
        try {
            Process ps = Runtime.getRuntime().exec("docker stats --no-stream");
            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
//            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine())!= null) {
//                sb.append(line).append("\n");
                String[] str = line.split("\\s+");
                if (str.length == 14) {
                    device.setContainerId(str[0]);
                    device.setName(str[1]);
                    device.setCpu(str[2]);
                    device.setCurMemory(str[3]);
                    device.setMaxMemory(str[5]);
                    device.setMemory(str[6]);
                    device.setNetIn(str[7]);
                    device.setNetOut(str[9]);
                    device.setBlockIn(str[10]);
                    device.setBlockOut(str[12]);
                    device.setPids(str[13]);
                    device.setCurDate(new Date());
                }
                list.add(device);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
