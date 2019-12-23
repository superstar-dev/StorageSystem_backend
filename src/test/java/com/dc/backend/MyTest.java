package com.dc.backend;

import com.dc.backend.util.ExecUtil;
import com.dc.backend.util.MySSHUtil;
import org.junit.Test;

public class MyTest {

    @Test
    public void test() {
//        MySSHUtil.startMonitor();
        ExecUtil.getDeviceInfo();
    }
}
