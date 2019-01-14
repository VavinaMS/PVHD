package ru.tfomsbrk.pvhd.mvc.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {
    private static final long serialVersionUID = -7104611048389377460L;
    private Integer idIsp;
    private Integer idMO;

    public void setIdIsp(Integer idIsp) {
        this.idIsp = idIsp;
    }

    public void setIdMO(Integer idMO) {
        this.idMO = idMO;
    }

    public Integer getIdIsp() {
        return idIsp;
    }

    public Integer getIdMO() {
        return idMO;
    }

    public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Integer idIsp, Integer idMo)
    {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        setIdIsp(idIsp);
        setIdMO(idMo);
    }
}
