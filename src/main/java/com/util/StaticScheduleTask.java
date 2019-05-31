package com.util;

import com.entity.analysis_voice;
import com.service.impl.AnalysisVoiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by yan qing on 2019/5/22.
 */
@Component
@Configuration
@EnableScheduling
public class StaticScheduleTask {
    @Autowired
    AnalysisVoiceImpl analysisVoice;
    @Autowired
    HttpSession session;
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
        File file = new File("E:\\my_voice\\fileUpload");
        String dirPath = file.getAbsolutePath();
        File[] files = file.listFiles();
        //int index = 0;
        for (File fileTxt : files) {
            if (fileTxt.toString().contains(".TextGrid")){
                String filePath = fileTxt.getPath();
                InvokeBat.deleteFile(filePath);
                System.out.println("Delete "+filePath+" Successful"+new Date());
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
    @Scheduled(cron = "0 0 10 * * ?")
    private void deleteWav(){
        analysisVoice.deleteWav(session);
    }
}
