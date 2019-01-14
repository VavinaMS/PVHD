package ru.tfomsbrk.pvhd.mvc.jdbc.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tfomsbrk.pvhd.mvc.bean.StatToReport;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatToReportMapper implements RowMapper<StatToReport> {
    @Override
    public StatToReport mapRow(ResultSet resultSet, int i) throws SQLException {
        StatToReport statToReport = new StatToReport();
        statToReport.setIdreport(resultSet.getInt("IDreport"));
        statToReport.setIdstat(resultSet.getInt("IDstat"));
        return statToReport;
    }
}
