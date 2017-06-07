package com.shaw.blog.model;

import com.shaw.blog.core.BaseEntity;
import javax.persistence.*;

@Table(name = "article_sort")
public class ArticleSort extends BaseEntity {
    /**
     * 文章类别自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分类名称
     */
    @Column(name = "sort_article_name")
    private String sortArticleName;

    /**
     * 获取文章类别自增ID
     *
     * @return id - 文章类别自增ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置文章类别自增ID
     *
     * @param id 文章类别自增ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取分类名称
     *
     * @return sort_article_name - 分类名称
     */
    public String getSortArticleName() {
        return sortArticleName;
    }

    /**
     * 设置分类名称
     *
     * @param sortArticleName 分类名称
     */
    public void setSortArticleName(String sortArticleName) {
        this.sortArticleName = sortArticleName;
    }
}