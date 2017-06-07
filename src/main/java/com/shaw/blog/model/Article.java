package com.shaw.blog.model;

import com.shaw.blog.core.BaseEntity;
import java.util.Date;
import javax.persistence.*;

public class Article extends BaseEntity {
    /**
     * 文章自增ID号
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
     * 文章名称
     */
    @Column(name = "article_name")
    private String articleName;

    /**
     * 发布IP
     */
    @Column(name = "article_ip")
    private String articleIp;

    /**
     * 查看人数
     */
    @Column(name = "article_click")
    private Integer articleClick;

    /**
     * 所属分类
     */
    @Column(name = "sort_article_id")
    private Long sortArticleId;

    /**
     * 所属用户ID
     */
    @Column(name = "member_id")
    private Long memberId;

    /**
     * 文章的模式:0为私有，1为公开，2为仅好友查看
     */
    @Column(name = "article_type")
    private Integer articleType;

    /**
     * 文章关键字
     */
    @Column(name = "article_keyword")
    private String articleKeyword;

    /**
     * 是否置顶:0为否，1为是
     */
    @Column(name = "article_up")
    private Byte articleUp;

    /**
     * 是否博主推荐:0为否，1为是
     */
    @Column(name = "article_support")
    private Byte articleSupport;

    private String pictures;

    /**
     * 文章内容
     */
    @Column(name = "article_content")
    private String articleContent;

    /**
     * 获取文章自增ID号
     *
     * @return id - 文章自增ID号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置文章自增ID号
     *
     * @param id 文章自增ID号
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
     * 获取文章名称
     *
     * @return article_name - 文章名称
     */
    public String getArticleName() {
        return articleName;
    }

    /**
     * 设置文章名称
     *
     * @param articleName 文章名称
     */
    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    /**
     * 获取发布IP
     *
     * @return article_ip - 发布IP
     */
    public String getArticleIp() {
        return articleIp;
    }

    /**
     * 设置发布IP
     *
     * @param articleIp 发布IP
     */
    public void setArticleIp(String articleIp) {
        this.articleIp = articleIp;
    }

    /**
     * 获取查看人数
     *
     * @return article_click - 查看人数
     */
    public Integer getArticleClick() {
        return articleClick;
    }

    /**
     * 设置查看人数
     *
     * @param articleClick 查看人数
     */
    public void setArticleClick(Integer articleClick) {
        this.articleClick = articleClick;
    }

    /**
     * 获取所属分类
     *
     * @return sort_article_id - 所属分类
     */
    public Long getSortArticleId() {
        return sortArticleId;
    }

    /**
     * 设置所属分类
     *
     * @param sortArticleId 所属分类
     */
    public void setSortArticleId(Long sortArticleId) {
        this.sortArticleId = sortArticleId;
    }

    /**
     * 获取所属用户ID
     *
     * @return member_id - 所属用户ID
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * 设置所属用户ID
     *
     * @param memberId 所属用户ID
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取文章的模式:0为私有，1为公开，2为仅好友查看
     *
     * @return article_type - 文章的模式:0为私有，1为公开，2为仅好友查看
     */
    public Integer getArticleType() {
        return articleType;
    }

    /**
     * 设置文章的模式:0为私有，1为公开，2为仅好友查看
     *
     * @param articleType 文章的模式:0为私有，1为公开，2为仅好友查看
     */
    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    /**
     * 获取文章关键字
     *
     * @return article_keyword - 文章关键字
     */
    public String getArticleKeyword() {
        return articleKeyword;
    }

    /**
     * 设置文章关键字
     *
     * @param articleKeyword 文章关键字
     */
    public void setArticleKeyword(String articleKeyword) {
        this.articleKeyword = articleKeyword;
    }

    /**
     * 获取是否置顶:0为否，1为是
     *
     * @return article_up - 是否置顶:0为否，1为是
     */
    public Byte getArticleUp() {
        return articleUp;
    }

    /**
     * 设置是否置顶:0为否，1为是
     *
     * @param articleUp 是否置顶:0为否，1为是
     */
    public void setArticleUp(Byte articleUp) {
        this.articleUp = articleUp;
    }

    /**
     * 获取是否博主推荐:0为否，1为是
     *
     * @return article_support - 是否博主推荐:0为否，1为是
     */
    public Byte getArticleSupport() {
        return articleSupport;
    }

    /**
     * 设置是否博主推荐:0为否，1为是
     *
     * @param articleSupport 是否博主推荐:0为否，1为是
     */
    public void setArticleSupport(Byte articleSupport) {
        this.articleSupport = articleSupport;
    }

    /**
     * @return pictures
     */
    public String getPictures() {
        return pictures;
    }

    /**
     * @param pictures
     */
    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    /**
     * 获取文章内容
     *
     * @return article_content - 文章内容
     */
    public String getArticleContent() {
        return articleContent;
    }

    /**
     * 设置文章内容
     *
     * @param articleContent 文章内容
     */
    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }
}