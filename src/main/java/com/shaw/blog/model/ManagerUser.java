package com.shaw.blog.model;

import com.shaw.blog.core.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "manager_user")
public class ManagerUser extends BaseEntity {
    /**
     * 平台用户信息表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_time")
    private Date modifyTime;

    private Long version;

    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 主次权限
     */
    private String child;

    /**
     * 是否可用
     */
    private String locked;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * 电话
     */
    private String telephone;

    @Column(name = "marked_type")
    private String markedType;

    /**
     * 备注
     */
    @Column(name = "biz_remark")
    private String bizRemark;

    private String secret;

    private String nickname;

    /**
     * 获取平台用户信息表
     *
     * @return id - 平台用户信息表
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置平台用户信息表
     *
     * @param id 平台用户信息表
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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取主次权限
     *
     * @return child - 主次权限
     */
    public String getChild() {
        return child;
    }

    /**
     * 设置主次权限
     *
     * @param child 主次权限
     */
    public void setChild(String child) {
        this.child = child;
    }

    /**
     * 获取是否可用
     *
     * @return locked - 是否可用
     */
    public String getLocked() {
        return locked;
    }

    /**
     * 设置是否可用
     *
     * @param locked 是否可用
     */
    public void setLocked(String locked) {
        this.locked = locked;
    }

    /**
     * 获取加密盐
     *
     * @return salt - 加密盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置加密盐
     *
     * @param salt 加密盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取电话
     *
     * @return telephone - 电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置电话
     *
     * @param telephone 电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return marked_type
     */
    public String getMarkedType() {
        return markedType;
    }

    /**
     * @param markedType
     */
    public void setMarkedType(String markedType) {
        this.markedType = markedType;
    }

    /**
     * 获取备注
     *
     * @return biz_remark - 备注
     */
    public String getBizRemark() {
        return bizRemark;
    }

    /**
     * 设置备注
     *
     * @param bizRemark 备注
     */
    public void setBizRemark(String bizRemark) {
        this.bizRemark = bizRemark;
    }

    /**
     * @return secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     * @param secret
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}