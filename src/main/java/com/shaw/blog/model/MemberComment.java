package com.shaw.blog.model;

import com.shaw.blog.core.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "member_comment")
public class MemberComment extends BaseEntity {
    /**
     * 评论自增ID号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_time")
    private Date modifyTime;

    private Long version;

    /**
     * 收到评论的用户ID
     */
    @Column(name = "member_id")
    private Long memberId;

    /**
     * 评论栏目ID
     */
    @Column(name = "article_id")
    private Long articleId;

    /**
     * 评论内容的ID
     */
    @Column(name = "commit_id")
    private Long commitId;

    /**
     * 评论内容
     */
    @Column(name = "commit_content")
    private String commitContent;

    /**
     * 评论者ID
     */
    @Column(name = "commit_member_id")
    private Long commitMemberId;

    /**
     * 评论时的IP地址
     */
    @Column(name = "commit_ip")
    private String commitIp;

    /**
     * 获取评论自增ID号
     *
     * @return id - 评论自增ID号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置评论自增ID号
     *
     * @param id 评论自增ID号
     */
    public void setId(Integer id) {
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
     * 获取收到评论的用户ID
     *
     * @return member_id - 收到评论的用户ID
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * 设置收到评论的用户ID
     *
     * @param memberId 收到评论的用户ID
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取评论栏目ID
     *
     * @return article_id - 评论栏目ID
     */
    public Long getArticleId() {
        return articleId;
    }

    /**
     * 设置评论栏目ID
     *
     * @param articleId 评论栏目ID
     */
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取评论内容的ID
     *
     * @return commit_id - 评论内容的ID
     */
    public Long getCommitId() {
        return commitId;
    }

    /**
     * 设置评论内容的ID
     *
     * @param commitId 评论内容的ID
     */
    public void setCommitId(Long commitId) {
        this.commitId = commitId;
    }

    /**
     * 获取评论内容
     *
     * @return commit_content - 评论内容
     */
    public String getCommitContent() {
        return commitContent;
    }

    /**
     * 设置评论内容
     *
     * @param commitContent 评论内容
     */
    public void setCommitContent(String commitContent) {
        this.commitContent = commitContent;
    }

    /**
     * 获取评论者ID
     *
     * @return commit_member_id - 评论者ID
     */
    public Long getCommitMemberId() {
        return commitMemberId;
    }

    /**
     * 设置评论者ID
     *
     * @param commitMemberId 评论者ID
     */
    public void setCommitMemberId(Long commitMemberId) {
        this.commitMemberId = commitMemberId;
    }

    /**
     * 获取评论时的IP地址
     *
     * @return commit_ip - 评论时的IP地址
     */
    public String getCommitIp() {
        return commitIp;
    }

    /**
     * 设置评论时的IP地址
     *
     * @param commitIp 评论时的IP地址
     */
    public void setCommitIp(String commitIp) {
        this.commitIp = commitIp;
    }
}