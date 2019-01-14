package ru.tfomsbrk.pvhd.mvc.jdbc.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import ru.tfomsbrk.pvhd.mvc.bean.MO;
import ru.tfomsbrk.pvhd.mvc.jdbc.Mapper.MoMapper;

import java.util.List;

@Repository
public class MoJDBCTemplate {
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public DriverManagerDataSource getDataSource() {
        return dataSource;
    }

    public void createMO(String nm, String address, String FIOdir, String FIObuh, String shortNm, Integer MOkod, Integer IDlvl)
    {
        String sql = "insert into mo (Nm,Address,FIOdir,FIObuh,cNm,MOkod,IDlvl) VALUES (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,nm,address,FIOdir,FIObuh,shortNm,MOkod,IDlvl);
        return;
    }

    public MO getMO(Integer id)
    {
        String sql = "select * from mo where id=?";
        MO mo = jdbcTemplate.queryForObject(sql,new Object[]{id},new MoMapper());
        return mo;
    }

    public String getNameMO(Integer id)
    {
        String sql = "select * from mo where id=?";
        MO mo = jdbcTemplate.queryForObject(sql,new Object[]{id},new MoMapper());
        return mo.getName();
    }

    public List<MO> listMO()
    {
        String sql = "select * from mo";
        List<MO> mo = jdbcTemplate.query(sql, new MoMapper());
        return mo;
    }

    public void deleteMO(Integer id)
    {
        String sql = "delete from mo where id=?";
        jdbcTemplate.update(sql,id);
        return;
    }

    public MO updateMO(String nm, String address, String FIOdir, String FIObuh, String shortNm, Integer id)
    {
        String sql = "update mo set nm=?, address=?, FIOdir=?, FIObuh=?, cnm=? where id=?";
        jdbcTemplate.update(sql,nm,address,FIOdir,FIObuh,shortNm,id);
        return null;
    }
}
