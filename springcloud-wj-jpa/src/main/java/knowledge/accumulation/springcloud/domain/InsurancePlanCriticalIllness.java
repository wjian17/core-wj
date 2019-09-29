package knowledge.accumulation.springcloud.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "insurance_plan_critical_illness", schema = "manager", catalog = "")
public class InsurancePlanCriticalIllness {
    private int id;
    private String planNo;
    private String insRiskCode;
    private Integer age;
    private Integer maxAge;
    private Integer sex;
    private String extendJson;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "plan_no", nullable = true, length = 24)
    public String getPlanNo() {
        return planNo;
    }

    public void setPlanNo(String planNo) {
        this.planNo = planNo;
    }

    @Basic
    @Column(name = "ins_risk_code", nullable = true, length = 32)
    public String getInsRiskCode() {
        return insRiskCode;
    }

    public void setInsRiskCode(String insRiskCode) {
        this.insRiskCode = insRiskCode;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "max_age", nullable = true)
    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    @Basic
    @Column(name = "sex", nullable = true)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "extend_json", nullable = true, length = 1024)
    public String getExtendJson() {
        return extendJson;
    }

    public void setExtendJson(String extendJson) {
        this.extendJson = extendJson;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsurancePlanCriticalIllness that = (InsurancePlanCriticalIllness) o;
        return id == that.id &&
                Objects.equals(planNo, that.planNo) &&
                Objects.equals(insRiskCode, that.insRiskCode) &&
                Objects.equals(age, that.age) &&
                Objects.equals(maxAge, that.maxAge) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(extendJson, that.extendJson) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, planNo, insRiskCode, age, maxAge, sex, extendJson, createTime, updateTime);
    }
}
