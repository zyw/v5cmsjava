package cn.v5cn.v5cms.entity;

import javax.persistence.*;

@Table(name = "system_role_res")
public class SystemRoleRes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "res_id")
    private Long resId;

    @Column(name = "role_id")
    private Long roleId;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return res_id
     */
    public Long getResId() {
        return resId;
    }

    /**
     * @param resId
     */
    public void setResId(Long resId) {
        this.resId = resId;
    }

    /**
     * @return role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}