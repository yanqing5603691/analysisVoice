package com.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class analysis_voiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public analysis_voiceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andNumberOfSyllablesIsNull() {
            addCriterion("number_of_syllables is null");
            return (Criteria) this;
        }

        public Criteria andNumberOfSyllablesIsNotNull() {
            addCriterion("number_of_syllables is not null");
            return (Criteria) this;
        }

        public Criteria andNumberOfSyllablesEqualTo(Integer value) {
            addCriterion("number_of_syllables =", value, "numberOfSyllables");
            return (Criteria) this;
        }

        public Criteria andNumberOfSyllablesNotEqualTo(Integer value) {
            addCriterion("number_of_syllables <>", value, "numberOfSyllables");
            return (Criteria) this;
        }

        public Criteria andNumberOfSyllablesGreaterThan(Integer value) {
            addCriterion("number_of_syllables >", value, "numberOfSyllables");
            return (Criteria) this;
        }

        public Criteria andNumberOfSyllablesGreaterThanOrEqualTo(Integer value) {
            addCriterion("number_of_syllables >=", value, "numberOfSyllables");
            return (Criteria) this;
        }

        public Criteria andNumberOfSyllablesLessThan(Integer value) {
            addCriterion("number_of_syllables <", value, "numberOfSyllables");
            return (Criteria) this;
        }

        public Criteria andNumberOfSyllablesLessThanOrEqualTo(Integer value) {
            addCriterion("number_of_syllables <=", value, "numberOfSyllables");
            return (Criteria) this;
        }

        public Criteria andNumberOfSyllablesIn(List<Integer> values) {
            addCriterion("number_of_syllables in", values, "numberOfSyllables");
            return (Criteria) this;
        }

        public Criteria andNumberOfSyllablesNotIn(List<Integer> values) {
            addCriterion("number_of_syllables not in", values, "numberOfSyllables");
            return (Criteria) this;
        }

        public Criteria andNumberOfSyllablesBetween(Integer value1, Integer value2) {
            addCriterion("number_of_syllables between", value1, value2, "numberOfSyllables");
            return (Criteria) this;
        }

        public Criteria andNumberOfSyllablesNotBetween(Integer value1, Integer value2) {
            addCriterion("number_of_syllables not between", value1, value2, "numberOfSyllables");
            return (Criteria) this;
        }

        public Criteria andNumberOfPausesIsNull() {
            addCriterion("number_of_pauses is null");
            return (Criteria) this;
        }

        public Criteria andNumberOfPausesIsNotNull() {
            addCriterion("number_of_pauses is not null");
            return (Criteria) this;
        }

        public Criteria andNumberOfPausesEqualTo(Integer value) {
            addCriterion("number_of_pauses =", value, "numberOfPauses");
            return (Criteria) this;
        }

        public Criteria andNumberOfPausesNotEqualTo(Integer value) {
            addCriterion("number_of_pauses <>", value, "numberOfPauses");
            return (Criteria) this;
        }

        public Criteria andNumberOfPausesGreaterThan(Integer value) {
            addCriterion("number_of_pauses >", value, "numberOfPauses");
            return (Criteria) this;
        }

        public Criteria andNumberOfPausesGreaterThanOrEqualTo(Integer value) {
            addCriterion("number_of_pauses >=", value, "numberOfPauses");
            return (Criteria) this;
        }

        public Criteria andNumberOfPausesLessThan(Integer value) {
            addCriterion("number_of_pauses <", value, "numberOfPauses");
            return (Criteria) this;
        }

        public Criteria andNumberOfPausesLessThanOrEqualTo(Integer value) {
            addCriterion("number_of_pauses <=", value, "numberOfPauses");
            return (Criteria) this;
        }

        public Criteria andNumberOfPausesIn(List<Integer> values) {
            addCriterion("number_of_pauses in", values, "numberOfPauses");
            return (Criteria) this;
        }

        public Criteria andNumberOfPausesNotIn(List<Integer> values) {
            addCriterion("number_of_pauses not in", values, "numberOfPauses");
            return (Criteria) this;
        }

        public Criteria andNumberOfPausesBetween(Integer value1, Integer value2) {
            addCriterion("number_of_pauses between", value1, value2, "numberOfPauses");
            return (Criteria) this;
        }

        public Criteria andNumberOfPausesNotBetween(Integer value1, Integer value2) {
            addCriterion("number_of_pauses not between", value1, value2, "numberOfPauses");
            return (Criteria) this;
        }

        public Criteria andRateOfSpeechIsNull() {
            addCriterion("rate_of_speech is null");
            return (Criteria) this;
        }

        public Criteria andRateOfSpeechIsNotNull() {
            addCriterion("rate_of_speech is not null");
            return (Criteria) this;
        }

        public Criteria andRateOfSpeechEqualTo(Float value) {
            addCriterion("rate_of_speech =", value, "rateOfSpeech");
            return (Criteria) this;
        }

        public Criteria andRateOfSpeechNotEqualTo(Float value) {
            addCriterion("rate_of_speech <>", value, "rateOfSpeech");
            return (Criteria) this;
        }

        public Criteria andRateOfSpeechGreaterThan(Float value) {
            addCriterion("rate_of_speech >", value, "rateOfSpeech");
            return (Criteria) this;
        }

        public Criteria andRateOfSpeechGreaterThanOrEqualTo(Float value) {
            addCriterion("rate_of_speech >=", value, "rateOfSpeech");
            return (Criteria) this;
        }

        public Criteria andRateOfSpeechLessThan(Float value) {
            addCriterion("rate_of_speech <", value, "rateOfSpeech");
            return (Criteria) this;
        }

        public Criteria andRateOfSpeechLessThanOrEqualTo(Float value) {
            addCriterion("rate_of_speech <=", value, "rateOfSpeech");
            return (Criteria) this;
        }

        public Criteria andRateOfSpeechIn(List<Float> values) {
            addCriterion("rate_of_speech in", values, "rateOfSpeech");
            return (Criteria) this;
        }

        public Criteria andRateOfSpeechNotIn(List<Float> values) {
            addCriterion("rate_of_speech not in", values, "rateOfSpeech");
            return (Criteria) this;
        }

        public Criteria andRateOfSpeechBetween(Float value1, Float value2) {
            addCriterion("rate_of_speech between", value1, value2, "rateOfSpeech");
            return (Criteria) this;
        }

        public Criteria andRateOfSpeechNotBetween(Float value1, Float value2) {
            addCriterion("rate_of_speech not between", value1, value2, "rateOfSpeech");
            return (Criteria) this;
        }

        public Criteria andArticulationRateIsNull() {
            addCriterion("articulation_rate is null");
            return (Criteria) this;
        }

        public Criteria andArticulationRateIsNotNull() {
            addCriterion("articulation_rate is not null");
            return (Criteria) this;
        }

        public Criteria andArticulationRateEqualTo(Float value) {
            addCriterion("articulation_rate =", value, "articulationRate");
            return (Criteria) this;
        }

        public Criteria andArticulationRateNotEqualTo(Float value) {
            addCriterion("articulation_rate <>", value, "articulationRate");
            return (Criteria) this;
        }

        public Criteria andArticulationRateGreaterThan(Float value) {
            addCriterion("articulation_rate >", value, "articulationRate");
            return (Criteria) this;
        }

        public Criteria andArticulationRateGreaterThanOrEqualTo(Float value) {
            addCriterion("articulation_rate >=", value, "articulationRate");
            return (Criteria) this;
        }

        public Criteria andArticulationRateLessThan(Float value) {
            addCriterion("articulation_rate <", value, "articulationRate");
            return (Criteria) this;
        }

        public Criteria andArticulationRateLessThanOrEqualTo(Float value) {
            addCriterion("articulation_rate <=", value, "articulationRate");
            return (Criteria) this;
        }

        public Criteria andArticulationRateIn(List<Float> values) {
            addCriterion("articulation_rate in", values, "articulationRate");
            return (Criteria) this;
        }

        public Criteria andArticulationRateNotIn(List<Float> values) {
            addCriterion("articulation_rate not in", values, "articulationRate");
            return (Criteria) this;
        }

        public Criteria andArticulationRateBetween(Float value1, Float value2) {
            addCriterion("articulation_rate between", value1, value2, "articulationRate");
            return (Criteria) this;
        }

        public Criteria andArticulationRateNotBetween(Float value1, Float value2) {
            addCriterion("articulation_rate not between", value1, value2, "articulationRate");
            return (Criteria) this;
        }

        public Criteria andSpeakingDurationIsNull() {
            addCriterion("speaking_duration is null");
            return (Criteria) this;
        }

        public Criteria andSpeakingDurationIsNotNull() {
            addCriterion("speaking_duration is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakingDurationEqualTo(Float value) {
            addCriterion("speaking_duration =", value, "speakingDuration");
            return (Criteria) this;
        }

        public Criteria andSpeakingDurationNotEqualTo(Float value) {
            addCriterion("speaking_duration <>", value, "speakingDuration");
            return (Criteria) this;
        }

        public Criteria andSpeakingDurationGreaterThan(Float value) {
            addCriterion("speaking_duration >", value, "speakingDuration");
            return (Criteria) this;
        }

        public Criteria andSpeakingDurationGreaterThanOrEqualTo(Float value) {
            addCriterion("speaking_duration >=", value, "speakingDuration");
            return (Criteria) this;
        }

        public Criteria andSpeakingDurationLessThan(Float value) {
            addCriterion("speaking_duration <", value, "speakingDuration");
            return (Criteria) this;
        }

        public Criteria andSpeakingDurationLessThanOrEqualTo(Float value) {
            addCriterion("speaking_duration <=", value, "speakingDuration");
            return (Criteria) this;
        }

        public Criteria andSpeakingDurationIn(List<Float> values) {
            addCriterion("speaking_duration in", values, "speakingDuration");
            return (Criteria) this;
        }

        public Criteria andSpeakingDurationNotIn(List<Float> values) {
            addCriterion("speaking_duration not in", values, "speakingDuration");
            return (Criteria) this;
        }

        public Criteria andSpeakingDurationBetween(Float value1, Float value2) {
            addCriterion("speaking_duration between", value1, value2, "speakingDuration");
            return (Criteria) this;
        }

        public Criteria andSpeakingDurationNotBetween(Float value1, Float value2) {
            addCriterion("speaking_duration not between", value1, value2, "speakingDuration");
            return (Criteria) this;
        }

        public Criteria andOriginalDurationIsNull() {
            addCriterion("original_duration is null");
            return (Criteria) this;
        }

        public Criteria andOriginalDurationIsNotNull() {
            addCriterion("original_duration is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalDurationEqualTo(Float value) {
            addCriterion("original_duration =", value, "originalDuration");
            return (Criteria) this;
        }

        public Criteria andOriginalDurationNotEqualTo(Float value) {
            addCriterion("original_duration <>", value, "originalDuration");
            return (Criteria) this;
        }

        public Criteria andOriginalDurationGreaterThan(Float value) {
            addCriterion("original_duration >", value, "originalDuration");
            return (Criteria) this;
        }

        public Criteria andOriginalDurationGreaterThanOrEqualTo(Float value) {
            addCriterion("original_duration >=", value, "originalDuration");
            return (Criteria) this;
        }

        public Criteria andOriginalDurationLessThan(Float value) {
            addCriterion("original_duration <", value, "originalDuration");
            return (Criteria) this;
        }

        public Criteria andOriginalDurationLessThanOrEqualTo(Float value) {
            addCriterion("original_duration <=", value, "originalDuration");
            return (Criteria) this;
        }

        public Criteria andOriginalDurationIn(List<Float> values) {
            addCriterion("original_duration in", values, "originalDuration");
            return (Criteria) this;
        }

        public Criteria andOriginalDurationNotIn(List<Float> values) {
            addCriterion("original_duration not in", values, "originalDuration");
            return (Criteria) this;
        }

        public Criteria andOriginalDurationBetween(Float value1, Float value2) {
            addCriterion("original_duration between", value1, value2, "originalDuration");
            return (Criteria) this;
        }

        public Criteria andOriginalDurationNotBetween(Float value1, Float value2) {
            addCriterion("original_duration not between", value1, value2, "originalDuration");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(Float value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(Float value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(Float value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(Float value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(Float value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(Float value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<Float> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<Float> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(Float value1, Float value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(Float value1, Float value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andF0MeanIsNull() {
            addCriterion("f0_mean is null");
            return (Criteria) this;
        }

        public Criteria andF0MeanIsNotNull() {
            addCriterion("f0_mean is not null");
            return (Criteria) this;
        }

        public Criteria andF0MeanEqualTo(Float value) {
            addCriterion("f0_mean =", value, "f0Mean");
            return (Criteria) this;
        }

        public Criteria andF0MeanNotEqualTo(Float value) {
            addCriterion("f0_mean <>", value, "f0Mean");
            return (Criteria) this;
        }

        public Criteria andF0MeanGreaterThan(Float value) {
            addCriterion("f0_mean >", value, "f0Mean");
            return (Criteria) this;
        }

        public Criteria andF0MeanGreaterThanOrEqualTo(Float value) {
            addCriterion("f0_mean >=", value, "f0Mean");
            return (Criteria) this;
        }

        public Criteria andF0MeanLessThan(Float value) {
            addCriterion("f0_mean <", value, "f0Mean");
            return (Criteria) this;
        }

        public Criteria andF0MeanLessThanOrEqualTo(Float value) {
            addCriterion("f0_mean <=", value, "f0Mean");
            return (Criteria) this;
        }

        public Criteria andF0MeanIn(List<Float> values) {
            addCriterion("f0_mean in", values, "f0Mean");
            return (Criteria) this;
        }

        public Criteria andF0MeanNotIn(List<Float> values) {
            addCriterion("f0_mean not in", values, "f0Mean");
            return (Criteria) this;
        }

        public Criteria andF0MeanBetween(Float value1, Float value2) {
            addCriterion("f0_mean between", value1, value2, "f0Mean");
            return (Criteria) this;
        }

        public Criteria andF0MeanNotBetween(Float value1, Float value2) {
            addCriterion("f0_mean not between", value1, value2, "f0Mean");
            return (Criteria) this;
        }

        public Criteria andF0StdIsNull() {
            addCriterion("f0_std is null");
            return (Criteria) this;
        }

        public Criteria andF0StdIsNotNull() {
            addCriterion("f0_std is not null");
            return (Criteria) this;
        }

        public Criteria andF0StdEqualTo(Float value) {
            addCriterion("f0_std =", value, "f0Std");
            return (Criteria) this;
        }

        public Criteria andF0StdNotEqualTo(Float value) {
            addCriterion("f0_std <>", value, "f0Std");
            return (Criteria) this;
        }

        public Criteria andF0StdGreaterThan(Float value) {
            addCriterion("f0_std >", value, "f0Std");
            return (Criteria) this;
        }

        public Criteria andF0StdGreaterThanOrEqualTo(Float value) {
            addCriterion("f0_std >=", value, "f0Std");
            return (Criteria) this;
        }

        public Criteria andF0StdLessThan(Float value) {
            addCriterion("f0_std <", value, "f0Std");
            return (Criteria) this;
        }

        public Criteria andF0StdLessThanOrEqualTo(Float value) {
            addCriterion("f0_std <=", value, "f0Std");
            return (Criteria) this;
        }

        public Criteria andF0StdIn(List<Float> values) {
            addCriterion("f0_std in", values, "f0Std");
            return (Criteria) this;
        }

        public Criteria andF0StdNotIn(List<Float> values) {
            addCriterion("f0_std not in", values, "f0Std");
            return (Criteria) this;
        }

        public Criteria andF0StdBetween(Float value1, Float value2) {
            addCriterion("f0_std between", value1, value2, "f0Std");
            return (Criteria) this;
        }

        public Criteria andF0StdNotBetween(Float value1, Float value2) {
            addCriterion("f0_std not between", value1, value2, "f0Std");
            return (Criteria) this;
        }

        public Criteria andF0MedianIsNull() {
            addCriterion("f0_median is null");
            return (Criteria) this;
        }

        public Criteria andF0MedianIsNotNull() {
            addCriterion("f0_median is not null");
            return (Criteria) this;
        }

        public Criteria andF0MedianEqualTo(Float value) {
            addCriterion("f0_median =", value, "f0Median");
            return (Criteria) this;
        }

        public Criteria andF0MedianNotEqualTo(Float value) {
            addCriterion("f0_median <>", value, "f0Median");
            return (Criteria) this;
        }

        public Criteria andF0MedianGreaterThan(Float value) {
            addCriterion("f0_median >", value, "f0Median");
            return (Criteria) this;
        }

        public Criteria andF0MedianGreaterThanOrEqualTo(Float value) {
            addCriterion("f0_median >=", value, "f0Median");
            return (Criteria) this;
        }

        public Criteria andF0MedianLessThan(Float value) {
            addCriterion("f0_median <", value, "f0Median");
            return (Criteria) this;
        }

        public Criteria andF0MedianLessThanOrEqualTo(Float value) {
            addCriterion("f0_median <=", value, "f0Median");
            return (Criteria) this;
        }

        public Criteria andF0MedianIn(List<Float> values) {
            addCriterion("f0_median in", values, "f0Median");
            return (Criteria) this;
        }

        public Criteria andF0MedianNotIn(List<Float> values) {
            addCriterion("f0_median not in", values, "f0Median");
            return (Criteria) this;
        }

        public Criteria andF0MedianBetween(Float value1, Float value2) {
            addCriterion("f0_median between", value1, value2, "f0Median");
            return (Criteria) this;
        }

        public Criteria andF0MedianNotBetween(Float value1, Float value2) {
            addCriterion("f0_median not between", value1, value2, "f0Median");
            return (Criteria) this;
        }

        public Criteria andF0MinIsNull() {
            addCriterion("f0_min is null");
            return (Criteria) this;
        }

        public Criteria andF0MinIsNotNull() {
            addCriterion("f0_min is not null");
            return (Criteria) this;
        }

        public Criteria andF0MinEqualTo(Float value) {
            addCriterion("f0_min =", value, "f0Min");
            return (Criteria) this;
        }

        public Criteria andF0MinNotEqualTo(Float value) {
            addCriterion("f0_min <>", value, "f0Min");
            return (Criteria) this;
        }

        public Criteria andF0MinGreaterThan(Float value) {
            addCriterion("f0_min >", value, "f0Min");
            return (Criteria) this;
        }

        public Criteria andF0MinGreaterThanOrEqualTo(Float value) {
            addCriterion("f0_min >=", value, "f0Min");
            return (Criteria) this;
        }

        public Criteria andF0MinLessThan(Float value) {
            addCriterion("f0_min <", value, "f0Min");
            return (Criteria) this;
        }

        public Criteria andF0MinLessThanOrEqualTo(Float value) {
            addCriterion("f0_min <=", value, "f0Min");
            return (Criteria) this;
        }

        public Criteria andF0MinIn(List<Float> values) {
            addCriterion("f0_min in", values, "f0Min");
            return (Criteria) this;
        }

        public Criteria andF0MinNotIn(List<Float> values) {
            addCriterion("f0_min not in", values, "f0Min");
            return (Criteria) this;
        }

        public Criteria andF0MinBetween(Float value1, Float value2) {
            addCriterion("f0_min between", value1, value2, "f0Min");
            return (Criteria) this;
        }

        public Criteria andF0MinNotBetween(Float value1, Float value2) {
            addCriterion("f0_min not between", value1, value2, "f0Min");
            return (Criteria) this;
        }

        public Criteria andF0MaxIsNull() {
            addCriterion("f0_max is null");
            return (Criteria) this;
        }

        public Criteria andF0MaxIsNotNull() {
            addCriterion("f0_max is not null");
            return (Criteria) this;
        }

        public Criteria andF0MaxEqualTo(Float value) {
            addCriterion("f0_max =", value, "f0Max");
            return (Criteria) this;
        }

        public Criteria andF0MaxNotEqualTo(Float value) {
            addCriterion("f0_max <>", value, "f0Max");
            return (Criteria) this;
        }

        public Criteria andF0MaxGreaterThan(Float value) {
            addCriterion("f0_max >", value, "f0Max");
            return (Criteria) this;
        }

        public Criteria andF0MaxGreaterThanOrEqualTo(Float value) {
            addCriterion("f0_max >=", value, "f0Max");
            return (Criteria) this;
        }

        public Criteria andF0MaxLessThan(Float value) {
            addCriterion("f0_max <", value, "f0Max");
            return (Criteria) this;
        }

        public Criteria andF0MaxLessThanOrEqualTo(Float value) {
            addCriterion("f0_max <=", value, "f0Max");
            return (Criteria) this;
        }

        public Criteria andF0MaxIn(List<Float> values) {
            addCriterion("f0_max in", values, "f0Max");
            return (Criteria) this;
        }

        public Criteria andF0MaxNotIn(List<Float> values) {
            addCriterion("f0_max not in", values, "f0Max");
            return (Criteria) this;
        }

        public Criteria andF0MaxBetween(Float value1, Float value2) {
            addCriterion("f0_max between", value1, value2, "f0Max");
            return (Criteria) this;
        }

        public Criteria andF0MaxNotBetween(Float value1, Float value2) {
            addCriterion("f0_max not between", value1, value2, "f0Max");
            return (Criteria) this;
        }

        public Criteria andF0Quantile25IsNull() {
            addCriterion("f0_quantile25 is null");
            return (Criteria) this;
        }

        public Criteria andF0Quantile25IsNotNull() {
            addCriterion("f0_quantile25 is not null");
            return (Criteria) this;
        }

        public Criteria andF0Quantile25EqualTo(Float value) {
            addCriterion("f0_quantile25 =", value, "f0Quantile25");
            return (Criteria) this;
        }

        public Criteria andF0Quantile25NotEqualTo(Float value) {
            addCriterion("f0_quantile25 <>", value, "f0Quantile25");
            return (Criteria) this;
        }

        public Criteria andF0Quantile25GreaterThan(Float value) {
            addCriterion("f0_quantile25 >", value, "f0Quantile25");
            return (Criteria) this;
        }

        public Criteria andF0Quantile25GreaterThanOrEqualTo(Float value) {
            addCriterion("f0_quantile25 >=", value, "f0Quantile25");
            return (Criteria) this;
        }

        public Criteria andF0Quantile25LessThan(Float value) {
            addCriterion("f0_quantile25 <", value, "f0Quantile25");
            return (Criteria) this;
        }

        public Criteria andF0Quantile25LessThanOrEqualTo(Float value) {
            addCriterion("f0_quantile25 <=", value, "f0Quantile25");
            return (Criteria) this;
        }

        public Criteria andF0Quantile25In(List<Float> values) {
            addCriterion("f0_quantile25 in", values, "f0Quantile25");
            return (Criteria) this;
        }

        public Criteria andF0Quantile25NotIn(List<Float> values) {
            addCriterion("f0_quantile25 not in", values, "f0Quantile25");
            return (Criteria) this;
        }

        public Criteria andF0Quantile25Between(Float value1, Float value2) {
            addCriterion("f0_quantile25 between", value1, value2, "f0Quantile25");
            return (Criteria) this;
        }

        public Criteria andF0Quantile25NotBetween(Float value1, Float value2) {
            addCriterion("f0_quantile25 not between", value1, value2, "f0Quantile25");
            return (Criteria) this;
        }

        public Criteria andF0Quan75IsNull() {
            addCriterion("f0_quan75 is null");
            return (Criteria) this;
        }

        public Criteria andF0Quan75IsNotNull() {
            addCriterion("f0_quan75 is not null");
            return (Criteria) this;
        }

        public Criteria andF0Quan75EqualTo(Float value) {
            addCriterion("f0_quan75 =", value, "f0Quan75");
            return (Criteria) this;
        }

        public Criteria andF0Quan75NotEqualTo(Float value) {
            addCriterion("f0_quan75 <>", value, "f0Quan75");
            return (Criteria) this;
        }

        public Criteria andF0Quan75GreaterThan(Float value) {
            addCriterion("f0_quan75 >", value, "f0Quan75");
            return (Criteria) this;
        }

        public Criteria andF0Quan75GreaterThanOrEqualTo(Float value) {
            addCriterion("f0_quan75 >=", value, "f0Quan75");
            return (Criteria) this;
        }

        public Criteria andF0Quan75LessThan(Float value) {
            addCriterion("f0_quan75 <", value, "f0Quan75");
            return (Criteria) this;
        }

        public Criteria andF0Quan75LessThanOrEqualTo(Float value) {
            addCriterion("f0_quan75 <=", value, "f0Quan75");
            return (Criteria) this;
        }

        public Criteria andF0Quan75In(List<Float> values) {
            addCriterion("f0_quan75 in", values, "f0Quan75");
            return (Criteria) this;
        }

        public Criteria andF0Quan75NotIn(List<Float> values) {
            addCriterion("f0_quan75 not in", values, "f0Quan75");
            return (Criteria) this;
        }

        public Criteria andF0Quan75Between(Float value1, Float value2) {
            addCriterion("f0_quan75 between", value1, value2, "f0Quan75");
            return (Criteria) this;
        }

        public Criteria andF0Quan75NotBetween(Float value1, Float value2) {
            addCriterion("f0_quan75 not between", value1, value2, "f0Quan75");
            return (Criteria) this;
        }

        public Criteria andSexContentIsNull() {
            addCriterion("sex_content is null");
            return (Criteria) this;
        }

        public Criteria andSexContentIsNotNull() {
            addCriterion("sex_content is not null");
            return (Criteria) this;
        }

        public Criteria andSexContentEqualTo(String value) {
            addCriterion("sex_content =", value, "sexContent");
            return (Criteria) this;
        }

        public Criteria andSexContentNotEqualTo(String value) {
            addCriterion("sex_content <>", value, "sexContent");
            return (Criteria) this;
        }

        public Criteria andSexContentGreaterThan(String value) {
            addCriterion("sex_content >", value, "sexContent");
            return (Criteria) this;
        }

        public Criteria andSexContentGreaterThanOrEqualTo(String value) {
            addCriterion("sex_content >=", value, "sexContent");
            return (Criteria) this;
        }

        public Criteria andSexContentLessThan(String value) {
            addCriterion("sex_content <", value, "sexContent");
            return (Criteria) this;
        }

        public Criteria andSexContentLessThanOrEqualTo(String value) {
            addCriterion("sex_content <=", value, "sexContent");
            return (Criteria) this;
        }

        public Criteria andSexContentLike(String value) {
            addCriterion("sex_content like", value, "sexContent");
            return (Criteria) this;
        }

        public Criteria andSexContentNotLike(String value) {
            addCriterion("sex_content not like", value, "sexContent");
            return (Criteria) this;
        }

        public Criteria andSexContentIn(List<String> values) {
            addCriterion("sex_content in", values, "sexContent");
            return (Criteria) this;
        }

        public Criteria andSexContentNotIn(List<String> values) {
            addCriterion("sex_content not in", values, "sexContent");
            return (Criteria) this;
        }

        public Criteria andSexContentBetween(String value1, String value2) {
            addCriterion("sex_content between", value1, value2, "sexContent");
            return (Criteria) this;
        }

        public Criteria andSexContentNotBetween(String value1, String value2) {
            addCriterion("sex_content not between", value1, value2, "sexContent");
            return (Criteria) this;
        }

        public Criteria andAllInfoIsNull() {
            addCriterion("all_info is null");
            return (Criteria) this;
        }

        public Criteria andAllInfoIsNotNull() {
            addCriterion("all_info is not null");
            return (Criteria) this;
        }

        public Criteria andAllInfoEqualTo(String value) {
            addCriterion("all_info =", value, "allInfo");
            return (Criteria) this;
        }

        public Criteria andAllInfoNotEqualTo(String value) {
            addCriterion("all_info <>", value, "allInfo");
            return (Criteria) this;
        }

        public Criteria andAllInfoGreaterThan(String value) {
            addCriterion("all_info >", value, "allInfo");
            return (Criteria) this;
        }

        public Criteria andAllInfoGreaterThanOrEqualTo(String value) {
            addCriterion("all_info >=", value, "allInfo");
            return (Criteria) this;
        }

        public Criteria andAllInfoLessThan(String value) {
            addCriterion("all_info <", value, "allInfo");
            return (Criteria) this;
        }

        public Criteria andAllInfoLessThanOrEqualTo(String value) {
            addCriterion("all_info <=", value, "allInfo");
            return (Criteria) this;
        }

        public Criteria andAllInfoLike(String value) {
            addCriterion("all_info like", value, "allInfo");
            return (Criteria) this;
        }

        public Criteria andAllInfoNotLike(String value) {
            addCriterion("all_info not like", value, "allInfo");
            return (Criteria) this;
        }

        public Criteria andAllInfoIn(List<String> values) {
            addCriterion("all_info in", values, "allInfo");
            return (Criteria) this;
        }

        public Criteria andAllInfoNotIn(List<String> values) {
            addCriterion("all_info not in", values, "allInfo");
            return (Criteria) this;
        }

        public Criteria andAllInfoBetween(String value1, String value2) {
            addCriterion("all_info between", value1, value2, "allInfo");
            return (Criteria) this;
        }

        public Criteria andAllInfoNotBetween(String value1, String value2) {
            addCriterion("all_info not between", value1, value2, "allInfo");
            return (Criteria) this;
        }

        public Criteria andVoiceUrlIsNull() {
            addCriterion("voice_url is null");
            return (Criteria) this;
        }

        public Criteria andVoiceUrlIsNotNull() {
            addCriterion("voice_url is not null");
            return (Criteria) this;
        }

        public Criteria andVoiceUrlEqualTo(String value) {
            addCriterion("voice_url =", value, "voiceUrl");
            return (Criteria) this;
        }

        public Criteria andVoiceUrlNotEqualTo(String value) {
            addCriterion("voice_url <>", value, "voiceUrl");
            return (Criteria) this;
        }

        public Criteria andVoiceUrlGreaterThan(String value) {
            addCriterion("voice_url >", value, "voiceUrl");
            return (Criteria) this;
        }

        public Criteria andVoiceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("voice_url >=", value, "voiceUrl");
            return (Criteria) this;
        }

        public Criteria andVoiceUrlLessThan(String value) {
            addCriterion("voice_url <", value, "voiceUrl");
            return (Criteria) this;
        }

        public Criteria andVoiceUrlLessThanOrEqualTo(String value) {
            addCriterion("voice_url <=", value, "voiceUrl");
            return (Criteria) this;
        }

        public Criteria andVoiceUrlLike(String value) {
            addCriterion("voice_url like", value, "voiceUrl");
            return (Criteria) this;
        }

        public Criteria andVoiceUrlNotLike(String value) {
            addCriterion("voice_url not like", value, "voiceUrl");
            return (Criteria) this;
        }

        public Criteria andVoiceUrlIn(List<String> values) {
            addCriterion("voice_url in", values, "voiceUrl");
            return (Criteria) this;
        }

        public Criteria andVoiceUrlNotIn(List<String> values) {
            addCriterion("voice_url not in", values, "voiceUrl");
            return (Criteria) this;
        }

        public Criteria andVoiceUrlBetween(String value1, String value2) {
            addCriterion("voice_url between", value1, value2, "voiceUrl");
            return (Criteria) this;
        }

        public Criteria andVoiceUrlNotBetween(String value1, String value2) {
            addCriterion("voice_url not between", value1, value2, "voiceUrl");
            return (Criteria) this;
        }

        public Criteria andInserttimeIsNull() {
            addCriterion("insertTime is null");
            return (Criteria) this;
        }

        public Criteria andInserttimeIsNotNull() {
            addCriterion("insertTime is not null");
            return (Criteria) this;
        }

        public Criteria andInserttimeEqualTo(Date value) {
            addCriterion("insertTime =", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotEqualTo(Date value) {
            addCriterion("insertTime <>", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeGreaterThan(Date value) {
            addCriterion("insertTime >", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("insertTime >=", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeLessThan(Date value) {
            addCriterion("insertTime <", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeLessThanOrEqualTo(Date value) {
            addCriterion("insertTime <=", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeIn(List<Date> values) {
            addCriterion("insertTime in", values, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotIn(List<Date> values) {
            addCriterion("insertTime not in", values, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeBetween(Date value1, Date value2) {
            addCriterion("insertTime between", value1, value2, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotBetween(Date value1, Date value2) {
            addCriterion("insertTime not between", value1, value2, "inserttime");
            return (Criteria) this;
        }

        public Criteria andVoicenameIsNull() {
            addCriterion("voiceName is null");
            return (Criteria) this;
        }

        public Criteria andVoicenameIsNotNull() {
            addCriterion("voiceName is not null");
            return (Criteria) this;
        }

        public Criteria andVoicenameEqualTo(String value) {
            addCriterion("voiceName =", value, "voicename");
            return (Criteria) this;
        }

        public Criteria andVoicenameNotEqualTo(String value) {
            addCriterion("voiceName <>", value, "voicename");
            return (Criteria) this;
        }

        public Criteria andVoicenameGreaterThan(String value) {
            addCriterion("voiceName >", value, "voicename");
            return (Criteria) this;
        }

        public Criteria andVoicenameGreaterThanOrEqualTo(String value) {
            addCriterion("voiceName >=", value, "voicename");
            return (Criteria) this;
        }

        public Criteria andVoicenameLessThan(String value) {
            addCriterion("voiceName <", value, "voicename");
            return (Criteria) this;
        }

        public Criteria andVoicenameLessThanOrEqualTo(String value) {
            addCriterion("voiceName <=", value, "voicename");
            return (Criteria) this;
        }

        public Criteria andVoicenameLike(String value) {
            addCriterion("voiceName like", value, "voicename");
            return (Criteria) this;
        }

        public Criteria andVoicenameNotLike(String value) {
            addCriterion("voiceName not like", value, "voicename");
            return (Criteria) this;
        }

        public Criteria andVoicenameIn(List<String> values) {
            addCriterion("voiceName in", values, "voicename");
            return (Criteria) this;
        }

        public Criteria andVoicenameNotIn(List<String> values) {
            addCriterion("voiceName not in", values, "voicename");
            return (Criteria) this;
        }

        public Criteria andVoicenameBetween(String value1, String value2) {
            addCriterion("voiceName between", value1, value2, "voicename");
            return (Criteria) this;
        }

        public Criteria andVoicenameNotBetween(String value1, String value2) {
            addCriterion("voiceName not between", value1, value2, "voicename");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}