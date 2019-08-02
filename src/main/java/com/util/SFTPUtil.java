package com.util;

// Created by yan qing on 2019/5/28.


import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

public class SFTPUtil {
    public static Session getSession() throws JSchException {
        String username = "root";
        String password = "duplicall";
        String host = "192.168.6.164";
        int port = 22;
        JSch jsch = new JSch();
        Session session;
        //ChannelSftp channelSftp;
        session = jsch.getSession(username, host, port);
        session.setPassword(password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();
        return session;
    }

    //连接sftp服务器
    public static String SFTPPut(String localPath,String sftpPath) throws Exception {
        Session session = getSession();
        try{
            //ChannelSftp channelSftp;
            ChannelSftp  channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            //FileOutputStream fs = new FileOutputStream("");
            channelSftp.put(localPath,sftpPath);
            if(channelSftp != null && channelSftp.isConnected()){
                channelSftp.disconnect();
            }
            if(session != null && session.isConnected()){
                session.disconnect();
            }
            return "sftp put file successful";
        }catch (Exception e){
            e.printStackTrace();
            session.disconnect();
        }
        return "sftp put file failed";
    }


    public static String SFTPGet(String sftpPath,String localPath) throws Exception {
        Session session = getSession();
        try{
            //ChannelSftp channelSftp;
            ChannelSftp  channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            //FileOutputStream fs = new FileOutputStream("");
            channelSftp.get(sftpPath,localPath);
            if(channelSftp != null && channelSftp.isConnected()){
                channelSftp.disconnect();
            }
            if(session != null && session.isConnected()){
                session.disconnect();
            }
            return "sftp get file successful";
        }catch (Exception e){
            e.printStackTrace();
            session.disconnect();
        }
        return "sftp get file failed";
    }


}
