package com.knowledge.accumulation.common.module.shiro.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserPojo implements Serializable {

    private Long id;

    private String username;

    private String password;

    private String salt;

    private Date createTime;

    private Date updateTime;
}
