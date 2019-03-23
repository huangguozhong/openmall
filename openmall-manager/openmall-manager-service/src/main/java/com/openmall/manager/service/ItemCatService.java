package com.openmall.manager.service;

import java.util.List;

import com.openmall.common.pojo.EUTreeNode;

public interface ItemCatService {

	List<EUTreeNode> getCatList(long parentId);
}
