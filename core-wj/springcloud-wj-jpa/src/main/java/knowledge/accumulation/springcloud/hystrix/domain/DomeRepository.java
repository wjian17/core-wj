package knowledge.accumulation.springcloud.hystrix.domain;

import knowledge.accumulation.springcloud.module.jpa.pojo.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("domeRepository")
public interface DomeRepository extends JpaRepository<Test,Long> {
}
