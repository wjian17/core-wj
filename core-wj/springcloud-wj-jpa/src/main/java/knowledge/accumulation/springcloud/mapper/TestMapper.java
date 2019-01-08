package knowledge.accumulation.springcloud.mapper;

import knowledge.accumulation.springcloud.module.jpa.pojo.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestMapper extends JpaRepository<Test,Long>,BaseMapper {

}
