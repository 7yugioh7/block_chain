package com.yugioh.block.demo.service;

/**
 * @Author Create By lieber
 * @Description 定时任务服务
 * @Date Create in 2018/5/23 11:58
 * @Modify By
 */
public interface IQuartzService {

    /**
     * 广播(推送所有交易到其他节点)
     */
    void broadcast();

}
