package com.kaybo.kybit.model;

public enum Type {
    X000("Send Kybit"),
    X001("Receive Kybot"),
    P000("KCOIN Purchase Reward"),
    R001("PB Reward"),
    R002("SF1 Reward"),
    R003("SF2 Reward");

    private String name;

    Type(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
