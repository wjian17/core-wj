package knowledge.accumulation.springcloud.mapper;

import knowledge.accumulation.springcloud.module.shiro.pojo.UserPojo;

public interface UserPojoMapper {
    int deleteByPrimaryKey(UserPojo userPojo);

    int insert(UserPojo record);

    int insertSelective(UserPojo record);

    UserPojo selectByPrimaryKey(UserPojo userPojo);

    int updateByPrimaryKeySelective(UserPojo record);

    int updateByPrimaryKey(UserPojo record);
}