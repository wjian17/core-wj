package knowledge.accumulation.springcloud.mapper;

import knowledge.accumulation.springcloud.module.shiro.pojo.PermissionPojo;

public interface PermissionPojoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermissionPojo record);

    int insertSelective(PermissionPojo record);

    PermissionPojo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermissionPojo record);

    int updateByPrimaryKey(PermissionPojo record);
}