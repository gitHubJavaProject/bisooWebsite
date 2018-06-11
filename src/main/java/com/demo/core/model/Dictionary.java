package com.demo.core.model;

import com.demo.core.model.base.BaseEntity;

import javax.persistence.Table;

@Table(name = "bs_data_dictionary")
public class Dictionary extends BaseEntity {

    private static final long serialVersionUID = -8747955494705648558L;
    /**
     * 属性名
     */
    private String name;
    /**
     * 父节点
     */
    private String parentId;
    /**
     * 属性码
     */
    private Integer code;
    /**
     * 类型
     */
    private String type;
    /**
     * 排序
     */
    private Integer sortSign;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 添加人
     */
    private String createAid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSortSign() {
        return sortSign;
    }

    public void setSortSign(Integer sortSign) {
        this.sortSign = sortSign;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateAid() {
        return createAid;
    }

    public void setCreateAid(String createAid) {
        this.createAid = createAid;
    }
}
