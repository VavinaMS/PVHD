package ru.tfomsbrk.pvhd.mvc.jdbc.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tfomsbrk.pvhd.mvc.bean.Prih;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrihMapper implements RowMapper<Prih> {
    @Override
    public Prih mapRow(ResultSet resultSet, int i) throws SQLException {
        Prih prih = new Prih();
        prih.setId(resultSet.getInt("ID"));
        prih.setVal(resultSet.getBigDecimal("Val"));
        prih.setIdStat(resultSet.getInt("IDstat"));
        prih.setIdMo(resultSet.getInt("IDmo"));
        prih.setIdReportAll(resultSet.getInt("IDreportAll"));
        prih.setLock(resultSet.getBoolean("Lock"));
        return prih;
    }
}
