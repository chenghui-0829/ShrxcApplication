package com.ch.print;

import java.io.Serializable;

/**
 * Created by CH on 2018/7/23.
 */

public class FoodChoose implements Serializable {

    int id;
    String tablename;
    String foodname;
    int foodnum;//数量
    int foodunitprice;//单价

    public FoodChoose() {
        super();
    }


    public FoodChoose(String tablename, String foodname, int foodnum,
                      int foodunitprice) {
        super();
        this.tablename = tablename;
        this.foodname = foodname;
        this.foodnum = foodnum;
        this.foodunitprice = foodunitprice;
    }


    public FoodChoose(int id, String tablename, String foodname, int foodnum,
                      int foodunitprice) {
        super();
        this.id = id;
        this.tablename = tablename;
        this.foodname = foodname;
        this.foodnum = foodnum;
        this.foodunitprice = foodunitprice;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getFoodnum() {
        return foodnum;
    }

    public void setFoodnum(int foodnum) {
        this.foodnum = foodnum;
    }

    public int getFoodunitprice() {
        return foodunitprice;
    }

    public void setFoodunitprice(int foodunitprice) {
        this.foodunitprice = foodunitprice;
    }

    @Override
    public String toString() {
        return "FoodChoose [id=" + id + ", tablename=" + tablename
                + ", foodname=" + foodname + ", foodnum=" + foodnum
                + ", foodunitprice=" + foodunitprice + "]";
    }
}