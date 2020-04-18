package com.gx.service;

import java.util.List;
import java.util.Map;

import com.gx.po.ZfRefunds;

public interface RefundMonenyService {
	    public List<ZfRefunds> query(Map<String, Object> map);//分页查询
	    // 分页查询数据
		public int getTotalSize(Map<String, Object> map);
		public  int  updateById(ZfRefunds record);
		public  int  deleteById(Integer id);
		public  int deleteByIds(int[] ids);
}
