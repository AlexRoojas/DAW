package com.daw.proyectotalleralex.Config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.daw.proyectotalleralex.uploadStorage.StorageProperties;

@Configuration
@EnableConfigurationProperties(StorageProperties.class)
public class myConfig {

}
