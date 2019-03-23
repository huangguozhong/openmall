package com.openmall.manager.service;

import java.util.List;

import com.openmall.common.pojo.EUDataGridResult;
import com.openmall.common.pojo.TaotaoResult;
import com.openmall.manager.pojo.TbItemParam;

public interface ItemParamService {

	TaotaoResult getItemParamByCid(long cid);

	TaotaoResult deleteItemParamByIds(List<Long> ids);
	
	TaotaoResult insertItemParam(TbItemParam itemParam);

	EUDataGridResult getItemParamList(int page, int rows);

}
