package com.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by yan qing on 2019/5/21.
 */
public class InvokeBat {
    public void runBat(String batName) throws IOException {
        String cmd = "E:\\my_voice\\fileUpload"+"\\"+batName;
        try {
            Process ps = Runtime.getRuntime().exec(cmd);
            InputStream in = ps.getInputStream();
            int c;
            while ((c = in.read()) != -1){
                System.out.println(c);
            }
            in.close();
            ps.waitFor();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(batName+"------"+new Date()+"start bat successful");

}

    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！"+new Date());
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！"+new Date());
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！"+new Date());
            return false;
        }
    }
}
