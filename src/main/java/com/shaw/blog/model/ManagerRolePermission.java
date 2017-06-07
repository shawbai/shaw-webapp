package com.shaw.blog.model;

import com.shaw.blog.core.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "manager_role_permission")
public class ManagerRolePermission extends BaseEntity {
    /**
     * 后台管理角色跟权限关联关系表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_time")
    private Date modifyTime;

    private Long version;

    @Column(name = "manager_role_id")
    private Long managerRoleId;

    @Column(name = "manager_permission_id")
    private Long managerPermissionId;

    /**
     * 获取后台管理角色跟权限关联关系表
     *
     * @return id - 后台管理角色跟权限关联关系表
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置后台管理角色跟权限关联关系表
     *
     * @param id 后台管理角色跟权限关联关系表
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * @return version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * @return manager_role_id
     */
    public Long getManagerRoleId() {
        return managerRoleId;
    }

    /**
     * @param managerRoleId
     */
    public void setManagerRoleId(Long managerRoleId) {
        this.managerRoleId = managerRoleId;
    }

    /**
     * @return manager_permission_id
     */
    public Long getManagerPermissionId() {
        return managerPermissionId;
    }

    /**
     * @param managerPermissionId
     */
    public void setManagerPermissionId(Long managerPermissionId) {
        this.managerPermissionId = managerPermissionId;
    }
}