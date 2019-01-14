package ru.tfomsbrk.pvhd.mvc.bean;

public class Lvl {
    private Integer id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Lvl: " + "\n" +
                "ID: " +id + "\n" +
                "Name: " + name +"\n";
    }
}
