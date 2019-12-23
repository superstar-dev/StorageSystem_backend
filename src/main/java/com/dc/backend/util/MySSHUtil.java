package com.dc.backend.util;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.dc.backend.entity.Device;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

@Slf4j
public class MySSHUtil {
    private static final String SERVER_PROPERTIES = "/server.properties";
    private static String host;
    private static int port;
    private static String user;
    private static String pass;

    static {
        Properties p = new Properties();
        try {
            p.load(MySSHUtil.class.getResourceAsStream(SERVER_PROPERTIES));
            host = p.getProperty("host");
            port = Integer.valueOf(p.getProperty("port"));
            user = p.getProperty("username");
            pass = p.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Session getSession() {
        log.info("host:{} port:{} user:{} pass:{}", host, port, user, pass);
        Connection connection = new Connection(host, port);
        log.info("connection:{}", connection);
        Session session = null;
        try {
            connection.connect();
            boolean b = connection.authenticateWithPassword(user, pass);
            System.out.println(b);
            if (!b) {
                log.error("验证失败!");
                return session;
            }
            session = connection.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;
    }

    public static void startMonitor() {
        Session session = getSession();
        log.info("session:{}", session);
        try {
//            session.execCommand("/Users/terminus/Downloads/大创项目\\ 数据加密/backend/shell/device.sh");
            session.execCommand("docker stats --no-stream > /Users/terminus/Downloads/大创项目\\ 数据加密/backend/device/device.out");
            InputStream stdout = new StreamGobbler(session.getStdout());
            BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(stdout));
            String line = null;
            while (true) {
                line = stdoutReader.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
