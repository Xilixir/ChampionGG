package com.xilixir.championggapi.api.Objects.Json;

// Written by Xilixir on  12/30/2015
public class ChampionRole {
    private String name;
    private double percentPlayed;
    private long games;

    public ChampionRole(String name, double percentPlayed, long games) {
        this.name = name;
        this.percentPlayed = percentPlayed;
        this.games = games;
    }

    public String getName() {
        return name;
    }

    public double getPercentPlayed() {
        return percentPlayed;
    }

    public long getGames() {
        return games;
    }
}
