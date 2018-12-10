package com.knowledge.accumulation.bean;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.math.BigDecimal;
import java.util.Date;

@SolrDocument(solrCoreName = "collection1")
@Data
public class InsuranceContract {

    @Field("id")
    private Integer id;
    @Field("reqNo")
    private String reqNo;
    @Field("planNo")
    private String planNo;
    @Field("platformNo")
    private String platformNo;
    @Field("channelNo")
    private String channelNo;
    @Field("salesmanNo")
    private String salesmanNo;
    @Field("applicationNo")
    private String applicationNo;
    @Field("proposalNo")
    private String proposalNo;
    @Field("policyNo")
    private String policyNo;
    @Field("applicantType")
    private Integer applicantType;
    @Field("insuredType")
    private Integer insuredType;
    @Field("beneficiaryType")
    private Integer beneficiaryType;
    @Field("appInsRelation")
    private String appInsRelation;
    @Field("benInsRelation")
    private String benInsRelation;
    @Field("premium")
    private BigDecimal premium;
    @Field("amount")
    private BigDecimal amount;
    @Field("number")
    private Integer number;
    @Field("groupSign")
    private Integer groupSign;
    @Field("premiumBaseType")
    private Integer premiumBaseType;
    @Field("techServiceFeeRate")
    private BigDecimal techServiceFeeRate;
    @Field("brokerageRate")
    private BigDecimal brokerageRate;
    @Field("genOrderFeeRate")
    private BigDecimal genOrderFeeRate;
    @Field("taxFlag")
    private Integer taxFlag;
    @Field("payType")
    private Integer payType;
    @Field("settleType")
    private Integer settleType;
    @Field("payStatus")
    private Integer payStatus;
    @Field("serviceFee")
    private BigDecimal serviceFee;
    @Field("policyStatus")
    private Integer policyStatus;
    @Field("applicationUrl")
    private String applicationUrl;
    @Field("policyUrl")
    private String policyUrl;
    @Field("contractType")
    private Integer contractType;
    @Field("startTime")
    private Date startTime;
    @Field("endTime")
    private Date endTime;
    @Field("createTime")
    private Date createTime;
    @Field("acceptTime")
    private Date acceptTime;
    @Field("cancelTime")
    private Date cancelTime;
    @Field("payTime")
    private Date payTime;
    @Field("updateTime")
    private Date updateTime;
}