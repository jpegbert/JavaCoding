package com.JavaRunPython;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * java调用python Demo
 * https://blog.csdn.net/weixin_30268071/article/details/97875668
 */

public class BasicDemoWithModule {


    public static String JavaRunPy() {
        String[] arguments = new String[] {"python", "test1.py", "huzhiwei", "25"}; // 可能需要写全路径
        try {
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(),"gb2312"));
            String line = null;
            String result = "";
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                result += line;
            }
            in.close();
            int re = process.waitFor();
//            System.out.println(re);
            if (re == 0) {
                return result;
            } else {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        JavaRunPy();
    }

}
