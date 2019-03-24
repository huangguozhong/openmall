package com.openmall.rest.service;

import java.util.List;

import com.openmall.manager.pojo.TbContent;

public interface ContentService {

	List<TbContent> getContentList(long contentCid);
}
