package com.xilixir.championggapi.api.Objects.Json;

// Written by Xilixir on 12/30/2015
public class Trinket {
    public class Item {
        private int id;
        private String name;

        public Item(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    private long games;
    private double winPercent;
    private Item item;

    public Trinket(long games, double winPercent, Item item) {
        this.games = games;
        this.winPercent = winPercent;
        this.item = item;
    }

    public long getGames() {
        return games;
    }

    public double getWinPercent() {
        return winPercent;
    }

    public Item getItem() {
        return item;
    }
}
