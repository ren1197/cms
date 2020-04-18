package com.gx.dao;



import com.gx.po.BAdPosition;
import com.gx.po.BArticle;
import com.gx.po.BArticleCategory;
import com.gx.po.BArticleCategoryExample;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BArticleCategoryMapper {
    int countByExample(BArticleCategoryExample example);

    int deleteByExample(BArticleCategoryExample example);

    int deleteByPrimaryKey(Integer id);

  

    int insertSelective(BArticleCategory record);

    List<BArticleCategory> selectByExample(BArticleCategoryExample example);

    BArticleCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BArticleCategory record, @Param("example") BArticleCategoryExample example);

    int updateByExample(@Param("record") BArticleCategory record, @Param("example") BArticleCategoryExample example);

    int updateByPrimaryKeySelective(BArticleCategory record);

    int updateByPrimaryKey(BArticleCategory record);
  
   //自定义方法
    int insert(BArticleCategory record);
    //查询所有分类
    List<BArticleCategory> selectAllCategory(BArticleCategory example);
    //列表展示
    List<BArticleCategory> selectAllInfo(BArticleCategory example);
    int  updateById(BArticleCategory record);
    BArticleCategory   selectById(Integer id);
    int  deleteById(Integer id);
    int deleteByIds(int[] ids);
    
   	 List<BArticleCategory> selectAllDel(Map<String, Object> map);
  	 public int getTotalDelSize(Map<String, Object> map);
  	//彻底删除
  	 int deleteAllByIds(int[] ids);
  	 public void updateDelState(Map<String,Object> map);	//批量恢复
  	 List<BArticleCategory> getList();
  	 public List< BArticleCategory > query(Map<String, Object> map);//分页查询
     // 分页查询数据
 	public int getTotalSize(Map<String, Object> map);
    
}