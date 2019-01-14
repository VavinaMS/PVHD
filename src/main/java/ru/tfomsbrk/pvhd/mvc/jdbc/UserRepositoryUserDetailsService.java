package ru.tfomsbrk.pvhd.mvc.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.tfomsbrk.pvhd.mvc.bean.CustomUser;
import ru.tfomsbrk.pvhd.mvc.bean.UserAuthorized;
import ru.tfomsbrk.pvhd.mvc.jdbc.Template.UsersJDBCTemplate;

@Service
@Configurable
public class UserRepositoryUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersJDBCTemplate usersJDBCTemplate;

    @Override
    public CustomUser loadUserByUsername(String s) throws UsernameNotFoundException {

        UserAuthorized userAuthorized = usersJDBCTemplate.getUserByUserName(s);
        if( userAuthorized!= null) {
            boolean enabled = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;
            return new CustomUser(
                    userAuthorized.getUserName(),
                    userAuthorized.getPassword(),
                    enabled,
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked,
                    AuthorityUtils.createAuthorityList("ROLE_USER"),
                    userAuthorized.getIdIsp(),
                    userAuthorized.getIdMO());
        }return null;
    }
}
