package com.controller;

import com.entity.analysis_voice;
import com.service.impl.AnalysisVoiceImpl;
import com.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.net.ftp.FtpClient;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

/**
 * Created by yan qing on 2019/5/21.
 */
@Controller
public class analysisVoiceController {
    @Autowired
    AnalysisVoiceImpl analysisVoice;

    @RequestMapping(value = "uploadVoice",method = RequestMethod.GET)
    public String toAnalysis(){return "analysis/analysisVoice";}

    @RequestMapping(value = "import",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity importVoice(MultipartFile fileUpload){
        String path = "D:\\my_voice\\fileUpload";
        try {
            String filename = fileUpload.getOriginalFilename();
            File file = new File(path,filename);


            InputStream is = fileUpload.getInputStream();
            FileOutputStream fos = new FileOutputStream(file);
            byte[] b = new byte[1024];
            int length;
            while ((length = is.read(b)) != -1) {
                fos.write(b, 0, length);
            }
            is.close();
            fos.close();
            //return new ResponseEntity("success", HttpStatus.OK);


        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(new Result(null,true), HttpStatus.OK);
    }

    @RequestMapping(value = "analysisVoice",method = RequestMethod.GET)
    public String listInfo(){
        //List<analysis_voice> list = analysisVoice.findAnalysisVoiceAllInfo();
        //model.addAttribute("Voices",list);
        return "analysis/VoiceInfo";
    }

    @RequestMapping(value = "info",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity findAllInfo(){
        List<analysis_voice> list = analysisVoice.findAnalysisVoiceAllInfo();
        return new ResponseEntity(list,HttpStatus.OK);
    }

    @RequestMapping(value = "play",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity play(String uuid, HttpSession session){
        String voicePath = analysisVoice.copyVoice(uuid,session);
        //System.out.println(session.getServletContext().getRealPath("/"));
        return new ResponseEntity(voicePath,HttpStatus.OK);
    }
}
