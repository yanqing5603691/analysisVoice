package com.util;

/**
 * Created by yan qing on 2019/5/22.
 */

public class test {
    public static void main(String args[]) {
        /*String msg = "a female, mood of speech: speaking passionately, p-value/sample size= :0.00 5";
        String[] msgSplit = msg.split(" ");
        String sex = msgSplit[2].split(".")[0];
        System.out.println(sex);*/
        String fileName = "cici.wav";
        String localPath = "E:/my_voice/undefined/";
        String sftpPath = "/root/test/";
        try {
            //String message = SFTPUtil.SFTPPut(localPath+fileName,sftpPath);
            String message = SFTPUtil.SFTPGet(sftpPath+fileName,localPath);
            System.out.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
