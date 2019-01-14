package ru.tfomsbrk.pvhd.mvc.jdbc.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tfomsbrk.pvhd.mvc.bean.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<Users> {
    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException{
        Users users = new Users();
        users.setId(rs.getInt("id"));
        users.setIdisp(rs.getInt("IDisp"));
        users.setLogin(rs.getString("Lgn"));
        users.setPass(rs.getString("Pwd"));
        users.setIdrole(rs.getInt("IDRole"));
        users.setEnabled(rs.getBoolean("Enabled"));
        return users;
    }

}
