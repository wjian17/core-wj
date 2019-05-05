package knowledge.accumulation.springcloud.mybatis_generator;

import java.util.Date;

public class CommonInvoice {
    private Integer id;

    private Integer contractId;

    private String policyNo;

    private String invoiceTitle;

    private String invoiceTaxNo;

    private String invoicePhone;

    private String invoiceEmail;

    private String invoiceUrl;

    private Boolean invoiceType;

    private Boolean invoiceFormat;

    private Boolean invoiceStatus;

    private Boolean mailStatus;

    private Date createTime;

    private Date updateTime;

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

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public String getInvoiceTaxNo() {
        return invoiceTaxNo;
    }

    public void setInvoiceTaxNo(String invoiceTaxNo) {
        this.invoiceTaxNo = invoiceTaxNo == null ? null : invoiceTaxNo.trim();
    }

    public String getInvoicePhone() {
        return invoicePhone;
    }

    public void setInvoicePhone(String invoicePhone) {
        this.invoicePhone = invoicePhone == null ? null : invoicePhone.trim();
    }

    public String getInvoiceEmail() {
        return invoiceEmail;
    }

    public void setInvoiceEmail(String invoiceEmail) {
        this.invoiceEmail = invoiceEmail == null ? null : invoiceEmail.trim();
    }

    public String getInvoiceUrl() {
        return invoiceUrl;
    }

    public void setInvoiceUrl(String invoiceUrl) {
        this.invoiceUrl = invoiceUrl == null ? null : invoiceUrl.trim();
    }

    public Boolean getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Boolean invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Boolean getInvoiceFormat() {
        return invoiceFormat;
    }

    public void setInvoiceFormat(Boolean invoiceFormat) {
        this.invoiceFormat = invoiceFormat;
    }

    public Boolean getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(Boolean invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public Boolean getMailStatus() {
        return mailStatus;
    }

    public void setMailStatus(Boolean mailStatus) {
        this.mailStatus = mailStatus;
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
}