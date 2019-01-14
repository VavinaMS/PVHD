package ru.tfomsbrk.pvhd.mvc.jdbc.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import ru.tfomsbrk.pvhd.mvc.bean.UserAuthorized;
import ru.tfomsbrk.pvhd.mvc.bean.Users;
import ru.tfomsbrk.pvhd.mvc.jdbc.Mapper.UserAuthorizedMapper;
import ru.tfomsbrk.pvhd.mvc.jdbc.Mapper.UserMapper;

import java.util.List;

@Repository
public class UsersJDBCTemplate {
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void createUser(String login, char pass, Integer idrole, Integer idisp)
    {
       String sql = "insert into user (Lgn,Pwd,IDisp,Role) VALUES (?,?,?,?)";
       jdbcTemplateObject.update(sql,login,pass,idisp,idrole);
       return;
    }

    public Users getUser(Integer id)
    {
        String sql = "select * from users where id=?";
        Users usr = jdbcTemplateObject.queryForObject(sql,new Object[]{id}, new UserMapper());
        return usr;
    }

    public List<Users> listUser()
    {
        String sql = "select * from Users";
        List<Users> users = jdbcTemplateObject.query(sql,new UserMapper());
        return users;
    }

    public void deleteUser(Integer id)
    {
        String sql = "delete from users where id=?";
        jdbcTemplateObject.update(sql,id);
        return;
    }

    public void updateUser(Integer id, String pass)
    {
        String sql = "update Users Set Pwd = ? where id = ?";
        jdbcTemplateObject.update(sql,pass,id);
        return;
    }

    public UserAuthorized getUserByUserName(String username)
    {
        String sql = "select RoleName, Lgn, Pwd, IDisp, IDmo From Users Inner Join Role On Users.IDRole = Role.ID INNER JOIN Isp ON Isp.ID = Users.IDisp Where Lgn=?";
        UserAuthorized userAuthorized = jdbcTemplateObject.queryForObject(sql,new Object[]{username},new UserAuthorizedMapper());
        return userAuthorized;
    }

    @Autowired
    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public DriverManagerDataSource getDataSource() {
        return dataSource;
    }
}
