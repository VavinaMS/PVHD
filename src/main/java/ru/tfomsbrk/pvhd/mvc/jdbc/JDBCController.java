package ru.tfomsbrk.pvhd.mvc.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.tfomsbrk.pvhd.mvc.bean.Users;
import ru.tfomsbrk.pvhd.mvc.jdbc.Template.UsersJDBCTemplate;


@Controller
public class JDBCController {
    @Autowired
    private UsersJDBCTemplate usersJDBCTemplate;

    @RequestMapping(value = "/user/user")
    public ModelAndView jdbcSelectAllUser()
    {
       // List<Users> users = pvhdJDBCTemplate.listUser();
        Users user = usersJDBCTemplate.getUser(2);
        ModelAndView model = new ModelAndView();
        model.addObject("resultObject",user.toString());
        model.setViewName("user/user");
        return model;
    }

    @RequestMapping(value = "/login")
    public ModelAndView modelAndViewLogin()
    {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
