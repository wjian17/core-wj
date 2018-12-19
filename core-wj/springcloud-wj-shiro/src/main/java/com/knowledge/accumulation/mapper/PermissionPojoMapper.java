package com.knowledge.accumulation.mapper;

import com.knowledge.accumulation.module.shiro.pojo.PermissionPojo;

public interface PermissionPojoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermissionPojo record);

    int insertSelective(PermissionPojo record);

    PermissionPojo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermissionPojo record);

    int updateByPrimaryKey(PermissionPojo record);
}