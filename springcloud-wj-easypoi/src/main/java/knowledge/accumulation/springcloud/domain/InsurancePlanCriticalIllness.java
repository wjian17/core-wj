package knowledge.accumulation.springcloud.domain;

import knowledge.accumulation.springcloud.utils.EasypoiUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class InsurancePlanCriticalIllness {
    private Integer id;

    private String planNo;

    private String insRiskCode;

    private Integer age;

    private Integer maxAge;

    private Integer sex;

    private String extendJson;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanNo() {
        return planNo;
    }

    public void setPlanNo(String planNo) {
        this.planNo = planNo == null ? null : planNo.trim();
    }

    public String getInsRiskCode() {
        return insRiskCode;
    }

    public void setInsRiskCode(String insRiskCode) {
        this.insRiskCode = insRiskCode == null ? null : insRiskCode.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getExtendJson() {
        return extendJson;
    }

    public void setExtendJson(String extendJson) {
        this.extendJson = extendJson == null ? null : extendJson.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\wjian\\Desktop\\1.xlsx";
        List<Risk120151> lists = EasypoiUtils.importExcel(filePath,1,1,Risk120151.class);
        String sql = "INSERT INTO `insurance_plan_critical_illness` (\n" +
                "  `plan_no`,\n" +
                "  `ins_risk_code`,\n" +
                "  `age`,\n" +
                "  `max_age`,\n" +
                "  `sex`,\n" +
                "  `extend_json`\n" +
                ") \n" +
                "VALUES \n";
        String values = "";
        for(Risk120151 risk120151:lists){
            values=values+"('120151','120151','"+risk120151.getAge()+"','1','0','"+
                    "[(\"payYears\":3,\"rate\":"+new BigDecimal(risk120151.getYear_3()).divide(new BigDecimal(1000),5,BigDecimal.ROUND_HALF_UP)+"),"+
                    "[(\"payYears\":4,\"rate\":"+new BigDecimal(risk120151.getYear_4()).divide(new BigDecimal(1000),5,BigDecimal.ROUND_HALF_UP)+"),"+
            "[(\"payYears\":8,\"rate\":"+new BigDecimal(risk120151.getYear_8()).divide(new BigDecimal(1000),5,BigDecimal.ROUND_HALF_UP)+"),"+
            "[(\"payYears\":9,\"rate\":"+new BigDecimal(risk120151.getYear_9()).divide(new BigDecimal(1000),5,BigDecimal.ROUND_HALF_UP)+"),"+
            "[(\"payYears\":13,\"rate\":"+new BigDecimal(risk120151.getYear_13()).divide(new BigDecimal(1000),5,BigDecimal.ROUND_HALF_UP)+"),"+
            "[(\"payYears\":14,\"rate\":"+new BigDecimal(risk120151.getYear_14()).divide(new BigDecimal(1000),5,BigDecimal.ROUND_HALF_UP)+"),"+
            "[(\"payYears\":18,\"rate\":"+new BigDecimal(risk120151.getYear_18()).divide(new BigDecimal(1000),5,BigDecimal.ROUND_HALF_UP)+"),";
            if(risk120151.getAge()>50) {
                values = values+"[(\"payYears\":19,\"rate\":" + new BigDecimal(risk120151.getYear_19()).divide(new BigDecimal(1000),5,BigDecimal.ROUND_HALF_UP) + ")]";

            }else{
                values = values+"[(\"payYears\":19,\"rate\":" + new BigDecimal(risk120151.getYear_19()).divide(new BigDecimal(1000),5,BigDecimal.ROUND_HALF_UP) + ")," +
                        "[(\"payYears\":28,\"rate\":" + new BigDecimal(risk120151.getYear_28()).divide(new BigDecimal(1000),5,BigDecimal.ROUND_HALF_UP) + ")," +
                        "[(\"payYears\":29,\"rate\":" + new BigDecimal(risk120151.getYear_29()).divide(new BigDecimal(1000),5,BigDecimal.ROUND_HALF_UP) + ")]";
            }
            values=values+ "'),\n";
        }
        sql = sql +values;
        System.out.println(sql);
    }
}