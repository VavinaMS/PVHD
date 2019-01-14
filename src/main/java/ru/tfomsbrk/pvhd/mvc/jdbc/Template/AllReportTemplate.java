package ru.tfomsbrk.pvhd.mvc.jdbc.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.tfomsbrk.pvhd.mvc.bean.AllReport;
import ru.tfomsbrk.pvhd.mvc.jdbc.Mapper.AllReportMapper;

import java.util.Date;
import java.util.List;

public class AllReportTemplate {

    private DriverManagerDataSource dataSours;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSours(DriverManagerDataSource dataSours) {
        this.dataSours = dataSours;
        this.jdbcTemplate = new JdbcTemplate(dataSours);
    }

    public DriverManagerDataSource getDataSours() {
        return dataSours;
    }

    public AllReport getReport(Integer id)
    {
        String sql = "SELECT * FROM AllReport WHERE ID=?";
        AllReport allReport = jdbcTemplate.queryForObject(sql,new Object[]{id}, new AllReportMapper());
        return allReport;
    }

    public List<AllReport> listReport()
    {
        String sql = "SELECT * FROM AllReport";
        List<AllReport> allReports = jdbcTemplate.query(sql,new AllReportMapper());
        return  allReports;
    }

    public List<AllReport> listReportFromMOandReport(Integer idMo, Integer idReport)
    {
        String sql = "SELECT * FROM AllReport WHERE IDmo=? and IDreport=? ORDER BY dt_Start DESC";
        List<AllReport> allReports = jdbcTemplate.query(sql,new AllReportMapper(), idMo, idReport);
        return  allReports;
    }

    public void CreateReport(Integer idMo, Integer idReport, Date dtStart, Date dtEnd)
    {
        String sql = "INSERT INTO AllReport (IDmo, IDreport, dt_Start, Dt_End) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql,idMo,idReport,dtStart,dtEnd);
        return;
    }

    public void UpdateReport(Integer id, Date dtStart, Date dtEnd)
    {
        String sql = "UPDATE AllReport SET dt_Start = ?, Dt_End = ? WHERE id = ?";
        jdbcTemplate.update(sql,dtStart,dtEnd,id);
        return;
    }

    public AllReport getReportByIDgroupAndIDreport(Integer IDreport, Integer IDgroup)
    {
        String sql = "SELECT * FROM AllReport WHERE IDreport = ? and Grp = ?";
        AllReport allReport = jdbcTemplate.queryForObject(sql,new Object[]{IDreport, IDgroup}, new AllReportMapper());
        return allReport;
    }
}
