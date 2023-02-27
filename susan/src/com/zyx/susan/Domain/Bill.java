package com.zyx.susan.Domain;

import java.util.Date;

/**
 * @author 张宇森
 * @version 1.0
 * 与Bill表 相对应的javabean
 *
 *	id INT PRIMARY KEY AUTO_INCREMENT,
 * 	bid VARCHAR(50) NOT NULL DEFAULT '',
 * 	meid INT NOT NULL DEFAULT 0,
 * 	num INT NOT NULL DEFAULT 0,
 * 	price DOUBLE NOT NULL DEFAULT 0,
 * 	eatTableId INT NOT NULL DEFAULT 0,
 * 	biDate DATETIME NOT NULL,
 * 	state VARCHAR(50) NOT NULL DEFAULT ''
 *
 */
public class Bill {

    private Integer id;
    private String bid;
    private Integer meid;
    private Double price;
    private Integer nums;
    private Integer eatTableId;
    private Date biDate;
    private String state;

    public Bill() {
    }

    public Bill(Integer id, String bid, Integer meid, Double price, Integer nums, Integer eatTableId, Date biDate, String state) {
        this.id = id;
        this.bid = bid;
        this.meid = meid;
        this.price = price;
        this.nums = nums;
        this.eatTableId = eatTableId;
        this.biDate = biDate;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public Integer getMeid() {
        return meid;
    }

    public void setMeid(Integer meid) {
        this.meid = meid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Integer getEatTableId() {
        return eatTableId;
    }

    public void setEatTableId(Integer eatTableId) {
        this.eatTableId = eatTableId;
    }

    public Date getBiDate() {
        return biDate;
    }

    public void setBiDate(Date biDate) {
        this.biDate = biDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return
                id +
                "\t\t\t" + meid +
                "\t\t\t" + price +
                "\t\t\t" + nums +
                "\t\t" + eatTableId +
                "\t\t" + biDate +
                "\t\t\t" + state ;
    }
}
