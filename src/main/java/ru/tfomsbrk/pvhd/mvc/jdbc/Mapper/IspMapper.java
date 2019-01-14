package ru.tfomsbrk.pvhd.mvc.jdbc.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tfomsbrk.pvhd.mvc.bean.Isp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IspMapper implements RowMapper<Isp> {
    @Override
    public Isp mapRow(ResultSet resultSet, int i) throws SQLException {
        Isp isp = new Isp();
        isp.setId(resultSet.getInt("ID"));
        isp.setFio(resultSet.getString("FIO"));
        isp.setTel(resultSet.getString("Tel"));
        isp.setIdMo(resultSet.getInt("IDmo"));
        return isp;
    }
}
