package com.service;

import com.entity.analysis_voice;

import java.util.List;

/**
 * Created by yan qing on 2019/5/22.
 */
public interface AnalysisVoice {
    void addAnalysisRecord(analysis_voice record);
    List<analysis_voice> findAnalysisVoiceAllInfo();
    analysis_voice findByUUID(String uuid);
}
