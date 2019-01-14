package ru.tfomsbrk.pvhd.mvc.jdbc.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tfomsbrk.pvhd.mvc.bean.Lvl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LvlMapper implements RowMapper<Lvl> {
    @Override
    public Lvl mapRow(ResultSet resultSet, int i) throws SQLException {
        Lvl lvl = new Lvl();
        lvl.setId(resultSet.getInt("ID"));
        lvl.setName(resultSet.getString("Nm"));
        return lvl;
    }
}
