package com.hzed.qmqb.admin.persistence.auto.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Dict implements Serializable {
    /**
     */
    private Long id;

    /**
     * 字典名称
     */
    private String dicName;

    /**
     * 字典代码
     */
    private String dicCode;

    /**
     * 值
     */
    private String dicValue;

    /**
     * 显示文本
     */
    private String dicLabel;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 模块代码
     */
    private String moduleCode;

    /**
     * 排序权重，从小到大
     */
    private Integer orderby;

    /**
     * 语言 zh-CH-中文 id-ID-印尼文
     */
    private String language;

    /**
     */
    private Long createBy;

    /**
     */
    private LocalDateTime createTime;

    /**
     */
    private Long updateBy;

    /**
     */
    private LocalDateTime updateTime;

    /**
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName == null ? null : dicName.trim();
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode == null ? null : dicCode.trim();
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue == null ? null : dicValue.trim();
    }

    public String getDicLabel() {
        return dicLabel;
    }

    public void setDicLabel(String dicLabel) {
        this.dicLabel = dicLabel == null ? null : dicLabel.trim();
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode == null ? null : moduleCode.trim();
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dicName=").append(dicName);
        sb.append(", dicCode=").append(dicCode);
        sb.append(", dicValue=").append(dicValue);
        sb.append(", dicLabel=").append(dicLabel);
        sb.append(", moduleName=").append(moduleName);
        sb.append(", moduleCode=").append(moduleCode);
        sb.append(", orderby=").append(orderby);
        sb.append(", language=").append(language);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static Dict.Builder builder() {
        return new Dict.Builder();
    }

    public static class Builder {
        private Dict obj;

        public Builder() {
            this.obj = new Dict();
        }

        public Builder id(Long id) {
            obj.setId(id);
            return this;
        }

        public Builder dicName(String dicName) {
            obj.setDicName(dicName);
            return this;
        }

        public Builder dicCode(String dicCode) {
            obj.setDicCode(dicCode);
            return this;
        }

        public Builder dicValue(String dicValue) {
            obj.setDicValue(dicValue);
            return this;
        }

        public Builder dicLabel(String dicLabel) {
            obj.setDicLabel(dicLabel);
            return this;
        }

        public Builder moduleName(String moduleName) {
            obj.setModuleName(moduleName);
            return this;
        }

        public Builder moduleCode(String moduleCode) {
            obj.setModuleCode(moduleCode);
            return this;
        }

        public Builder orderby(Integer orderby) {
            obj.setOrderby(orderby);
            return this;
        }

        public Builder language(String language) {
            obj.setLanguage(language);
            return this;
        }

        public Builder createBy(Long createBy) {
            obj.setCreateBy(createBy);
            return this;
        }

        public Builder createTime(LocalDateTime createTime) {
            obj.setCreateTime(createTime);
            return this;
        }

        public Builder updateBy(Long updateBy) {
            obj.setUpdateBy(updateBy);
            return this;
        }

        public Builder updateTime(LocalDateTime updateTime) {
            obj.setUpdateTime(updateTime);
            return this;
        }

        public Builder remark(String remark) {
            obj.setRemark(remark);
            return this;
        }

        public Dict build() {
            return this.obj;
        }
    }

    public enum Column {
        id("id"),
        dicName("dic_name"),
        dicCode("dic_code"),
        dicValue("dic_value"),
        dicLabel("dic_label"),
        moduleName("module_name"),
        moduleCode("module_code"),
        orderby("orderby"),
        language("language"),
        createBy("create_by"),
        createTime("create_time"),
        updateBy("update_by"),
        updateTime("update_time"),
        remark("remark");

        private final String column;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        Column(String column) {
            this.column = column;
        }

        public String desc() {
            return this.column + " DESC";
        }

        public String asc() {
            return this.column + " ASC";
        }
    }
}