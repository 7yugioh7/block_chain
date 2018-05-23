package com.yugioh.block.demo.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author Create By lieber
 * @Description 启动时执行
 * @Date Create in 2018/5/23 15:16
 * @Modify By
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("启动执行了");
        // TODO 1.自举进入网络,
        // TODO 2.拉取现有网络
        // TODO 3.拉取最长链
    }
}
