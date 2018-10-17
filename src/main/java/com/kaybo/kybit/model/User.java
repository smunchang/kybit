package com.kaybo.kybit.model;

public class User {
    private String userNo;
    private String userId;
    private int kybit;

    public User(String userNo, String userId) {
        this.userNo = userNo;
        this.userId = userId;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getKybit() {
        return kybit;
    }

    public void setKybit(int kybit) {
        this.kybit = kybit;
    }
}
