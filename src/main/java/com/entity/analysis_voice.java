package com.entity;

import java.util.Date;

public class analysis_voice {
    private String uuid;

    private String sex;

    private Integer numberOfSyllables;

    private Integer numberOfPauses;

    private Float rateOfSpeech;

    private Float articulationRate;

    private Float speakingDuration;

    private Float originalDuration;

    private Float balance;

    private Float f0Mean;

    private Float f0Std;

    private Float f0Median;

    private Float f0Min;

    private Float f0Max;

    private Float f0Quantile25;

    private Float f0Quan75;

    private String sexContent;

    private String allInfo;

    private String voiceUrl;

    private Date inserttime;

    private String voicename;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getNumberOfSyllables() {
        return numberOfSyllables;
    }

    public void setNumberOfSyllables(Integer numberOfSyllables) {
        this.numberOfSyllables = numberOfSyllables;
    }

    public Integer getNumberOfPauses() {
        return numberOfPauses;
    }

    public void setNumberOfPauses(Integer numberOfPauses) {
        this.numberOfPauses = numberOfPauses;
    }

    public Float getRateOfSpeech() {
        return rateOfSpeech;
    }

    public void setRateOfSpeech(Float rateOfSpeech) {
        this.rateOfSpeech = rateOfSpeech;
    }

    public Float getArticulationRate() {
        return articulationRate;
    }

    public void setArticulationRate(Float articulationRate) {
        this.articulationRate = articulationRate;
    }

    public Float getSpeakingDuration() {
        return speakingDuration;
    }

    public void setSpeakingDuration(Float speakingDuration) {
        this.speakingDuration = speakingDuration;
    }

    public Float getOriginalDuration() {
        return originalDuration;
    }

    public void setOriginalDuration(Float originalDuration) {
        this.originalDuration = originalDuration;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Float getF0Mean() {
        return f0Mean;
    }

    public void setF0Mean(Float f0Mean) {
        this.f0Mean = f0Mean;
    }

    public Float getF0Std() {
        return f0Std;
    }

    public void setF0Std(Float f0Std) {
        this.f0Std = f0Std;
    }

    public Float getF0Median() {
        return f0Median;
    }

    public void setF0Median(Float f0Median) {
        this.f0Median = f0Median;
    }

    public Float getF0Min() {
        return f0Min;
    }

    public void setF0Min(Float f0Min) {
        this.f0Min = f0Min;
    }

    public Float getF0Max() {
        return f0Max;
    }

    public void setF0Max(Float f0Max) {
        this.f0Max = f0Max;
    }

    public Float getF0Quantile25() {
        return f0Quantile25;
    }

    public void setF0Quantile25(Float f0Quantile25) {
        this.f0Quantile25 = f0Quantile25;
    }

    public Float getF0Quan75() {
        return f0Quan75;
    }

    public void setF0Quan75(Float f0Quan75) {
        this.f0Quan75 = f0Quan75;
    }

    public String getSexContent() {
        return sexContent;
    }

    public void setSexContent(String sexContent) {
        this.sexContent = sexContent == null ? null : sexContent.trim();
    }

    public String getAllInfo() {
        return allInfo;
    }

    public void setAllInfo(String allInfo) {
        this.allInfo = allInfo == null ? null : allInfo.trim();
    }

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public void setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl == null ? null : voiceUrl.trim();
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    public String getVoicename() {
        return voicename;
    }

    public void setVoicename(String voicename) {
        this.voicename = voicename == null ? null : voicename.trim();
    }
}