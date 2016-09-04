package com.xilixir.championggapi.api.Objects;

// Written by Xilixir on 12/30/2015
import com.xilixir.championggapi.api.Objects.Json.ChampionRole;

import java.util.List;

public class ChampionData {
    private String key;
    private long lastUpdated;
    private String name;
    private List<ChampionRole> roles;

    public ChampionData(String key, long lastUpdated, String name, List<ChampionRole> roles) {
        this.key = key;
        this.lastUpdated = lastUpdated;
        this.name = name;
        this.roles = roles;
    }

    public String getKey() {
        return key;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public String getName() {
        return name;
    }

    public List<ChampionRole> getRoles() {
        return roles;
    }
}
