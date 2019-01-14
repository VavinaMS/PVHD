package ru.tfomsbrk.pvhd.mvc.jdbc.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import ru.tfomsbrk.pvhd.mvc.bean.Stat;
import ru.tfomsbrk.pvhd.mvc.jdbc.Mapper.StatMapper;

import java.util.List;

@Repository
public class StatJDBCTemplate {

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

    public Stat getStat(Integer id)
    {
        String sql = "SELECT * FROM Stat WHERE id=?";
        Stat stat = jdbcTemplate.queryForObject(sql,new Object[]{id},new StatMapper());
        return stat;
    }

    public List<Stat> listStat()
    {
        String sql = "SELECT * FROM Stat";
        List<Stat> stats = jdbcTemplate.query(sql,new StatMapper());
        return stats;
    }

    public List<Stat> listStatToReport(Integer idReport)
    {
        String sql = "SELECT Stat.* FROM Stat " +
                     "INNER JOIN StatToReport ON StatToReport.idstat = Stat.id WHERE idreport=? order by IDreport, IDstat";
        List<Stat> stats = jdbcTemplate.query(sql, new StatMapper(),idReport);
        return stats;
    }
}
