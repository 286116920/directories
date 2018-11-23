package com.example.directories.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("用户描述")
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value="用户ID")
    private int id;
    @ApiModelProperty(value="姓名",required = true)
    private String userName;
    @ApiModelProperty(value="性别")
    private String sex;
    @ApiModelProperty(value="年龄")
    private int age;
    @ApiModelProperty(value="手机号")
    private String phone;
    @ApiModelProperty(value="地址")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
