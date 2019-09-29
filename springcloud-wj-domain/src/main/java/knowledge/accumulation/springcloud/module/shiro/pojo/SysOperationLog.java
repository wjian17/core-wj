package knowledge.accumulation.springcloud.module.shiro.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sys_operation_log", schema = "manager", catalog = "")
public class SysOperationLog {
    private long operationLogId;
    private String logType;
    private String logName;
    private Long userId;
    private String className;
    private String method;
    private Timestamp createTime;
    private String succeed;
    private String message;

    @Id
    @Column(name = "OPERATION_LOG_ID", nullable = false)
    public long getOperationLogId() {
        return operationLogId;
    }

    public void setOperationLogId(long operationLogId) {
        this.operationLogId = operationLogId;
    }

    @Basic
    @Column(name = "LOG_TYPE", nullable = true, length = 32)
    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
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
    @Column(name = "CLASS_NAME", nullable = true, length = 255)
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Basic
    @Column(name = "METHOD", nullable = true, length = -1)
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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
    @Column(name = "SUCCEED", nullable = true, length = 32)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysOperationLog that = (SysOperationLog) o;
        return operationLogId == that.operationLogId &&
                Objects.equals(logType, that.logType) &&
                Objects.equals(logName, that.logName) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(className, that.className) &&
                Objects.equals(method, that.method) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(succeed, that.succeed) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationLogId, logType, logName, userId, className, method, createTime, succeed, message);
    }
}
