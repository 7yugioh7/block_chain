package com.yugioh.block.demo;

import com.yugioh.block.demo.entity.Block;
import com.yugioh.block.demo.entity.Business;
import com.yugioh.block.demo.service.IBlockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlockDemoApplicationTests {

	@Resource
	private IBlockService blockService;

	@Test
	public void contextLoads() {
		List<Business> list = new ArrayList<>();
		list.add(new Business(10,10));
		Block block = blockService.generateBlock(null, list);
		System.out.println(block);
	}

}
