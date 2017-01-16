package com.edu.feicui.uidc.entity;

/**
 * Created by Administrator on 2017-1-13.
 */

public class MessageEvent {

    public static final int TYPE_A = 1;
    public static final int TYPE_B = 2;

    private int type;
    private String num;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
