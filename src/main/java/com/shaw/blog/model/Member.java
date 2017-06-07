package com.shaw.blog.model;

import com.shaw.blog.core.BaseEntity;
import java.util.Date;
import javax.persistence.*;

public class Member extends BaseEntity {
    /**
     * 会员表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_time")
    private Date modifyTime;

    private Long version;

    /**
     * 用户名
     */
    @Column(name = "member_name")
    private String memberName;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态 1 为可用
     */
    private String status;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * QQid
     */
    @Column(name = "qq_openid")
    private String qqOpenid;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * 金额
     */
    private Double amount;

    /**
     * 积分
     */
    private Integer score;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户QQ号码
     */
    private String qq;

    /**
     * 用户EMAIL地址
     */
    private String email;

    /**
     * 用户地址
     */
    private String address;

    /**
     * 用户积分
     */
    private Integer mark;

    /**
     * 用户等级
     */
    @Column(name = "rank_id")
    private Integer rankId;

    /**
     * 用户上一次登录IP地址
     */
    @Column(name = "last_login_ip")
    private String lastLoginIp;

    /**
     * 用户生日
     */
    private Integer birthday;

    /**
     * 自我描述
     */
    private String description;

    /**
     * 用户头像存储路径
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 毕业学校
     */
    private String school;

    /**
     * 用户注册时IP地址
     */
    @Column(name = "register_ip")
    private String registerIp;

    /**
     * 拥有权限
     */
    private String power;

    /**
     * 获取会员表
     *
     * @return id - 会员表
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置会员表
     *
     * @param id 会员表
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
     * 获取用户名
     *
     * @return member_name - 用户名
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 设置用户名
     *
     * @param memberName 用户名
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
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
     * 获取状态 1 为可用
     *
     * @return status - 状态 1 为可用
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态 1 为可用
     *
     * @param status 状态 1 为可用
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取电话号码
     *
     * @return telephone - 电话号码
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置电话号码
     *
     * @param telephone 电话号码
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取QQid
     *
     * @return qq_openid - QQid
     */
    public String getQqOpenid() {
        return qqOpenid;
    }

    /**
     * 设置QQid
     *
     * @param qqOpenid QQid
     */
    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
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
     * 获取金额
     *
     * @return amount - 金额
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * 设置金额
     *
     * @param amount 金额
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * 获取积分
     *
     * @return score - 积分
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置积分
     *
     * @param score 积分
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取用户性别
     *
     * @return sex - 用户性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置用户性别
     *
     * @param sex 用户性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取用户QQ号码
     *
     * @return qq - 用户QQ号码
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置用户QQ号码
     *
     * @param qq 用户QQ号码
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取用户EMAIL地址
     *
     * @return email - 用户EMAIL地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置用户EMAIL地址
     *
     * @param email 用户EMAIL地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取用户地址
     *
     * @return address - 用户地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置用户地址
     *
     * @param address 用户地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取用户积分
     *
     * @return mark - 用户积分
     */
    public Integer getMark() {
        return mark;
    }

    /**
     * 设置用户积分
     *
     * @param mark 用户积分
     */
    public void setMark(Integer mark) {
        this.mark = mark;
    }

    /**
     * 获取用户等级
     *
     * @return rank_id - 用户等级
     */
    public Integer getRankId() {
        return rankId;
    }

    /**
     * 设置用户等级
     *
     * @param rankId 用户等级
     */
    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    /**
     * 获取用户上一次登录IP地址
     *
     * @return last_login_ip - 用户上一次登录IP地址
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 设置用户上一次登录IP地址
     *
     * @param lastLoginIp 用户上一次登录IP地址
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * 获取用户生日
     *
     * @return birthday - 用户生日
     */
    public Integer getBirthday() {
        return birthday;
    }

    /**
     * 设置用户生日
     *
     * @param birthday 用户生日
     */
    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取自我描述
     *
     * @return description - 自我描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置自我描述
     *
     * @param description 自我描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取用户头像存储路径
     *
     * @return image_url - 用户头像存储路径
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 设置用户头像存储路径
     *
     * @param imageUrl 用户头像存储路径
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 获取毕业学校
     *
     * @return school - 毕业学校
     */
    public String getSchool() {
        return school;
    }

    /**
     * 设置毕业学校
     *
     * @param school 毕业学校
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * 获取用户注册时IP地址
     *
     * @return register_ip - 用户注册时IP地址
     */
    public String getRegisterIp() {
        return registerIp;
    }

    /**
     * 设置用户注册时IP地址
     *
     * @param registerIp 用户注册时IP地址
     */
    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    /**
     * 获取拥有权限
     *
     * @return power - 拥有权限
     */
    public String getPower() {
        return power;
    }

    /**
     * 设置拥有权限
     *
     * @param power 拥有权限
     */
    public void setPower(String power) {
        this.power = power;
    }
}