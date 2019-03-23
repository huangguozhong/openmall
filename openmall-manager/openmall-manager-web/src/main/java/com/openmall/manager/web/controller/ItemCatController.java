package com.openmall.manager.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openmall.common.pojo.EUTreeNode;
import com.openmall.manager.service.ItemCatService;


@RestController
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	/**
	 * [{"id":1,"text":"图书、音像、电子书刊","state":"closed"},{"id":74,"text":"家用电器","state":"closed"}]
	 * 这个应该用get但是前台js不好改直接post
	 * @param parentId
	 * @return
	 */
	@PostMapping("/list")
	private List<EUTreeNode> getCatList(@RequestParam(value="id",defaultValue="0")Long parentId) {
		List<EUTreeNode> list = itemCatService.getCatList(parentId);
		return list;
	}
}
