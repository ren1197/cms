package com.gx.dao;


import com.gx.po.BDingshirenwu;
import com.gx.po.BDingshirenwuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BDingshirenwuMapper {
    int countByExample(BDingshirenwuExample example);

    int deleteByExample(BDingshirenwuExample example);

    int insert(BDingshirenwu record);

    int insertSelective(BDingshirenwu record);

    List<BDingshirenwu> selectByExample(BDingshirenwuExample example);

    int updateByExampleSelective(@Param("record") BDingshirenwu record, @Param("example") BDingshirenwuExample example);

    int updateByExample(@Param("record") BDingshirenwu record, @Param("example") BDingshirenwuExample example);

    //列表展示
    List<BDingshirenwu> selectAllInfo();
    int  updateById(BDingshirenwu record);
}