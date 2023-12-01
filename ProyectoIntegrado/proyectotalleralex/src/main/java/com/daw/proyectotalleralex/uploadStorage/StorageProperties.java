package com.daw.proyectotalleralex.uploadStorage;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="storage")
public class StorageProperties {

    
    private String location = "src/main/webapp/img/prod";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
