package com.collection.eo;

import org.springframework.stereotype.Component;

@Component
public class ClassParent extends BaseEo{

    private String classParentName;

    private Byte state;

    public String getClassParentName() {
        return classParentName;
    }

    public void setClassParentName(String classParentName) {
        this.classParentName = classParentName;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ClassParent{" +
                "classParentName='" + classParentName + '\'' +
                ", state=" + state +
                '}';
    }
}
