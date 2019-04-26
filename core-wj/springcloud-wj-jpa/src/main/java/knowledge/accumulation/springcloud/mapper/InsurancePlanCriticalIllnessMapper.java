package knowledge.accumulation.springcloud.mapper;

import knowledge.accumulation.springcloud.domain.InsurancePlanCriticalIllness;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InsurancePlanCriticalIllnessMapper {

    List<InsurancePlanCriticalIllness> queryAll();
}
