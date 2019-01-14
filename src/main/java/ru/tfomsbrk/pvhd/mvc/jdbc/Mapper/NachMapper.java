package ru.tfomsbrk.pvhd.mvc.jdbc.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tfomsbrk.pvhd.mvc.bean.Nach;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NachMapper implements RowMapper<Nach> {
    @Override
    public Nach mapRow(ResultSet resultSet, int i) throws SQLException {
        Nach nach = new Nach();
        nach.setId(resultSet.getInt("ID"));
        nach.setApp(resultSet.getBigDecimal("APP"));
        nach.setStomat(resultSet.getBigDecimal("Stomat"));
        nach.setStat(resultSet.getBigDecimal("Stac"));
        nach.setVmp(resultSet.getBigDecimal("VMP"));
        nach.setReab(resultSet.getBigDecimal("Reab"));
        nach.setDnStac(resultSet.getBigDecimal("DnStac"));
        nach.setVmpDnStac(resultSet.getBigDecimal("VMPdnStac"));
        nach.setReabDnStac(resultSet.getBigDecimal("ReabDnStac"));
        nach.setSmp(resultSet.getBigDecimal("SMP"));
        nach.setIdStat(resultSet.getInt("IDstat"));
        nach.setIdAllReport(resultSet.getInt("IDallReport"));
        nach.setLock(resultSet.getBoolean("lock"));
        return nach;
    }
}
