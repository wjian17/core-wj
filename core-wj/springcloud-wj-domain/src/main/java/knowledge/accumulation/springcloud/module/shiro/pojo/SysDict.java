package knowledge.accumulation.springcloud.module.shiro.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sys_dict", schema = "manager", catalog = "")
public class SysDict {
    private long dictId;
    private Long pid;
    private String name;
    private String code;
    private String description;
    private Integer sort;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Long createUser;
    private Long updateUser;

    @Id
    @Column(name = "DICT_ID", nullable = false)
    public long getDictId() {
        return dictId;
    }

    public void setDictId(long dictId) {
        this.dictId = dictId;
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
    @Column(name = "NAME", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "CODE", nullable = true, length = 255)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        SysDict sysDict = (SysDict) o;
        return dictId == sysDict.dictId &&
                Objects.equals(pid, sysDict.pid) &&
                Objects.equals(name, sysDict.name) &&
                Objects.equals(code, sysDict.code) &&
                Objects.equals(description, sysDict.description) &&
                Objects.equals(sort, sysDict.sort) &&
                Objects.equals(createTime, sysDict.createTime) &&
                Objects.equals(updateTime, sysDict.updateTime) &&
                Objects.equals(createUser, sysDict.createUser) &&
                Objects.equals(updateUser, sysDict.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dictId, pid, name, code, description, sort, createTime, updateTime, createUser, updateUser);
    }
}
