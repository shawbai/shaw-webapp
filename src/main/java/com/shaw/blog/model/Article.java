package com.shaw.blog.model;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -9210966007857143227L;

	private Long articleId;

    private Date createTime;

    private Date modifyTime;

    private Long version;

    private String articleName;

    private String articleIp;

    private Integer articleClick;

    private Long sortArticleId;

    private Long memberId;

    private Integer articleType;

    private String articleKeyword;

    private Byte articleUp;

    private Byte articleSupport;

    private String articleContent;

    private String pictures;
    
    public String getPictures() {
		return pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName == null ? null : articleName.trim();
    }

    public String getArticleIp() {
        return articleIp;
    }

    public void setArticleIp(String articleIp) {
        this.articleIp = articleIp == null ? null : articleIp.trim();
    }

    public Integer getArticleClick() {
        return articleClick;
    }

    public void setArticleClick(Integer articleClick) {
        this.articleClick = articleClick;
    }

    public Long getSortArticleId() {
        return sortArticleId;
    }

    public void setSortArticleId(Long sortArticleId) {
        this.sortArticleId = sortArticleId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    public String getArticleKeyword() {
        return articleKeyword;
    }

    public void setArticleKeyword(String articleKeyword) {
        this.articleKeyword = articleKeyword == null ? null : articleKeyword.trim();
    }

    public Byte getArticleUp() {
        return articleUp;
    }

    public void setArticleUp(Byte articleUp) {
        this.articleUp = articleUp;
    }

    public Byte getArticleSupport() {
        return articleSupport;
    }

    public void setArticleSupport(Byte articleSupport) {
        this.articleSupport = articleSupport;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", createTime=" + createTime + ", modifyTime=" + modifyTime
				+ ", version=" + version + ", articleName=" + articleName + ", articleIp=" + articleIp
				+ ", articleClick=" + articleClick + ", sortArticleId=" + sortArticleId + ", memberId=" + memberId
				+ ", articleType=" + articleType + ", articleKeyword=" + articleKeyword + ", articleUp=" + articleUp
				+ ", articleSupport=" + articleSupport + ", articleContent=" + articleContent + "]";
	}
    
    
}