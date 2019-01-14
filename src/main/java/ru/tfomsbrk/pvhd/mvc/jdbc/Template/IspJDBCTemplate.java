package ru.tfomsbrk.pvhd.mvc.jdbc.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.tfomsbrk.pvhd.mvc.bean.Isp;
import ru.tfomsbrk.pvhd.mvc.jdbc.Mapper.IspMapper;

public class IspJDBCTemplate {
    private DriverManagerDataSource dataSours;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSours(DriverManagerDataSource dataSours) {
        this.dataSours = dataSours;
        this.jdbcTemplate = new JdbcTemplate(dataSours);
    }

    public String getFioIsp(Integer id)
    {
        String sql = "select * from Isp where id=?";
        Isp isp = jdbcTemplate.queryForObject(sql,new Object[]{id},new IspMapper());
        return isp.getFio();
    }

    public DriverManagerDataSource getDataSours() {
        return dataSours;
    }
}
