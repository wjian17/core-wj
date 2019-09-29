package knowledge.accumulation.springcloud.module.shiro.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sys_dept", schema = "manager", catalog = "")
public class SysDept {
    private long deptId;
    private Long pid;
    private String pids;
    private String simpleName;
    private String fullName;
    private String description;
    private Integer version;
    private Integer sort;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Long createUser;
    private Long updateUser;

    @Id
    @Column(name = "DEPT_ID", nullable = false)
    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "PID", nullable = true)
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "PIDS", nullable = true, length = 512)
    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    @Basic
    @Column(name = "SIMPLE_NAME", nullable = true, length = 45)
    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    @Basic
    @Column(name = "FULL_NAME", nullable = true, length = 255)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "VERSION", nullable = true)
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Basic
    @Column(name = "SORT", nullable = true)
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
    @Column(name = "UPDATE_TIME", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "CREATE_USER", nullable = true)
    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "UPDATE_USER", nullable = true)
    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysDept sysDept = (SysDept) o;
        return deptId == sysDept.deptId &&
                Objects.equals(pid, sysDept.pid) &&
                Objects.equals(pids, sysDept.pids) &&
                Objects.equals(simpleName, sysDept.simpleName) &&
                Objects.equals(fullName, sysDept.fullName) &&
                Objects.equals(description, sysDept.description) &&
                Objects.equals(version, sysDept.version) &&
                Objects.equals(sort, sysDept.sort) &&
                Objects.equals(createTime, sysDept.createTime) &&
                Objects.equals(updateTime, sysDept.updateTime) &&
                Objects.equals(createUser, sysDept.createUser) &&
                Objects.equals(updateUser, sysDept.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, pid, pids, simpleName, fullName, description, version, sort, createTime, updateTime, createUser, updateUser);
    }
}
