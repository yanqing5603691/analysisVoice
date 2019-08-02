package com.service.impl;

import com.dao.analysis_voiceMapper;
import com.entity.analysis_voice;
import com.entity.analysis_voiceExample;
import com.service.AnalysisVoice;
import com.util.InvokeBat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;

/**
 * Created by yan qing on 2019/5/22.
 */
@Service
public class AnalysisVoiceImpl implements AnalysisVoice {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnalysisVoiceImpl.class);
    @Autowired
    analysis_voiceMapper analysis_voiceMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addAnalysisRecord(analysis_voice record) {
        File file = new File("D:\\my_voice\\fileUpload");
        String dirPath = file.getAbsolutePath();
        File[] files = file.listFiles();
        //int index = 0;
        for (File fileTxt : files) {
            if (fileTxt.toString().contains(".wav")) {
                //index++;
                String filename = fileTxt.getName().substring(0,fileTxt.getName().length()-4);
                String fileTxtName = dirPath +"\\"+ filename + ".txt";
                String fileWavName = dirPath +"\\"+ filename+ ".wav";
                //String fileTextGridName = dirPath +"\\"+ filename + ".TextGrid";
                String newPath = fileWavName.replace("fileUpload","fileDownload");
                HashMap<Integer,String> hashMap = new HashMap<>();
                try {
                    File fileTxtOpen = new File(fileTxtName);
                    if (fileTxtOpen.exists()) {
                        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileTxtOpen), "utf-8");
                        BufferedReader br = new BufferedReader(isr);
                        String lineTxt = null;
                        Integer index = 0;
                        while ((lineTxt = br.readLine()) != null) {
                            //System.out.println(lineTxt);
                            hashMap.put(index,lineTxt);
                            index++;
                        }
                        record = getRecord(hashMap,record);
                        record.setVoiceUrl(newPath);
                        record.setVoicename(filename);
                        record.setInserttime(new Date());
                        analysis_voiceMapper.insert(record);
                        LOGGER.info("Insert record successful "+new Date());
                        br.close();
                        isr.close();
                        InvokeBat.deleteFile(fileTxtName);
                        //InvokeBat.deleteFile(fileTextGridName);
                        if(copyFile(fileWavName,newPath)==true){
                            InvokeBat.deleteFile(fileWavName);
                        }
                    } else {
                        LOGGER.debug(fileTxtName+"文件不存在!"+new Date());
                    }
                } catch (Exception e) {
                    LOGGER.error("文件读取错误"+new Date());
                }
            }
        }
    }

    public analysis_voice getRecord(HashMap<Integer,String> hashMap,analysis_voice record){
        String errorStr = "Try again the sound of the audio was not clear";
        if(hashMap.get(2).equalsIgnoreCase(errorStr) || hashMap.get(1).equalsIgnoreCase(errorStr)){
            record.setUuid(UUID.randomUUID().toString());
            record.setAllInfo(errorStr);
            return record;
        }else {
            record.setUuid(UUID.randomUUID().toString());
            //String aaa = hashMap.get(3);
            //String[] ccc = aaa.split("   ");
            record.setNumberOfSyllables(Integer.valueOf(hashMap.get(2).split("   ")[hashMap.get(2).split("   ").length - 1].trim()));
            record.setNumberOfPauses(Integer.valueOf(hashMap.get(3).split("   ")[hashMap.get(3).split("   ").length - 1].trim()));
            record.setRateOfSpeech(Float.valueOf(hashMap.get(4).split("   ")[hashMap.get(4).split("   ").length - 1].trim()));
            record.setArticulationRate(Float.valueOf(hashMap.get(5).split("   ")[hashMap.get(5).split("   ").length - 1].trim()));
            record.setSpeakingDuration(Float.valueOf(hashMap.get(6).split("   ")[hashMap.get(6).split("   ").length - 1].trim()));
            record.setOriginalDuration(Float.valueOf(hashMap.get(7).split("   ")[hashMap.get(7).split("   ").length - 1].trim()));
            record.setBalance(Float.valueOf(hashMap.get(8).split("   ")[hashMap.get(8).split("   ").length - 1].trim()));
            record.setF0Mean(Float.valueOf(hashMap.get(9).split("   ")[hashMap.get(9).split("   ").length - 1].trim()));
            record.setF0Std(Float.valueOf(hashMap.get(10).split("   ")[hashMap.get(10).split("   ").length - 1].trim()));
            record.setF0Median(Float.valueOf(hashMap.get(11).split("   ")[hashMap.get(11).split("   ").length - 1].trim()));
            record.setF0Min(Float.valueOf(hashMap.get(12).split("   ")[hashMap.get(12).split("   ").length - 1].trim()));
            record.setF0Max(Float.valueOf(hashMap.get(13).split("   ")[hashMap.get(13).split("   ").length - 1].trim()));
            record.setF0Quantile25(Float.valueOf(hashMap.get(14).split("   ")[hashMap.get(14).split("   ").length - 1].trim()));
            record.setF0Quan75(Float.valueOf(hashMap.get(15).split("   ")[hashMap.get(15).split("   ").length - 1].trim()));
            if (hashMap.get(17).contains("female")) {
                record.setSex("female");
            } else if (hashMap.get(17).contains("ale")) {
                record.setSex("male");
            } else {
                record.setSex("indeterminacy");
            }
            record.setSexContent(hashMap.get(17));
            record.setAllInfo(hashMap.get(hashMap.size() - 1));
            return record;
        }
    }



    public Boolean copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { //文件存在时
                InputStream inStream = new FileInputStream(oldPath); //读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1024];
                int length;
                while ( (byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
                    //System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
                fs.close();
            }
            return true;
        }
        catch (Exception e) {
            LOGGER.error(newPath+"复制单个文件操作出错"+new Date());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<analysis_voice> findAnalysisVoiceAllInfo(){
        List<analysis_voice> list = analysis_voiceMapper.selectByExample(new analysis_voiceExample());
        return list;
    }

    @Override
    public analysis_voice findByUUID(String uuid){
        analysis_voice record = analysis_voiceMapper.selectByPrimaryKey(uuid);
        return record;
    }

    public String copyVoice(String uuid, HttpSession session){
        analysis_voice record = findByUUID(uuid);
        String filePath = record.getVoiceUrl();
        File file = new File(filePath);
        String wavName = file.getName();
        String voicePath = session.getServletContext().getRealPath("/") ;
        String pathName = voicePath+"voice/"+wavName;
        String wavPath = "././"+"voice/"+wavName;
        //System.out.println(wavPath);
        //System.out.println(pathName);
        File fileP = new File(pathName);
        if (!fileP.getParentFile().exists()){
            fileP.getParentFile().mkdirs();
        }
        if(copyFile(filePath,pathName) == true){
           /* try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            LOGGER.info("copyFile successful "+new Date());
        }else {
            LOGGER.info("copyFile failed  "+new Date());
        }
        return wavPath;
    }

    public void deleteWav()  {
        //HttpServletRequest request =
        /*String path = request.getSession().getServletContext().getRealPath("voice/");*/
        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);
        String path = courseFile+"/voice";
        File file = new File(path);
        String dirPath = file.getAbsolutePath();
        File[] files = file.listFiles();
        //int index = 0;
        for (File fileTxt : files) {
            if (fileTxt.toString().contains(".wav")){
                String filePath = fileTxt.getPath();
                InvokeBat.deleteFile(filePath);
                System.out.println("StaticScheduleTask Delete "+filePath+" Successful"+new Date());
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
