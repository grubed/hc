package com.hongcheng.techinnovte.common;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import io.minio.MinioClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import io.minio.errors.*;

@Configuration
public class MinioAutoConfiguration {
    @Autowired
    private MinioProperties properties;

    @Bean
    public MinioClient minioClient() throws InvalidPortException, InvalidEndpointException {
        return new MinioClient(
                    properties.getUrl(),
                    properties.getAccessKey(),
                    properties.getSecretKey()
            );
    }


    public String getBucketName(){
        return properties.getBucketName();
    }
}
