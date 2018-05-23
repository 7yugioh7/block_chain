package com.yugioh.block.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Create By lieber
 * @Description 区块内容(存放交易信息等,视具体业务而定)
 * @Date Create in 2018/5/23 10:22
 * @Modify By
 */
@Data
public class Business implements Serializable {

    /**
     * 身高
     */
    private int height;
    /**
     * 体重
     */
    private float weight;

    public Business() {
    }

    public Business(int height, float weight) {
        this.height = height;
        this.weight = weight;
    }
}
