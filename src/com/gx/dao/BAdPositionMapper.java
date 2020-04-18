package com.gx.dao;

import com.gx.po.BAd;
import com.gx.po.BAdPosition;
import com.gx.po.BAdPositionExample;
import com.gx.po.BArticle;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BAdPositionMapper {
    int countByExample(BAdPositionExample example);

    int deleteByExample(BAdPositionExample example);

    int deleteByPrimaryKey(Integer id);

    

    int insertSelective(BAdPosition record);

    List<BAdPosition> selectByExample(BAdPositionExample example);

    BAdPosition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BAdPosition record, @Param("example") BAdPositionExample example);

    int updateByExample(@Param("record") BAdPosition record, @Param("example") BAdPositionExample example);

    int updateByPrimaryKeySelective(BAdPosition record);

    int updateByPrimaryKey(BAdPosition record);
  //自定义方法
    int insert(BAdPosition record);
    //查询所有分类
    List<BAdPosition> selectAllCategory(BAdPosition example);
    //列表展示
    List<BAdPosition> selectAllInfo(BAdPosition example);
    int  updateById(BAdPosition record);
    BAdPosition  selectById(Integer id);
    int  deleteById(Integer id);
    int deleteByIds(int[] ids);
    public void updateState(Map<String,Object> map);	//修改状态
    List<BAdPosition> selectAllDel(Map<String, Object> map);
 	public int getTotalDelSize(Map<String, Object> map);
 	//彻底删除
 	 int deleteAllByIds(int[] ids);
 	 public void updateDelState(Map<String,Object> map);	//批量恢复
 	public List<BAdPosition> getTrainTypeNuminfo(); //统计
 	 public List<BAdPosition> query(Map<String, Object> map);//分页查询
 	 // 分页查询数据
 	public int getTotalSize(Map<String, Object> map);
}