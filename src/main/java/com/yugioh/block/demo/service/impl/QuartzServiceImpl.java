package com.yugioh.block.demo.service.impl;

import com.yugioh.block.demo.entity.Block;
import com.yugioh.block.demo.entity.Business;
import com.yugioh.block.demo.service.IBlockService;
import com.yugioh.block.demo.service.IBusinessService;
import com.yugioh.block.demo.service.IQuartzService;
import com.yugioh.block.demo.utils.ObjectUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Create By lieber
 * @Description 定时任务实现
 * @Date Create in 2018/5/23 12:00
 * @Modify By
 */
@Service
public class QuartzServiceImpl implements IQuartzService {

    @Resource
    private IBusinessService businessService;
    @Resource
    private IBlockService blockService;
    @Resource
    private ObjectUtils objectUtils;

    @Scheduled(cron = "0 0/1 * * * ?")
    @Override
    public void broadcast() {
        // 每10分钟广播一次,
        // 1.获取这十分钟的所有交易
        List<Business> businesses = businessService.getBusiness();
        // 2.使用这些交易生成区块
        Block block = blockService.generateBlock(blockService.getLastBlock(), objectUtils.deepCopy(businesses));
        // 3.广播区块
        System.out.println("现在进行广播通知,广播的区块是 " + (block == null ? "null" : block.toString()));
        // FIXME 此处模拟回应成功,将区块放置到链上
        blockService.putToChain(block);
        businessService.clear();
    }
}
