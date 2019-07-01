package com.inspur.shardingsphere.mybatis.entity;

import java.io.Serializable;

public class User implements Serializable {
    
    private static final long serialVersionUID = 263434701950670170L;
    
    private int userId;
    
    private String userName;
    
    private String pwd;
    
    private String assistedQueryPwd;
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getPwd() {
        return pwd;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public String getAssistedQueryPwd() {
        return assistedQueryPwd;
    }
    
    public void setAssistedQueryPwd(String assistedQueryPwd) {
        this.assistedQueryPwd = assistedQueryPwd;
    }
}
