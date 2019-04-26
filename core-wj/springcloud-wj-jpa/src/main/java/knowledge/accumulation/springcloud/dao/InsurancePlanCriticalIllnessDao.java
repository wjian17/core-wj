package knowledge.accumulation.springcloud.dao;

import knowledge.accumulation.springcloud.domain.InsurancePlanCriticalIllness;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper
public interface InsurancePlanCriticalIllnessDao extends JpaRepository<InsurancePlanCriticalIllness,Integer> {

}
