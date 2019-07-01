package com.inspur.shardingsphere.mybatis.service;

public interface CommonService {
    
    void initEnvironment();
    
    void cleanEnvironment();
    
    void processSuccess();
    
    void processFailure();
    
    void printData();
    
}
