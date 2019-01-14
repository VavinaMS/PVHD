package ru.tfomsbrk.pvhd.mvc.bean;

import java.math.BigDecimal;

public class Prih {
    private Integer id;
    private BigDecimal val;
    private Integer idStat;
    private Integer idMo;
    private Integer idReportAll;
    private boolean lock;

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdMo(Integer idMo) {
        this.idMo = idMo;
    }

    public Integer getIdMo() {
        return idMo;
    }

    public Integer getId() {
        return id;
    }

    public void setIdStat(Integer idStat) {
        this.idStat = idStat;
    }

    public Integer getIdStat() {
        return idStat;
    }

    public BigDecimal getVal() {
        return val;
    }

    public Integer getIdReportAll() {
        return idReportAll;
    }

    public void setIdReportAll(Integer idReportAll) {
        this.idReportAll = idReportAll;
    }

    public void setVal(BigDecimal val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Val: " + val + "\n" +
                "IDstat: " + idStat + "\n" +
                "IDmo: " + idMo + "\n" +
                "IDreportAll: " + idReportAll + "\n" +
                "lock: " + lock + "\n";
    }
}
