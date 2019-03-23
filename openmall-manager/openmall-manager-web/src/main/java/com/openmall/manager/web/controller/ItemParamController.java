package com.openmall.manager.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openmall.common.pojo.EUDataGridResult;
import com.openmall.common.pojo.TaotaoResult;
import com.openmall.manager.pojo.TbItemParam;
import com.openmall.manager.service.ItemParamService;

@RestController
@RequestMapping("/item/param")
public class ItemParamController {

	@Autowired
	private ItemParamService itemParamService;

	@GetMapping("/query/itemcatid/{itemCatId}")
	public TaotaoResult getItemParamByCid(@PathVariable Long itemCatId) {
		TaotaoResult result = itemParamService.getItemParamByCid(itemCatId);
		return result;
	}

	@PostMapping("/delete")
	public TaotaoResult deleteItemParam(String ids) {
		String[] idstmp = ids.split(",");
		// Collections
		List<Long> list = stringConvertLong(idstmp);
		TaotaoResult result = itemParamService.deleteItemParamByIds(list);
		return result;
	}

	@RequestMapping("/save/{cid}")
	public TaotaoResult insertItemParam(@PathVariable Long cid, String paramData) {
		// 创建pojo对象
		TbItemParam itemParam = new TbItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		TaotaoResult result = itemParamService.insertItemParam(itemParam);
		return result;
	}

	/**
	 * GET /item/param/list?page=1&rows=10 404
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/list")
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		EUDataGridResult result = itemParamService.getItemParamList(page, rows);
		return result;
	}

	private List<Long> stringConvertLong(String[] values) {
		List<Long> list = new ArrayList<>();
		for (String s : values) {
			list.add(Long.parseLong(s));
		}
		return list;
	}
}