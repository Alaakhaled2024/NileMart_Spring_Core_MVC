package com.example.NileMart.model;

import static com.example.NileMart.model.Zone.*;
import static com.example.NileMart.model.Zone.CANAL;
import static com.example.NileMart.model.Zone.REMOTE;
import static com.example.NileMart.model.Zone.UPPER_EGYPT;

public enum Governorate {
    CAIRO(GREATER_CAIRO),
    GIZA(GREATER_CAIRO),
    QALYUBIA(GREATER_CAIRO),

    ALEXANDRIA(ALEX_DELTA),
    BEHEIRA(ALEX_DELTA),
    KAFR_EL_SHEIKH(ALEX_DELTA),
    DAKAHLIA(ALEX_DELTA),
    DAMIETTA(ALEX_DELTA),
    GHARBIA(ALEX_DELTA),
    MONUFIA(ALEX_DELTA),
    SHARQIA(ALEX_DELTA),

    PORT_SAID(CANAL),
    ISMAILIA(CANAL),
    SUEZ(CANAL),

    FAIYUM(UPPER_EGYPT),
    BENI_SUEF(UPPER_EGYPT),
    MINYA(UPPER_EGYPT),
    ASYUT(UPPER_EGYPT),
    SOHAG(UPPER_EGYPT),
    QENA(UPPER_EGYPT),
    LUXOR(UPPER_EGYPT),
    ASWAN(UPPER_EGYPT),

    MATROUH(REMOTE),
    NORTH_SINAI(REMOTE),
    SOUTH_SINAI(REMOTE),
    RED_SEA(REMOTE),
    NEW_VALLEY(REMOTE);
    private final Zone zone;
    Governorate(Zone z){
        this.zone=z;
    }
    Zone getZone(){
        return zone;
    }
}
