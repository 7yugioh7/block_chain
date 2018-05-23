package com.yugioh.block.demo.service.impl;

import com.yugioh.block.demo.entity.Business;
import com.yugioh.block.demo.service.IBusinessService;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Create By lieber
 * @Description 交易服务实现
 * @Date Create in 2018/5/23 11:24
 * @Modify By
 */
@Service
public class BusinessServiceImpl implements IBusinessService {

    private static LinkedList<Business> businesses = null;

    @Override
    public void addBusiness(Business business) {
        // 目前将交易信息存储在内存中,可使用数据库等等
        if (business != null) {
            if (businesses == null) {
                businesses = new LinkedList<>();
            }
            businesses.add(business);
        }
    }

    @Override
    public List<Business> getBusiness() {
        return businesses;
    }

    @Override
    public void clear() {
        if (businesses != null) {
            businesses.clear();
        }
    }
}
