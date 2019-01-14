package ru.tfomsbrk.pvhd.mvc.bean;

public class StatToReport {
    private Integer idreport;
    private Integer idstat;

    public Integer getIdreport() {
        return idreport;
    }

    public void setIdreport(Integer idreport) {
        this.idreport = idreport;
    }

    public Integer getIdstat() {
        return idstat;
    }

    public void setIdstat(Integer idstat) {
        this.idstat = idstat;
    }

    @Override
    public String toString() {
        return "StatToReport: " + "\n"+
                "IDreport: "+ idreport +"\n"+
                "IDstat: "+ idstat +"\n";
    }
}
