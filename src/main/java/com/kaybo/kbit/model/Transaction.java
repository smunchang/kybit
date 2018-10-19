package com.kaybo.kbit.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opencsv.bean.CsvBindByName;

import java.util.Date;

public class Transaction {
    @CsvBindByName(column = "userNo")
    private long userNo;

    @CsvBindByName(column = "userId")
    @JsonIgnore
    private String userId;

    @CsvBindByName(column = "kbit")
    private int kbit;

    @CsvBindByName(column = "type")
    private String type;

    private String description;
    private long refUserNo;

    @JsonIgnore
    private Date regDt;
    private long timestamp;

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

    public long getRefUserNo() {
        return refUserNo;
    }

    public void setRefUserNo(long refUserNo) {
        this.refUserNo = refUserNo;
    }

    public Date getRegDt() {
        return regDt;
    }

    public void setRegDt(Date regDt) {
        this.regDt = regDt;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
