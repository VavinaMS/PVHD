package ru.tfomsbrk.pvhd.mvc.jdbc.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tfomsbrk.pvhd.mvc.bean.MO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MoMapper implements RowMapper<MO> {
    @Override
    public MO mapRow(ResultSet resultSet, int i) throws SQLException {
        MO mo = new MO();
        mo.setId(resultSet.getInt("ID"));
        mo.setName(resultSet.getString("Nm"));
        mo.setAddress(resultSet.getString("Address"));
        mo.setFioDir(resultSet.getString("FIOdir"));
        mo.setFioBuh(resultSet.getString("FIObuh"));
        mo.setShortName(resultSet.getString("cNm"));
        mo.setKodMO(resultSet.getInt("MOkod"));
        mo.setLevel(resultSet.getInt("IDlvl"));
        return mo;
    }
}
