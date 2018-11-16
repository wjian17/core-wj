package com.knowledge.accumulation.common.param;

import java.io.Serializable;

/**
 * Created by wyf on 2017/6/28.
 * 参数实体公共父类，记录业务流水号 ip地址
 */
public class BaseParam implements Serializable{

    /**
     * 业务流水号
     */
    private String serialNo;

    /**
     * IP地址
     */
    private String ipAddr;


    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }
}
