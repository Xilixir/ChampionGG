package com.xilixir.championggapi.api.Objects.Json;

// Written by Xilixir on 12/30/2015
public class OverallPosition {
    private int change;
    private int position;

    public OverallPosition(int change, int position) {
        this.change = change;
        this.position = position;
    }

    public int getChange() {
        return change;
    }

    public int getPosition() {
        return position;
    }
}
