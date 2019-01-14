package ru.tfomsbrk.pvhd.mvc.bean;

public class Stat {
    private Integer id;
    private String name;
    private Integer summto;
    private boolean lock;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getSummto() {
        return summto;
    }

    public void setSummto(Integer summto) {
        this.summto = summto;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public boolean isLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Stat: " + "\n" +
                "ID: " +id + "\n" +
                "Name: " + name + "\n"+
                "SummTo: " + summto + "\n";
    }
}
