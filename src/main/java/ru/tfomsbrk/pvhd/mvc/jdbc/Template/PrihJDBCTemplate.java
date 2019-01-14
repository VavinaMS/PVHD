package ru.tfomsbrk.pvhd.mvc.jdbc.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.tfomsbrk.pvhd.mvc.bean.Prih;
import ru.tfomsbrk.pvhd.mvc.jdbc.Mapper.PrihMapper;

import java.util.List;

public class PrihJDBCTemplate {
    private DriverManagerDataSource dataSours;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSours(DriverManagerDataSource dataSours) {
        this.dataSours = dataSours;
        this.jdbcTemplate = new JdbcTemplate(dataSours);
    }

    public Prih getPrih(Integer id)
    {
        String sql = "SELECT * FROM Prih WHERE id = ?";
        Prih prih = jdbcTemplate.queryForObject(sql, new Object[]{id}, new PrihMapper());
        return prih;
    }

    public List<Prih> getPrihReport(Integer idAllReport)
    {
        String sql = "SELECT * FROM Prih WHERE IDreportAll=?";
        List<Prih> prihList = jdbcTemplate.query(sql,new PrihMapper(),idAllReport);
        return prihList;
    }


    public DriverManagerDataSource getDataSours() {
        return dataSours;
    }
}
