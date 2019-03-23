package com.openmall.manager.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.openmall.common.pojo.EUDataGridResult;
import com.openmall.manager.service.ItemService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpenmallManagerWebApplicationTest {

	@Autowired
	private ItemService itemService;
	@Test
	public void contextLoads() {
		EUDataGridResult rs = itemService.getItemList(0, 30);
		System.out.println(rs);
	}

}
