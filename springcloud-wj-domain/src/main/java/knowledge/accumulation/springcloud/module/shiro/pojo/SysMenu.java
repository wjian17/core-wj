package knowledge.accumulation.springcloud.module.shiro.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sys_menu", schema = "manager", catalog = "")
public class SysMenu {
    private long menuId;
    private String code;
    private String pcode;
    private String pcodes;
    private String name;
    private String icon;
    private String url;
    private Integer sort;
    private Integer levels;
    private String menuFlag;
    private String description;
    private String status;
    private String newPageFlag;
    private String openFlag;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Long createUser;
    private Long updateUser;

    @Id
    @Column(name = "MENU_ID", nullable = false)
    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
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
    @Column(name = "PCODE", nullable = true, length = 255)
    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    @Basic
    @Column(name = "PCODES", nullable = true, length = 255)
    public String getPcodes() {
        return pcodes;
    }

    public void setPcodes(String pcodes) {
        this.pcodes = pcodes;
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
    @Column(name = "ICON", nullable = true, length = 255)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "URL", nullable = true, length = 255)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    @Column(name = "LEVELS", nullable = true)
    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    @Basic
    @Column(name = "MENU_FLAG", nullable = true, length = 32)
    public String getMenuFlag() {
        return menuFlag;
    }

    public void setMenuFlag(String menuFlag) {
        this.menuFlag = menuFlag;
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
    @Column(name = "STATUS", nullable = true, length = 32)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "NEW_PAGE_FLAG", nullable = true, length = 32)
    public String getNewPageFlag() {
        return newPageFlag;
    }

    public void setNewPageFlag(String newPageFlag) {
        this.newPageFlag = newPageFlag;
    }

    @Basic
    @Column(name = "OPEN_FLAG", nullable = true, length = 32)
    public String getOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(String openFlag) {
        this.openFlag = openFlag;
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
        SysMenu sysMenu = (SysMenu) o;
        return menuId == sysMenu.menuId &&
                Objects.equals(code, sysMenu.code) &&
                Objects.equals(pcode, sysMenu.pcode) &&
                Objects.equals(pcodes, sysMenu.pcodes) &&
                Objects.equals(name, sysMenu.name) &&
                Objects.equals(icon, sysMenu.icon) &&
                Objects.equals(url, sysMenu.url) &&
                Objects.equals(sort, sysMenu.sort) &&
                Objects.equals(levels, sysMenu.levels) &&
                Objects.equals(menuFlag, sysMenu.menuFlag) &&
                Objects.equals(description, sysMenu.description) &&
                Objects.equals(status, sysMenu.status) &&
                Objects.equals(newPageFlag, sysMenu.newPageFlag) &&
                Objects.equals(openFlag, sysMenu.openFlag) &&
                Objects.equals(createTime, sysMenu.createTime) &&
                Objects.equals(updateTime, sysMenu.updateTime) &&
                Objects.equals(createUser, sysMenu.createUser) &&
                Objects.equals(updateUser, sysMenu.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, code, pcode, pcodes, name, icon, url, sort, levels, menuFlag, description, status, newPageFlag, openFlag, createTime, updateTime, createUser, updateUser);
    }
}
