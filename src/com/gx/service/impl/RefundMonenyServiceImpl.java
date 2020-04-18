package com.gx.service.impl;

import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gx.po.ZfRefunds;
import com.gx.service.RefundMonenyService;
import com.gx.dao.ZfRefundsMapper;
@Service
public class RefundMonenyServiceImpl implements RefundMonenyService{
	
	@Autowired
	private ZfRefundsMapper ZfRefundsMapper; // 注入dao层
	@Override
	public List<ZfRefunds> query(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ZfRefundsMapper.query(map);
	}

	@Override
	public int getTotalSize(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ZfRefundsMapper.getTotalSize(map);
	}

	@Override
	public int updateById(ZfRefunds record) {
		// TODO Auto-generated method stub
		return ZfRefundsMapper.updateById(record);
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return ZfRefundsMapper.deleteById(id);
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return ZfRefundsMapper.deleteByIds(ids);
	}

}
