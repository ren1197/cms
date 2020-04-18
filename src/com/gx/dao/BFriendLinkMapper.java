package com.gx.dao;

import com.gx.po.BArticle;
import com.gx.po.BArticleCategory;
import com.gx.po.BFriendLink;
import com.gx.po.BFriendLinkExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BFriendLinkMapper {
    int countByExample(BFriendLinkExample example);

    int deleteByExample(BFriendLinkExample example);

    int deleteByPrimaryKey(Integer id);

  

    int insertSelective(BFriendLink record);

    List<BFriendLink> selectByExample(BFriendLinkExample example);

    BFriendLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BFriendLink record, @Param("example") BFriendLinkExample example);

    int updateByExample(@Param("record") BFriendLink record, @Param("example") BFriendLinkExample example);

    int updateByPrimaryKeySelective(BFriendLink record);

    int updateByPrimaryKey(BFriendLink record);
  //自定义方法
    int insert(BFriendLink record);
    
    //列表展示
    List<BFriendLink> selectAllInfo(BFriendLink  example);
    int  updateById(BFriendLink record);
    BFriendLink selectById(Integer id);
     int  deleteById(Integer id);
     int deleteByIds(int[] ids);
     public List<BFriendLink> query(Map<String, Object> map);//分页查询
     // 分页查询数据
 	public int getTotalSize(Map<String, Object> map);
 	 public void updateState(Map<String,Object> map);	//修改状态
	    List<BFriendLink> selectAllDel(Map<String, Object> map);
	  	public int getTotalDelSize(Map<String, Object> map);
	  	//彻底删除
	  	 int deleteAllByIds(int[] ids);
	  	 public void updateDelState(Map<String,Object> map);	//批量恢复
}