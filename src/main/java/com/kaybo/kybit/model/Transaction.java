package com.kaybo.kybit.model;

public class Transaction {
    private String userNo;
    private int kybit;
    private String type;
    private String description;
    private String ref_user_no;
    private String ref_user_id;
    private long reg_dt;


    public Transaction(String userNo, String type, int kybit, String ref_user_no) {
        this.userNo = userNo;
        this.kybit = kybit;
        this.type = type;
        this.ref_user_no = ref_user_no;
    }
    public Transaction(String userNo, String type, int kybit) {
        this.userNo = userNo;
        this.kybit = kybit;
        this.type = type;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public int getKybit() {
        return kybit;
    }

    public void setKybit(int kybit) {
        this.kybit = kybit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRef_user_no() {
        return ref_user_no;
    }

    public void setRef_user_no(String ref_user_no) {
        this.ref_user_no = ref_user_no;
    }

    public String getRef_user_id() {
        return ref_user_id;
    }

    public void setRef_user_id(String ref_user_id) {
        this.ref_user_id = ref_user_id;
    }

    public long getReg_dt() {
        return reg_dt;
    }

    public void setReg_dt(long reg_dt) {
        this.reg_dt = reg_dt;
    }
}
