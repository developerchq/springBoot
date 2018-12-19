package com.mvc.model;

/**
 * Created by AB052409 on 2016/12/6.
 */
public class FirstModel {
    private String id;

    private String userName;

    private Integer age;

    public FirstModel() {
        this.id="ab0000001";
        this.userName="an sir";
        this.age=12;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
