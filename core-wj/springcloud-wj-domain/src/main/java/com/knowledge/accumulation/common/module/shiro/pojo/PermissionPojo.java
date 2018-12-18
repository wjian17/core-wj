package com.knowledge.accumulation.common.module.shiro.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PermissionPojo implements Serializable {

    private Long id;

    private String name;

    private String url;

    private int type;

    private Long pid;

    private int orderNum;

    private String pids;

    private String percode;

}
