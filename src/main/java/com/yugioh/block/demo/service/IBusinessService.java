package com.yugioh.block.demo.service;

import com.yugioh.block.demo.entity.Business;

import java.util.List;

/**
 * @Author Create By lieber
 * @Description 交易服务
 * @Date Create in 2018/5/23 11:20
 * @Modify By
 */
public interface IBusinessService {

    /**
     * 添加一条交易
     *
     * @param business 交易信息
     */
    void addBusiness(Business business);

    /**
     * 获取交易列表
     *
     * @return 交易列表
     */
    List<Business> getBusiness();

    /**
     * 删除使用过交易信息
     */
    void clear();
}
