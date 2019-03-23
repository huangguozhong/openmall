package com.openmall.manager.service;

import com.openmall.common.pojo.EUDataGridResult;
import com.openmall.common.pojo.TaotaoResult;
import com.openmall.manager.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(long itemId);

	EUDataGridResult getItemList(int page, int rows);

	TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception;
}
