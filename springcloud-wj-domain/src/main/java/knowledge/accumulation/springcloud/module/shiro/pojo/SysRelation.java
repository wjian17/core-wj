package knowledge.accumulation.springcloud.module.shiro.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sys_relation", schema = "manager", catalog = "")
public class SysRelation {
    private long relationId;
    private Long menuId;
    private Long roleId;

    @Id
    @Column(name = "RELATION_ID", nullable = false)
    public long getRelationId() {
        return relationId;
    }

    public void setRelationId(long relationId) {
        this.relationId = relationId;
    }

    @Basic
    @Column(name = "MENU_ID", nullable = true)
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "ROLE_ID", nullable = true)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRelation that = (SysRelation) o;
        return relationId == that.relationId &&
                Objects.equals(menuId, that.menuId) &&
                Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationId, menuId, roleId);
    }
}
