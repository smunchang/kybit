package com.kaybo.kbit.model;

public enum Type {
    X000("Send KBIT"),
    X001("Receive KBIT"),

    P000("KCOIN Reward"),
    R000("Ranking Point"),

    D001("APP1 download"),
    D002("APP3 download"),
    D003("APP3 download"),

    G001("PB Reward"),
    G002("SF1 Reward"),
    G003("SF2 Reward");

    private String name;

    Type(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
