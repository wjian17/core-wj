package knowledge.accumulation.springcloud.dao;

import knowledge.accumulation.springcloud.domain.SolrTbEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

@Mapper
public interface SolrTbDao extends JpaRepository<SolrTbEntity,String> {
//    private String id;
//    private String name;
//    private String address;
//    private Timestamp createTime;
//    private Integer valid;
    public SolrTbEntity findByName(@Param("name")String name);
}
