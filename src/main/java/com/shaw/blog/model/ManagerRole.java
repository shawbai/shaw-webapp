package com.shaw.blog.model;

import com.shaw.blog.core.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "manager_role")
public class ManagerRole extends BaseEntity {
    /**
     * 后台管理角色
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_time")
    private Date modifyTime;

    private Long version;

    private String name;

    private String available;

    @Column(name = "manager_user_id")
    private Long managerUserId;

    /**
     * 获取后台管理角色
     *
     * @return id - 后台管理角色
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置后台管理角色
     *
     * @param id 后台管理角色
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return available
     */
    public String getAvailable() {
        return available;
    }

    /**
     * @param available
     */
    public void setAvailable(String available) {
        this.available = available;
    }

    /**
     * @return manager_user_id
     */
    public Long getManagerUserId() {
        return managerUserId;
    }

    /**
     * @param managerUserId
     */
    public void setManagerUserId(Long managerUserId) {
        this.managerUserId = managerUserId;
    }
}