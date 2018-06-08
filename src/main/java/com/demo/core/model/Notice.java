package com.demo.core.model;

import com.demo.core.model.base.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;
import java.util.Date;

@Table(name = "bs_notice")
public class Notice extends BaseEntity {

    private static final long serialVersionUID = -2864324484095709298L;

    /**
     *  类型
     */
    private Integer typeId;
    /**
     *标题
     */
    private String title;
    /**
     *关键字
     */
    private String keywords;
    /**
     *摘要
     */
    private String summary;
    /**
     *内容
     */
    private String content;
    /**
     *时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date actionTime;
    /**
     *封图
     */
    private String coverImage;
    /**
     *链接
     */
    private String linkPath;
    /**
     *置顶
     */
    private boolean stick;
    /**
     *发布
     */
    private boolean released;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getLinkPath() {
        return linkPath;
    }

    public void setLinkPath(String linkPath) {
        this.linkPath = linkPath;
    }

    public boolean isStick() {
        return stick;
    }

    public void setStick(boolean stick) {
        this.stick = stick;
    }

    public boolean isReleased() {
        return released;
    }

    public void setReleased(boolean released) {
        this.released = released;
    }
}
