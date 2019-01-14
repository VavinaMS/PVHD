package ru.tfomsbrk.pvhd.mvc.bean;

public class MO {
    private Integer id;
    private String name;
    private String address;
    private String fioDir;
    private String fioBuh;
    private String shortName;
    private Integer kodMO;
    private Integer level;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getKodMO() {
        return kodMO;
    }

    public Integer getLevel() {
        return level;
    }

    public String getAddress() {
        return address;
    }

    public String getFioBuh() {
        return fioBuh;
    }

    public String getFioDir() {
        return fioDir;
    }

    public String getShortName() {
        return shortName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFioBuh(String fioBuh) {
        this.fioBuh = fioBuh;
    }

    public void setFioDir(String fioDir) {
        this.fioDir = fioDir;
    }

    public void setKodMO(Integer kodMO) {
        this.kodMO = kodMO;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "MO: " + "\n" +
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Address: " + address + "\n" +
                "FIOdir: " + fioDir + "\n" +
                "FIObuh: " + fioBuh + "\n" +
                "ShortName: " + shortName + "\n" +
                "MOkod: " + kodMO + "\n" +
                "IDlvl + " + level + "\n";
    }
}
