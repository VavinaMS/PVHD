package ru.tfomsbrk.pvhd.mvc.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class Ej {
    private Integer id;
    private Integer idStat;
    private BigDecimal ktStart;
    private BigDecimal prosrochStart;
    private BigDecimal vistavleno;
    private BigDecimal oplacheno;
    private BigDecimal ktEnd;
    private BigDecimal prosrochEnd;
    private Integer idreportAll;
    private boolean lock;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getKtEnd() {
        return ktEnd;
    }

    public BigDecimal getKtStart() {
        return ktStart;
    }

    public BigDecimal getOplacheno() {
        return oplacheno;
    }

    public BigDecimal getProsrochEnd() {
        return prosrochEnd;
    }

    public BigDecimal getProsrochStart() {
        return prosrochStart;
    }

    public BigDecimal getVistavleno() {
        return vistavleno;
    }

    public Integer getIdStat() {
        return idStat;
    }

    public void setIdStat(Integer idStat) {
        this.idStat = idStat;
    }

    public void setKtEnd(BigDecimal ktEnd) {
        this.ktEnd = ktEnd;
    }

    public void setKtStart(BigDecimal ktStart) {
        this.ktStart = ktStart;
    }

    public void setOplacheno(BigDecimal oplacheno) {
        this.oplacheno = oplacheno;
    }

    public void setProsrochEnd(BigDecimal prosrochEnd) {
        this.prosrochEnd = prosrochEnd;
    }

    public void setProsrochStart(BigDecimal prosrochStart) {
        this.prosrochStart = prosrochStart;
    }

    public void setVistavleno(BigDecimal vistavleno) {
        this.vistavleno = vistavleno;
    }

    public Integer getIDreportAll() {
        return idreportAll;
    }

    public void setIDreportAll(Integer idreportAll) {
        this.idreportAll = idreportAll;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    @Override
    public String toString() {
        return "Ej" +"\n"+
                "ID: " + id + "\n" +
                "IDstat: " + idStat + "\n" +
                "KtStart: " + ktStart + "\n" +
                "ProsrochStart: " + prosrochStart + "\n" +
                "Vistavleno: " + vistavleno + "\n" +
                "Oplacheno: " + oplacheno + "\n" +
                "KtEnd: " + ktEnd + "\n" +
                "ProsrochEnd: " + prosrochEnd + "\n"+
                "IDallReport" + idreportAll + "\n";
    }
}
