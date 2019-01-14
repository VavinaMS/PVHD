package ru.tfomsbrk.pvhd.mvc.jdbc.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import ru.tfomsbrk.pvhd.mvc.bean.Ej;
import ru.tfomsbrk.pvhd.mvc.jdbc.Mapper.EjMapper;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public class EjJDBCTemplete {
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Autowired
    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public DriverManagerDataSource getDataSource() {
        return dataSource;
    }

    public Ej getEj(Integer id)
    {
        String sql = "SELECT * FROM ej WHERE id=?";
        Ej ej = jdbcTemplateObject.queryForObject(sql,new Object[]{id},new EjMapper());
        return ej;
    }

    public Ej getEjByAllReportAndIdStat(Integer idAllReport, Integer idStat)
    {
        String sql = "SELECT * FROM ej WHERE IDreportAll=? and IDstat = ?";
        Ej ej = jdbcTemplateObject.queryForObject(sql,new Object[]{idAllReport, idStat},new EjMapper());
        return ej;
    }

    public List<Ej> listEj ()
    {
        String sql = "SELECT * FROM Ej";
        List<Ej> ej = jdbcTemplateObject.query(sql, new EjMapper());
        return ej;
    }

    public List<Ej> gerEjReport(Integer idAllReport)
    {
        String sql = "SELECT * FROM Ej WHERE IDreportAll=?";
        List<Ej> ej = jdbcTemplateObject.query(sql, new EjMapper(),idAllReport);
        return ej;
    }

    public void createEj(Integer IDstat, BigDecimal ktStart, BigDecimal prosrochStart, BigDecimal vistavleno, BigDecimal oplacheno,
                         BigDecimal ktEnd, BigDecimal prosrochenoEnd, Integer idAllReport)
    {
        String sql = "INSERT INTO ej (IDmo, IDstat, Kt_Start, prosroch_Start, vistavleno, oplacheno, Kt_end, prosroch_end, IDreportAll) VALUES (?,?,?,?,?,?,?,?)";
        jdbcTemplateObject.update(sql,IDstat,ktStart,prosrochStart,vistavleno,oplacheno,ktEnd,prosrochenoEnd,idAllReport);
        return;
    }

    public void updateKtStart(BigDecimal ktStart, Integer id)
    {
        String sql="UPDATE Ej SET Kt_Start=? WHERE ID=?";
        jdbcTemplateObject.update(sql,ktStart,id);
        return;
    }

    public void updateProsroshStart(BigDecimal prosrochStart, Integer id)
    {
        String sql="UPDATE Ej SET prosroch_Start=? WHERE ID=?";
        jdbcTemplateObject.update(sql,prosrochStart,id);
        return;
    }

    public void updateVistavleno(BigDecimal vistavleno, Integer id)
    {
        String sql="UPDATE Ej SET vistavleno=? WHERE ID=?";
        jdbcTemplateObject.update(sql,vistavleno,id);
        return;
    }

    public void updateOplacheno(BigDecimal oplacheno, Integer id)
    {
        String sql="UPDATE Ej SET Oplacheno=? WHERE ID=?";
        jdbcTemplateObject.update(sql,oplacheno,id);
        return;
    }

    public void updateKtEnd(BigDecimal ktEnd, Integer id)
    {
        String sql="UPDATE Ej SET Kt_end=? WHERE ID=?";
        jdbcTemplateObject.update(sql,ktEnd,id);
        return;
    }

    public void updateProsrochenoEnd(BigDecimal prosrochenoEnd, Integer id)
    {
        String sql="UPDATE Ej SET prosroch_end=? WHERE ID=?";
        jdbcTemplateObject.update(sql,prosrochenoEnd,id);
        return;
    }

}
