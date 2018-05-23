package com.yugioh.block.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author lieber
 */
@SpringBootApplication
@EnableScheduling
public class BlockDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlockDemoApplication.class, args);
	}
}
