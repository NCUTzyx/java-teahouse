package com.zyx.susan.Domain;

/**
 * @author 张宇森
 * @version 1.0
 * 与EatTable表 相对应的javabean
 * 	id INT PRIMARY KEY AUTO_INCREMENT,
 * 	state VARCHAR(20) NOT NULL DEFAULT '',
 * 	Eatname VARCHAR(50) NOT NULL DEFAULT '',
 * 	Eattel VARCHAR(20) NOT NULL DEFAULT ''
 */
public class EatTable {

    private Integer id;
    private String state;
    private String Eatname;
    private String Eattel;

    public EatTable() {
    }



    public EatTable(Integer id, String state, String Eatname, String Eattel) {
        this.id = id;
        this.state = state;
        this.Eatname = Eatname;
        this.Eattel = Eattel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEatname() {
        return Eatname;
    }

    public void setEatname(String Eatname) {
        this.Eatname = Eatname;
    }

    public String getEattel() {
        return Eattel;
    }

    public void setEattel(String Eattel) {
        this.Eattel = Eattel;
    }
}
