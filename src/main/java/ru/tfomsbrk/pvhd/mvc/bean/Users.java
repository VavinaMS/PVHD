package ru.tfomsbrk.pvhd.mvc.bean;

public class Users {
    private String login;
    private String pass;
    private Integer idrole;
    private Integer idisp;
    private Integer id;
    private boolean enabled;

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getLogin()
    {
        return login;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public String getPass()
    {
        return pass;
    }

    public void setIdrole(Integer role)
    {
        this.idrole = role;
    }

    public Integer getIdrole() {
        return idrole;
    }

    public void setIdisp(Integer idisp) {
        this.idisp = idisp;
    }

    public Integer getIdisp() {
        return idisp;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString()
    {
        return "users: " + "\n" +
                "ID: " + id + "\n" +
                "Login: " + login +"\n" +
                "Password:" + pass + "\n"+
                "Role: " + idrole + "\n" +
                "IDisp:" + idisp +"\n" +
                "Enabled: " + enabled  +"\n";
    }
}
