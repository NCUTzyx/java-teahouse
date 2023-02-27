package com.zyx.susan.Domain;

/**
 * @author 张宇森
 * @version 1.0
 * 与Menu表 相对应的javabean
 * <p>
 * fid INT PRIMARY KEY AUTO_INCREMENT,
 * fname VARCHAR(20) NOT NULL DEFAULT '',
 * ftype VARCHAR(50) NOT NULL DEFAULT '',
 * price DOUBLE NOT NULL DEFAULT 0
 */
public class Menu {

    private Integer fid;
    private String fname;
    private String ftype;
    private Double price;

    public Menu() {
    }

    public Menu(Integer fid, String fname, String ftype, Double price) {
        this.fid = fid;
        this.fname = fname;
        this.ftype = ftype;
        this.price = price;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return fid + "\t\t\t" + fname + "\t\t" + ftype + "\t\t" + price;
    }
}
