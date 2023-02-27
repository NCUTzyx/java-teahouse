package com.zyx.susan.Domain;

/**
 * @author 张宇森
 * @version 1.0
 * 与employee表 相对应的javabean
 *
 *	id INT PRIMARY KEY AUTO_INCREMENT,
 * 	uid VARCHAR(50) NOT NULL DEFAULT '',
 * 	pwd CHAR(32) NOT NULL DEFAULT '',
 * 	NAME VARCHAR(50) NOT NULL DEFAULT '',
 * 	job VARCHAR(50) NOT NULL DEFAULT ''
 *
 */
public class Employee {

    private Integer id;
    private String uid;
    private String pwd;
    private String NAME;
    private String job;

    public Employee() {  //无参构造器，反射需要
    }

    public Employee(Integer id, String uid, String pwd, String NAME, String job) {
        this.id = id;
        this.uid = uid;
        this.pwd = pwd;
        this.NAME = NAME;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
