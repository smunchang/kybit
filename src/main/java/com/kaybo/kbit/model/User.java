package com.kaybo.kbit.model;

public class User {
    private long userNo;
    private String userId;
    private int kbit;

    public long getUserNo() {
        return userNo;
    }

    public void setUserNo(long userNo) {
        this.userNo = userNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getKbit() {
        return kbit;
    }

    public void setKbit(int kbit) {
        this.kbit = kbit;
    }
}
