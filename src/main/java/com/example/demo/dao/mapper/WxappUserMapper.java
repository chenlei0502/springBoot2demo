package com.example.demo.dao.mapper;

import com.example.demo.model.WxappUser;
import com.example.demo.model.WxappUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxappUserMapper {
    int countByExample(WxappUserExample example);

    int deleteByExample(WxappUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxappUser record);

    int insertSelective(WxappUser record);

    List<WxappUser> selectByExample(WxappUserExample example);

    WxappUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxappUser record, @Param("example") WxappUserExample example);

    int updateByExample(@Param("record") WxappUser record, @Param("example") WxappUserExample example);

    int updateByPrimaryKeySelective(WxappUser record);

    int updateByPrimaryKey(WxappUser record);
}