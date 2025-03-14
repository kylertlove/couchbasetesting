package com.vscodetesting.kyler.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Configuration;

import com.vscodetesting.kyler.service.IdentityManager;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@Endpoint(id = "lagerCount")
public class LagerHealthController {

    IdentityManager manager;
    
    @ReadOperation
    int getLagerCount() {
        return manager.getBeersByType("lager").size();
    }
}
