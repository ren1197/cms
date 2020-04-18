package com.gx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gx.po.XxProduct;
import com.gx.po.XxProductExample;

public interface XxProductMapper {
    int countByExample(XxProductExample example);

    int deleteByExample(XxProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(XxProduct record);

    int insertSelective(XxProduct record);

    List<XxProduct> selectByExampleWithBLOBs(XxProductExample example);

    List<XxProduct> selectByExample(XxProductExample example);

    XxProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") XxProduct record, @Param("example") XxProductExample example);

    int updateByExampleWithBLOBs(@Param("record") XxProduct record, @Param("example") XxProductExample example);

    int updateByExample(@Param("record") XxProduct record, @Param("example") XxProductExample example);

    int updateByPrimaryKeySelective(XxProduct record);

    int updateByPrimaryKeyWithBLOBs(XxProduct record);

    int updateByPrimaryKey(XxProduct record);
    
    //自定义方法
    public List<XxProduct> findProductByName(String productName);

}