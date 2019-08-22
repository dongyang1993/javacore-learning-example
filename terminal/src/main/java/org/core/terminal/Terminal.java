package org.core.terminal;

import java.io.InputStream;

public class Terminal {

    /**
     * Java 指令命令的方式
     * 1. Runtime
     * 2. ProcessBuilder
     */
    public static final String OS_WINDOWS = "Windows";
    public static final String OS_LINUX = "Linux";


    public static void main(String[] args) throws Exception {
        execute("mkdir D:\\ddd");
        execute("sh /usr/local/tomcat/bin/shutdown.sh");
        execute("sh /usr/local/tomcat/bin/startup.sh");
    }

    public static void execute(String cmd) throws Exception {
        String name = System.getProperty("os.name");
        if (name.startsWith(OS_LINUX)) {
            executeLinux(cmd);
        } else if (name.startsWith(OS_WINDOWS)) {
            executeWindows(cmd);
        } else {
            //其他类型的操作系统
        }

    }

    public static boolean executeLinux(String cmd) throws Exception {
        int i = Runtime.getRuntime().exec(cmd).waitFor();
        return i == 0;
    }

    public static boolean executeWindows(String cmd) throws Exception {
        cmd = "cmd /c " + cmd;
        int i = Runtime.getRuntime().exec(cmd).waitFor();
        return i == 0;
    }

    public static boolean executeBat(String cmd) throws Exception {
        Process exec = Runtime.getRuntime().exec(cmd);
        InputStream inputStream = exec.getInputStream();
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        System.out.println(new String(bytes));
        int i = Runtime.getRuntime().exec(cmd).waitFor();
        return i == 0;
    }

}
