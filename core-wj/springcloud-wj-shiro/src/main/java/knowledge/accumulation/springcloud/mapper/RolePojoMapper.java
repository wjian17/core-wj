package knowledge.accumulation.springcloud.mapper;

import knowledge.accumulation.springcloud.module.shiro.pojo.RolePojo;

public interface RolePojoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePojo record);

    int insertSelective(RolePojo record);

    RolePojo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePojo record);

    int updateByPrimaryKey(RolePojo record);
}