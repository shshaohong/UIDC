package com.edu.feicui.uidc.entity;


import java.io.Serializable;
public class Dish implements Serializable {

    private String dishId;
    private String dishName;
    private String price;
    private String introduction;
    private String dishClass;
    private String imgPath;
    private boolean isChoose;
    private String remark;
    private String totalPrice;

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getDishClass() {
        return dishClass;
    }

    public void setDishClass(String dishClass) {
        this.dishClass = dishClass;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public boolean isChoose() {
        return isChoose;
    }

    public void setChoose(boolean choose) {
        isChoose = choose;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Dish(boolean isChoose, String dishId, String dishName, String price, String introduction, String dishClass, String imgPath) {
        this.isChoose = isChoose;
        this.dishId = dishId;
        this.dishName = dishName;
        this.price = price;
        this.introduction = introduction;
        this.dishClass = dishClass;
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishId='" + dishId + '\'' +
                ", dishName='" + dishName + '\'' +
                ", price='" + price + '\'' +
                ", introduction='" + introduction + '\'' +
                ", dishClass='" + dishClass + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", isChoose=" + isChoose +
                '}';
    }

    public Dish() {
    }
}
