package ru.tfomsbrk.pvhd.mvc.bean;

import java.math.BigDecimal;

public class Nach {
    private Integer id;
    private BigDecimal app;
    private BigDecimal stomat;
    private BigDecimal stat;
    private BigDecimal vmp;
    private BigDecimal reab;
    private BigDecimal dnStac;
    private BigDecimal vmpDnStac;
    private BigDecimal reabDnStac;
    private BigDecimal smp;
    private Integer idStat;
    private Integer idAllReport;
    private boolean lock;

    public Integer getIdStat() {
        return idStat;
    }

    public void setReab(BigDecimal reab) {
        this.reab = reab;
    }

    public void setIdStat(Integer idStat) {
        this.idStat = idStat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getApp() {
        return app;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public boolean isLock() {
        return lock;
    }

    public BigDecimal getDnStac() {
        return dnStac;
    }

    public BigDecimal getReab() {
        return reab;
    }

    public BigDecimal getReabDnStac() {
        return reabDnStac;
    }

    public BigDecimal getSmp() {
        return smp;
    }

    public BigDecimal getStat() {
        return stat;
    }

    public BigDecimal getStomat() {
        return stomat;
    }

    public BigDecimal getVmp() {
        return vmp;
    }

    public BigDecimal getVmpDnStac() {
        return vmpDnStac;
    }

    public Integer getIdAllReport() {
        return idAllReport;
    }

    public void setApp(BigDecimal app) {
        this.app = app;
    }

    public void setDnStac(BigDecimal dnStac) {
        this.dnStac = dnStac;
    }

    public void setIdAllReport(Integer idAllReport) {
        this.idAllReport = idAllReport;
    }

    public void setReabDnStac(BigDecimal reabDnStac) {
        this.reabDnStac = reabDnStac;
    }

    public void setSmp(BigDecimal smp) {
        this.smp = smp;
    }

    public void setStat(BigDecimal stat) {
        this.stat = stat;
    }

    public void setStomat(BigDecimal stomat) {
        this.stomat = stomat;
    }

    public void setVmp(BigDecimal vmp) {
        this.vmp = vmp;
    }

    public void setVmpDnStac(BigDecimal vmpDnStac) {
        this.vmpDnStac = vmpDnStac;
    }
}
