package com.openmall.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openmall.manager.dao.TbItemMapper;
import com.openmall.manager.pojo.TbItem;
import com.openmall.manager.service.ItemService;


@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	TbItemMapper tbItemMapper;

	@Override
	public TbItem getItemById(long itemId) {
		TbItem TbItem = tbItemMapper.selectByPrimaryKey(itemId);
		return TbItem;
	}

	

}
