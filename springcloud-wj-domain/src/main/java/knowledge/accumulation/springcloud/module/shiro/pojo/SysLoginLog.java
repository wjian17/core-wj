package knowledge.accumulation.springcloud.module.shiro.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sys_login_log", schema = "manager", catalog = "")
public class SysLoginLog {
    private long loginLogId;
    private String logName;
    private Long userId;
    private Timestamp createTime;
    private String succeed;
    private String message;
    private String ipAddress;

    @Id
    @Column(name = "LOGIN_LOG_ID", nullable = false)
    public long getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(long loginLogId) {
        this.loginLogId = loginLogId;
    }

    @Basic
    @Column(name = "LOG_NAME", nullable = true, length = 255)
    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    @Basic
    @Column(name = "USER_ID", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "CREATE_TIME", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "SUCCEED", nullable = true, length = 255)
    public String getSucceed() {
        return succeed;
    }

    public void setSucceed(String succeed) {
        this.succeed = succeed;
    }

    @Basic
    @Column(name = "MESSAGE", nullable = true, length = -1)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "IP_ADDRESS", nullable = true, length = 255)
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysLoginLog that = (SysLoginLog) o;
        return loginLogId == that.loginLogId &&
                Objects.equals(logName, that.logName) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(succeed, that.succeed) &&
                Objects.equals(message, that.message) &&
                Objects.equals(ipAddress, that.ipAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginLogId, logName, userId, createTime, succeed, message, ipAddress);
    }
}
