package ru.tfomsbrk.pvhd.mvc.bean;

public class Isp {
    private Integer id;
    private String fio;
    private String tel;
    private Integer idMo;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdMo() {
        return idMo;
    }

    public void setIdMo(Integer idMo) {
        this.idMo = idMo;
    }

    public String getFio() {
        return fio;
    }

    public String getTel() {
        return tel;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
