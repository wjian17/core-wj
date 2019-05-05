package knowledge.accumulation.springcloud.mybatis_generator;

import knowledge.accumulation.springcloud.mybatis_generator.CommonInvoice;

public interface CommonInvoiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonInvoice record);

    int insertSelective(CommonInvoice record);

    CommonInvoice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonInvoice record);

    int updateByPrimaryKey(CommonInvoice record);
}