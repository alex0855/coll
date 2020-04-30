package com.collection.eo;

public class Classify extends BaseEo {

    private String className;

    private Integer parentId;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Classify{" +
                "className='" + className + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
