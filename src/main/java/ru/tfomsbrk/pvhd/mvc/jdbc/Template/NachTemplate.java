package ru.tfomsbrk.pvhd.mvc.jdbc.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import ru.tfomsbrk.pvhd.mvc.bean.Nach;
import ru.tfomsbrk.pvhd.mvc.jdbc.Mapper.NachMapper;

import java.util.List;

@Repository
public class NachTemplate {
    private DriverManagerDataSource dataSours;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSours(DriverManagerDataSource dataSours) {
        this.dataSours = dataSours;
        jdbcTemplate = new JdbcTemplate(dataSours);
    }

    public List<Nach> getNachReport(Integer idAllReport)
    {
        String sql = "SELECT * FROM Nach WHERE IDallReport=?";
        List<Nach> nachList = jdbcTemplate.query(sql,new NachMapper(),idAllReport);
        return nachList;
    }

    public DriverManagerDataSource getDataSours() {
        return dataSours;
    }
}
