package knowledge.accumulation.springcloud.mybatis_generator;

import java.math.BigDecimal;
import java.util.Date;

public class InsuranceRiskTypeFosunJointChild {
    private Integer id;

    private Integer contractId;

    private String additionalPlanNo;

    private Integer payYears;

    private Integer insureYears;

    private String insureYearsIntv;

    private Date startDate;

    private BigDecimal amount;

    private String province;

    private String city;

    private String country;

    private BigDecimal height;

    private BigDecimal weight;

    private String bankCode;

    private String bankAccountName;

    private String bankAccountNo;

    private String bankAccountPhone;

    private Date appValStartDate;

    private Date appValEndDate;

    private Date insValStartDate;

    private Date insValEndDate;

    private String serialNo;

    private Date createTime;

    private Date endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getAdditionalPlanNo() {
        return additionalPlanNo;
    }

    public void setAdditionalPlanNo(String additionalPlanNo) {
        this.additionalPlanNo = additionalPlanNo == null ? null : additionalPlanNo.trim();
    }

    public Integer getPayYears() {
        return payYears;
    }

    public void setPayYears(Integer payYears) {
        this.payYears = payYears;
    }

    public Integer getInsureYears() {
        return insureYears;
    }

    public void setInsureYears(Integer insureYears) {
        this.insureYears = insureYears;
    }

    public String getInsureYearsIntv() {
        return insureYearsIntv;
    }

    public void setInsureYearsIntv(String insureYearsIntv) {
        this.insureYearsIntv = insureYearsIntv == null ? null : insureYearsIntv.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName == null ? null : bankAccountName.trim();
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo == null ? null : bankAccountNo.trim();
    }

    public String getBankAccountPhone() {
        return bankAccountPhone;
    }

    public void setBankAccountPhone(String bankAccountPhone) {
        this.bankAccountPhone = bankAccountPhone == null ? null : bankAccountPhone.trim();
    }

    public Date getAppValStartDate() {
        return appValStartDate;
    }

    public void setAppValStartDate(Date appValStartDate) {
        this.appValStartDate = appValStartDate;
    }

    public Date getAppValEndDate() {
        return appValEndDate;
    }

    public void setAppValEndDate(Date appValEndDate) {
        this.appValEndDate = appValEndDate;
    }

    public Date getInsValStartDate() {
        return insValStartDate;
    }

    public void setInsValStartDate(Date insValStartDate) {
        this.insValStartDate = insValStartDate;
    }

    public Date getInsValEndDate() {
        return insValEndDate;
    }

    public void setInsValEndDate(Date insValEndDate) {
        this.insValEndDate = insValEndDate;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}