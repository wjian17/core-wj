package knowledge.accumulation.springcloud.dao;

import knowledge.accumulation.springcloud.domain.SolrTbEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper
public interface SolrTbDao extends JpaRepository<SolrTbEntity,String> {
}
