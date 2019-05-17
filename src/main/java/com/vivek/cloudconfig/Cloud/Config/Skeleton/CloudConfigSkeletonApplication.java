package com.vivek.cloudconfig.Cloud.Config.Skeleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudConfigSkeletonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigSkeletonApplication.class, args);
	}

}
