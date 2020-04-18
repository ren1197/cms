package com.gx.dao;

import com.gx.po.BAd;
import com.gx.po.BAdExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BAdMapper {
    int countByExample(BAdExample example);

    int deleteByExample(BAdExample example);

    int deleteByPrimaryKey(Integer id);



    int insertSelective(BAd record);

    List<BAd> selectByExampleWithBLOBs(BAdExample example);

    List<BAd> selectByExample(BAdExample example);

    BAd selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BAd record, @Param("example") BAdExample example);

    int updateByExampleWithBLOBs(@Param("record") BAd record, @Param("example") BAdExample example);

    int updateByExample(@Param("record") BAd record, @Param("example") BAdExample example);

    int updateByPrimaryKeySelective(BAd record);

    int updateByPrimaryKeyWithBLOBs(BAd record);

    int updateByPrimaryKey(BAd record);
    //自定义方法
    int insert(BAd  record);

    //查询所有分类
    List<BAd> selectAllCategory(BAd  example);
    //列表展示
    List<BAd> selectAllInfo(BAd  example);
    int  updateById(BAd  record);
    BAd   selectById(Integer id);
    int  deleteById(Integer id);
    int deleteByIds(int[] ids);
    public List<BAd> query(Map<String, Object> map);//分页查询
    // 分页查询数据
	public int getTotalSize(Map<String, Object> map);
	public void updateState(Map<String,Object> map);	//修改状态
	
	    List<BAd> selectAllDel(Map<String, Object> map);
	 	public int getTotalDelSize(Map<String, Object> map);
	 	//彻底删除
	 	 int deleteAllByIds(int[] ids);
	 	 public void updateDelState(Map<String,Object> map);	//批量恢复
}