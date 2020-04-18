package com.gx.dao;


import com.gx.po.ZfRefunds;
import com.gx.po.ZfRefundsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZfRefundsMapper {
    int countByExample(ZfRefundsExample example);

    int deleteByExample(ZfRefundsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ZfRefunds record);

    int insertSelective(ZfRefunds record);

    List<ZfRefunds> selectByExample(ZfRefundsExample example);

    ZfRefunds selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ZfRefunds record, @Param("example") ZfRefundsExample example);

    int updateByExample(@Param("record") ZfRefunds record, @Param("example") ZfRefundsExample example);

    int updateByPrimaryKeySelective(ZfRefunds record);

    int updateByPrimaryKey(ZfRefunds record);
    
    
    //自定义方法
    public List<ZfRefunds> query(Map<String, Object> map);//分页查询
    // 分页查询数据
	public int getTotalSize(Map<String, Object> map);
	 int  updateById(ZfRefunds record);
	 int  deleteById(Integer id);
	 int deleteByIds(int[] ids);
}