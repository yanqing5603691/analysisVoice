package com.util;

import com.entity.analysis_voice;
import com.service.impl.AnalysisVoiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;

/**
 * Created by yan qing on 2019/5/22.
 */
@Component
@Configuration
@EnableScheduling
public class StaticScheduleTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(StaticScheduleTask.class);
    @Autowired
    AnalysisVoiceImpl analysisVoice;
    @Autowired
    HttpServletRequest request;
    @Async
    @Scheduled(cron = "0/10 * * * * ?")
    private void getFileNameTasks() throws IOException {
        InvokeBat invokeBat = new InvokeBat();
        invokeBat.runBat("getFileName.bat");
    }

    @Async
    @Scheduled(cron = "0 */2 * * * ?")
    private void startExeTasks() throws IOException {
        InvokeBat invokeBat = new InvokeBat();
        invokeBat.runBat("startAnalysisVoiceExe.bat");
        File file = new File("D:\\my_voice\\fileUpload");
        String dirPath = file.getAbsolutePath();
        File[] files = file.listFiles();
        //int index = 0;
        for (File fileTxt : files) {
            if (fileTxt.toString().contains(".TextGrid")){
                String filePath = fileTxt.getPath();
                InvokeBat.deleteFile(filePath);
                LOGGER.info("Delete "+filePath+" Successful"+new Date());
            }
        }
    }

    @Async
    @Scheduled(cron = "0/15 * * * * ?")
    private void insertMysql(){
        analysis_voice record = new analysis_voice();
        analysisVoice.addAnalysisRecord(record);
    }

    @Async
    @Scheduled(cron = "0 1 0 * * ?")
    private void deleteWav(){
        //analysisVoice.deleteWav();
        try {
            String path=File.createTempFile("datas", ".txt").getPath();		//获取临时文件路径
            File file=new File(path).getParentFile();		//获取临时文件存放的文件夹
            File[] files=file.listFiles();				//取文件夹下所有文件
            	File f = files[0]; 				//遍历删除所有文件
                //String aPath = f.getAbsolutePath();
                String voicePath = f.getParentFile().getParent()+"\\webapps\\demo\\voice";
                File newFile = new File(voicePath);
            File[] filelist = newFile.listFiles();
            //int index = 0;
            for (File fileTxt : filelist) {
                if (fileTxt.toString().contains(".wav")) {
                    if(fileTxt.delete()){
                        LOGGER.info("文件删除成功");
                    }else{
                        LOGGER.info("找到文件了，但是删除失败");
                    }
                }
            }
                //delete(newFile);
                //System.out.println(voicePath);
                //System.out.println("当前时间是"+new Date().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void delete(File file){
        System.out.println("进来了删除文件操作"+file);
        /*if (file.isDirectory()) {
            String[] children = file.list();
            for (int i=0; i<children.length; i++) {     //递归删除目录中的子目录下
                delete(new File(file, children[i]));
            }
        }*/
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            if (inputStream != null) {
                // 关闭流
                inputStream.close();
            }
            // 目录此时为空，可以删除
            file.delete();
            if (!file.exists()){
                System.out.println(file+"删除文件成功");
            }
        } catch (Exception e) {
            System.out.println(file+"删除文件失败");
            e.printStackTrace();
        }

    }



}
