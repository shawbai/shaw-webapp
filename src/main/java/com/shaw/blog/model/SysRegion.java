package com.shaw.blog.model;

import com.shaw.blog.core.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_region")
public class SysRegion extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_time")
    private Date modifyTime;

    private Long version;

    /**
     * 省/市名称
     */
    private String name;

    /**
     * 父id 0省
     */
    @Column(name = "p_id")
    private Long pId;

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
     * 获取省/市名称
     *
     * @return name - 省/市名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置省/市名称
     *
     * @param name 省/市名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取父id 0省
     *
     * @return p_id - 父id 0省
     */
    public Long getpId() {
        return pId;
    }

    /**
     * 设置父id 0省
     *
     * @param pId 父id 0省
     */
    public void setpId(Long pId) {
        this.pId = pId;
    }
}