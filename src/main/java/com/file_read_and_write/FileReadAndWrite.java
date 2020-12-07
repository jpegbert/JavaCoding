package com.file_read_and_write;

import java.io.*;

/**
 * java文件读写
 */
public class FileReadAndWrite {

    /**
     * 读文件
     */
    private static void readFile1() {
        String fileName = "E:\\zhilian\\note\\Java-Learning\\JavaCoding\\src\\main\\resources\\data\\data.txt";
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
                sbf.append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        System.out.println(sbf.toString());
    }

    public static void readFile2() {
        String txtPath = "E:\\zhilian\\note\\Java-Learning\\JavaCoding\\src\\main\\resources\\data\\data.txt";
        File file = new File(txtPath);
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        if(file.isFile() && file.exists()){
            try {
                fileInputStream = new FileInputStream(file);
                inputStreamReader = new InputStreamReader(fileInputStream);
                bufferedReader = new BufferedReader(inputStreamReader);

                StringBuffer sb = new StringBuffer();
                String text = null;
                while((text = bufferedReader.readLine()) != null){
                    sb.append(text);
                    sb.append("\n");
                }
                System.out.println(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("NULL");
    }

    /**
     * 写文件
     */
    public static void writeFile(){
        String txtPath = "E:\\zhilian\\note\\Java-Learning\\JavaCoding\\src\\main\\resources\\result\\out.txt";
        String content = "写入文件测试";
        FileOutputStream fileOutputStream = null;
        File file = new File(txtPath);
        try {
            if(file.exists()) {
                //判断文件是否存在，如果不存在就新建一个txt
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
//        readFile1();
        writeFile();
    }

}
