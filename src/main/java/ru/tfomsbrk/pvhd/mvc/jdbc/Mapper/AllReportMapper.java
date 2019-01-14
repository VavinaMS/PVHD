package ru.tfomsbrk.pvhd.mvc.jdbc.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tfomsbrk.pvhd.mvc.bean.AllReport;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AllReportMapper implements RowMapper<AllReport> {

    @Override
    public AllReport mapRow(ResultSet resultSet, int i) throws SQLException {
        AllReport allReport = new AllReport();
        allReport.setId(resultSet.getInt("ID"));
        allReport.setIdMo(resultSet.getInt("IDmo"));
        allReport.setIdReport(resultSet.getInt("IDreport"));
        allReport.setDtStart(resultSet.getDate("dt_Start"));
        allReport.setDtEnd(resultSet.getDate("Dt_End"));
        allReport.setLock(resultSet.getBoolean("lock"));
        allReport.setGroup(resultSet.getInt("Grp"));
        return allReport;
    }
}
