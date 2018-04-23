package com.example.user.liveatpranking;

import android.graphics.drawable.Drawable;

/**
 * Created by User on 4/23/2018.
 */

public class Igrac {
    private String pozicija;
    private String CH;
    private String punoIme;
    private String godine;
    private Drawable drzava;
    private String drzavaStr;
    private String bodovi;
    private String plus;
    private String minus;
    private String trenutniTurnir;
    private String nextPts;
    private String maxPts;

    public Igrac(String pozicija, String CH, String punoIme, String godine, Drawable drzava, String drzavaStr, String bodovi, String plus, String minus, String trenutniTurnir, String nextPts, String maxPts) {
        this.pozicija = pozicija;
        this.CH = CH;
        this.punoIme = punoIme;
        this.godine = godine;
        this.drzava = drzava;
        this.bodovi = bodovi;
        this.plus = plus;
        this.minus = minus;
        this.trenutniTurnir = trenutniTurnir;
        this.nextPts = nextPts;
        this.maxPts = maxPts;
        this.drzavaStr = drzavaStr;
    }

    public String getPozicija() {
        return pozicija;
    }

    public String getDrzavaStr() {
        return drzavaStr;
    }

    public String getCH() {
        return CH;
    }

    public String getPunoIme() {
        return punoIme;
    }

    public String getGodine() {
        return godine;
    }

    public Drawable getDrzava() {
        return drzava;
    }

    public String getBodovi() {
        return bodovi;
    }

    public String getPlus() {
        return plus;
    }

    public String getMinus() {
        return minus;
    }

    public String getTrenutniTurnir() {
        return trenutniTurnir;
    }

    public String getNextPts() {
        return nextPts;
    }

    public String getMaxPts() {
        return maxPts;
    }
}
