package com.openmall.manager.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openmall.common.pojo.EUDataGridResult;
import com.openmall.common.pojo.TaotaoResult;
import com.openmall.manager.pojo.TbItem;
import com.openmall.manager.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/{itemId}")
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}

	/**
	 *  /item/ist?page=1&rows=30
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/item/list")
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}

	
	
	@PostMapping("/item/save")
	private TaotaoResult createItem(TbItem item, String desc, String itemParams) throws Exception {
		TaotaoResult result = itemService.createItem(item, desc, itemParams);
		return result;
	}
}
