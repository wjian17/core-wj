package com.knowledge.accumulation.mapper;

import com.knowledge.accumulation.module.shiro.pojo.UserPojo;

public interface UserPojoMapper {
    int deleteByPrimaryKey(UserPojo userPojo);

    int insert(UserPojo record);

    int insertSelective(UserPojo record);

    UserPojo selectByPrimaryKey(UserPojo userPojo);

    int updateByPrimaryKeySelective(UserPojo record);

    int updateByPrimaryKey(UserPojo record);
}