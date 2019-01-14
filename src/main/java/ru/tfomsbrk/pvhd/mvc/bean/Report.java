package ru.tfomsbrk.pvhd.mvc.bean;

public class Report {
    private Integer id;
    private String name;
    private String table;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "Report: "+ "\n" +
                "ID: " + id + "\n" +
                "Name: " + name +"\n"+
                "Table: " + table +"\n";
    }
}
