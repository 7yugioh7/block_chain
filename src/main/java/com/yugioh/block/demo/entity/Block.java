package com.yugioh.block.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Create By lieber
 * @Description 区块
 * @Date Create in 2018/5/23 10:16
 * @Modify By
 */
@Data
public class Block implements Serializable {
    /**
     * 区块序号
     */
    private int index;
    /**
     * 区块生成时间戳
     */
    private long timestamp;

    /**
     * 前一个区块的hash
     */
    private String prevHash;

    /**
     * 当前区块hash
     */
    private String hash;

    /**
     * 随机字符串
     */
    private String nonceStr;

    /**
     * 区块交易数据
     */
    List<Business> body;

    public Block() {
    }

    public Block(int index, long timestamp, String prevHash, String hash, String nonceStr, List<Business> body) {
        this.index = index;
        this.timestamp = timestamp;
        this.prevHash = prevHash;
        this.hash = hash;
        this.nonceStr = nonceStr;
        this.body = body;
    }
}
