package com.yugioh.block.demo.service;

import com.yugioh.block.demo.entity.Block;
import com.yugioh.block.demo.entity.Business;

import java.util.List;

/**
 * @Author Create By lieber
 * @Description 区块服务
 * @Date Create in 2018/5/23 10:28
 * @Modify By
 */
public interface IBlockService {

    /**
     * 生成一个区块
     *
     * @param prevBlock  上一个区块信息
     * @param businesses 本次区块业务数据
     * @return 新区块对象
     */
    Block generateBlock(Block prevBlock, List<Business> businesses);

    /**
     * 计算区块的hash值
     *
     * @param block 区块信息
     * @return 区块的hash
     */
    String calculateHash(Block block);

    /**
     * 校验区块的合法性（有效性）
     *
     * @param newBlock 想要添加到链上的区块
     * @param oldBlock 原链上最后一个区块
     * @return 是否合法
     */
    boolean isBlockValid(Block newBlock, Block oldBlock);

    /**
     * 将区块放到链上
     *
     * @param block 待放置的区块
     * @return 是否放置成功
     */
    boolean putToChain(Block block);

    /**
     * 获取最后一个区块
     *
     * @return 最后一个区块
     */
    Block getLastBlock();

}
