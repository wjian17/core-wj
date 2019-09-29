package knowledge.accumulation.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper extends BaseMapper {

    Long selectTest();

    List<Integer> getIdList();
}
