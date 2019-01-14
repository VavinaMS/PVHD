package ru.tfomsbrk.pvhd.mvc.jdbc.Mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import ru.tfomsbrk.pvhd.mvc.bean.UserAuthorized;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserAuthorizedMapper implements RowMapper<UserAuthorized> {

    @Override
    public UserAuthorized mapRow(ResultSet resultSet, int i) throws SQLException {
        UserAuthorized userAuthorized = new UserAuthorized();
        userAuthorized.setUserName(resultSet.getString("Lgn"));
        userAuthorized.setPassword(resultSet.getString("Pwd"));
        userAuthorized.setRoles(new String[]{resultSet.getString("RoleName")});
        userAuthorized.setIdIsp(resultSet.getInt("IDisp"));
        userAuthorized.setIdMO(resultSet.getInt("IDmo"));
        return userAuthorized;
    }
}
