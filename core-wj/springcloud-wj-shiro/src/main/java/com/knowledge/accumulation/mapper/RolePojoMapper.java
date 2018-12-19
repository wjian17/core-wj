package com.knowledge.accumulation.mapper;

import com.knowledge.accumulation.module.shiro.pojo.RolePojo;

public interface RolePojoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePojo record);

    int insertSelective(RolePojo record);

    RolePojo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePojo record);

    int updateByPrimaryKey(RolePojo record);
}