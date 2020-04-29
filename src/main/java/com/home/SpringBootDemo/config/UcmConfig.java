package com.home.SpringBootDemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "ucm")
@Configuration("ucmProperties")
public class UcmConfig {

    private String socketTimeout;
    private String connectionSize;
    private String connectionWaitTime;
    private String username;
    private String password;
    private String url;
    private String wccUrl;
    private String tmpDir;

    public String getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(String socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public String getConnectionSize() {
        return connectionSize;
    }

    public void setConnectionSize(String connectionSize) {
        this.connectionSize = connectionSize;
    }

    public String getConnectionWaitTime() {
        return connectionWaitTime;
    }

    public void setConnectionWaitTime(String connectionWaitTime) {
        this.connectionWaitTime = connectionWaitTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWccUrl() {
        return wccUrl;
    }

    public void setWccUrl(String wccUrl) {
        this.wccUrl = wccUrl;
    }

    public String getTmpDir() {
        return tmpDir;
    }

    public void setTmpDir(String tmpDir) {
        this.tmpDir = tmpDir;
    }
}
