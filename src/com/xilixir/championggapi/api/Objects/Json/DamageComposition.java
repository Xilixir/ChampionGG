package com.xilixir.championggapi.api.Objects.Json;

// Written by Xilixir on 12/30/2015
public class DamageComposition {
    private double trueDmg;
    private double magicDmg;
    private double physicalDmg;

    public DamageComposition(double magicDmg, double trueDmg, double physicalDmg) {
        this.magicDmg = magicDmg;
        this.trueDmg = trueDmg;
        this.physicalDmg = physicalDmg;
    }

    public double getTrueDmg() {
        return trueDmg;
    }

    public double getMagicDmg() {
        return magicDmg;
    }

    public double getPhysicalDmg() {
        return physicalDmg;
    }
}
