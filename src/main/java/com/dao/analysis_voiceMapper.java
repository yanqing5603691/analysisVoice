package com.dao;

import com.entity.analysis_voice;
import com.entity.analysis_voiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface analysis_voiceMapper {
    long countByExample(analysis_voiceExample example);

    int deleteByExample(analysis_voiceExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(analysis_voice record);

    int insertSelective(analysis_voice record);

    List<analysis_voice> selectByExample(analysis_voiceExample example);

    analysis_voice selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") analysis_voice record, @Param("example") analysis_voiceExample example);

    int updateByExample(@Param("record") analysis_voice record, @Param("example") analysis_voiceExample example);

    int updateByPrimaryKeySelective(analysis_voice record);

    int updateByPrimaryKey(analysis_voice record);
}