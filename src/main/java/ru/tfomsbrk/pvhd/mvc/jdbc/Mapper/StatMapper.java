package ru.tfomsbrk.pvhd.mvc.jdbc.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tfomsbrk.pvhd.mvc.bean.Stat;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatMapper implements RowMapper<Stat> {
    @Override
    public Stat mapRow(ResultSet resultSet, int i) throws SQLException {
        Stat stat = new Stat();
        stat.setId(resultSet.getInt("ID"));
        stat.setName(resultSet.getString("Nm"));
        stat.setSummto(resultSet.getInt("SummTo"));
        stat.setLock(resultSet.getBoolean("lock"));
        return stat;
    }
}
