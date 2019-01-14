package ru.tfomsbrk.pvhd.mvc.bean;

public class UserAuthorized {
    private String userName;
    private String password;
    private String[] roles;
    private Integer idIsp;
    private Integer idMO;

    public UserAuthorized (String userName, String password, String... role)
    {
        this.userName = userName;
        this.password = password;
        this.roles = role;
    }
    public UserAuthorized()
    {

    }

    public String getPassword() {
        return password;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String[] getRoles() {
        return roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getIdMO() {
        return idMO;
    }

    public Integer getIdIsp() {
        return idIsp;
    }

    public void setIdMO(Integer idMO) {
        this.idMO = idMO;
    }

    public void setIdIsp(Integer idIsp) {
        this.idIsp = idIsp;
    }

    @Override
    public String toString() {
        return "User name:" + userName +"\n"
                + "Password: " + password +"\n"
                + "Role: " + roles +"\n";
    }

}
