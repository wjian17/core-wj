package knowledge.accumulation.springcloud.module.shiro.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sys_notice", schema = "manager", catalog = "")
public class SysNotice {
    private long noticeId;
    private String title;
    private String content;
    private Timestamp createTime;
    private Long createUser;
    private Timestamp updateTime;
    private Long updateUser;

    @Id
    @Column(name = "NOTICE_ID", nullable = false)
    public long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(long noticeId) {
        this.noticeId = noticeId;
    }

    @Basic
    @Column(name = "TITLE", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "CONTENT", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysNotice sysNotice = (SysNotice) o;
        return noticeId == sysNotice.noticeId &&
                Objects.equals(title, sysNotice.title) &&
                Objects.equals(content, sysNotice.content) &&
                Objects.equals(createTime, sysNotice.createTime) &&
                Objects.equals(createUser, sysNotice.createUser) &&
                Objects.equals(updateTime, sysNotice.updateTime) &&
                Objects.equals(updateUser, sysNotice.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noticeId, title, content, createTime, createUser, updateTime, updateUser);
    }
}
