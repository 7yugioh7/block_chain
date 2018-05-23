package com.yugioh.block.demo.controller;

import com.yugioh.block.demo.entity.Business;
import com.yugioh.block.demo.service.IBusinessService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Create By lieber
 * @Description
 * @Date Create in 2018/5/23 11:16
 * @Modify By
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @Resource
    private IBusinessService businessService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addBusiness(Business business) {
        businessService.addBusiness(business);
        return "{\"msg\" : \"成功\"}";
    }

}
