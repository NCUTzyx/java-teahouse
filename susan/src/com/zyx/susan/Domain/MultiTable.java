package com.zyx.susan.Domain;

import java.util.Date;

/**
 * @author 张宇森
 * @version 1.0
 * javabean 可以和多张表进行对应
 */
public class MultiTable{

    private Integer id;
    private String bid;
    private Integer meid;
    private Double price;
    private Integer nums;
    private Integer eatTableId;
    private Date biDate;
    private String state;
    //menu 的列
    private String fname;



    public MultiTable() {
    }

    public MultiTable(Integer id, String bid, Integer meid, Double price, Integer nums, Integer eatTableId, Date biDate, String state, String fname) {
        this.id = id;
        this.bid = bid;
        this.meid = meid;
        this.price = price;
        this.nums = nums;
        this.eatTableId = eatTableId;
        this.biDate = biDate;
        this.state = state;
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
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
                        "\t\t\t" + state +
                        "\t\t"+fname;
    }
}
