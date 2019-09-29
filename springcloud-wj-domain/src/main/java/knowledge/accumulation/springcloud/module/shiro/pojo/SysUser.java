package knowledge.accumulation.springcloud.module.shiro.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sys_user", schema = "manager", catalog = "")
public class SysUser {
    private long userId;
    private String avatar;
    private String account;
    private String password;
    private String salt;
    private String name;
    private Timestamp birthday;
    private String sex;
    private String email;
    private String phone;
    private String roleId;
    private Long deptId;
    private String status;
    private Timestamp createTime;
    private Long createUser;
    private Timestamp updateTime;
    private Long updateUser;
    private Integer version;

    @Id
    @Column(name = "USER_ID", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "AVATAR", nullable = true, length = 255)
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "ACCOUNT", nullable = true, length = 45)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "SALT", nullable = true, length = 45)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "BIRTHDAY", nullable = true)
    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "SEX", nullable = true, length = 32)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PHONE", nullable = true, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "ROLE_ID", nullable = true, length = 255)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "DEPT_ID", nullable = true)
    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, length = 32)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    @Column(name = "CREATE_USER", nullable = true)
    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
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
    @Column(name = "UPDATE_USER", nullable = true)
    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    @Basic
    @Column(name = "VERSION", nullable = true)
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUser sysUser = (SysUser) o;
        return userId == sysUser.userId &&
                Objects.equals(avatar, sysUser.avatar) &&
                Objects.equals(account, sysUser.account) &&
                Objects.equals(password, sysUser.password) &&
                Objects.equals(salt, sysUser.salt) &&
                Objects.equals(name, sysUser.name) &&
                Objects.equals(birthday, sysUser.birthday) &&
                Objects.equals(sex, sysUser.sex) &&
                Objects.equals(email, sysUser.email) &&
                Objects.equals(phone, sysUser.phone) &&
                Objects.equals(roleId, sysUser.roleId) &&
                Objects.equals(deptId, sysUser.deptId) &&
                Objects.equals(status, sysUser.status) &&
                Objects.equals(createTime, sysUser.createTime) &&
                Objects.equals(createUser, sysUser.createUser) &&
                Objects.equals(updateTime, sysUser.updateTime) &&
                Objects.equals(updateUser, sysUser.updateUser) &&
                Objects.equals(version, sysUser.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, avatar, account, password, salt, name, birthday, sex, email, phone, roleId, deptId, status, createTime, createUser, updateTime, updateUser, version);
    }
}
