package ru.tfomsbrk.pvhd.mvc.jdbc.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tfomsbrk.pvhd.mvc.bean.Report;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportMapper implements RowMapper<Report> {

    @Override
    public Report mapRow(ResultSet resultSet, int i) throws SQLException {
        Report report = new Report();
        report.setId(resultSet.getInt("ID"));
        report.setName(resultSet.getString("Nm"));
        report.setTable(resultSet.getString("Tbl"));
        return report;
    }
}
