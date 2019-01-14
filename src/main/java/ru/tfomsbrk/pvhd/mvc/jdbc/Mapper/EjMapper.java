package ru.tfomsbrk.pvhd.mvc.jdbc.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tfomsbrk.pvhd.mvc.bean.Ej;


import java.sql.ResultSet;
import java.sql.SQLException;

public class EjMapper implements RowMapper<Ej> {
    @Override
    public Ej mapRow (ResultSet rs, int rowNum) throws SQLException
    {
        Ej ej = new Ej();
        ej.setId(rs.getInt("ID"));
        ej.setIdStat(rs.getInt("IDstat"));
        ej.setKtStart(rs.getBigDecimal("Kt_Start"));
        ej.setProsrochStart(rs.getBigDecimal("prosroch_Start"));
        ej.setVistavleno(rs.getBigDecimal("vistavleno"));
        ej.setOplacheno(rs.getBigDecimal("Oplacheno"));
        ej.setKtEnd(rs.getBigDecimal("Kt_End"));
        ej.setProsrochEnd(rs.getBigDecimal("prosroch_end"));
        ej.setIDreportAll(rs.getInt("IDreportAll"));
        ej.setLock(rs.getBoolean("lock"));
        return ej;
    }
}
