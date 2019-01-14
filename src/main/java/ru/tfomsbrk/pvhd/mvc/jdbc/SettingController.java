package ru.tfomsbrk.pvhd.mvc.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.tfomsbrk.pvhd.mvc.bean.CustomUser;
import ru.tfomsbrk.pvhd.mvc.bean.MO;
import ru.tfomsbrk.pvhd.mvc.jdbc.Template.MoJDBCTemplate;

@Controller
public class SettingController {

    @Autowired
    private MoJDBCTemplate moJDBCTemplate;

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public ModelAndView getSettings() {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        CustomUser user;
        MO mo = new MO();
        if(null != securityContext.getAuthentication()){
            user = (CustomUser) securityContext.getAuthentication().getPrincipal();
            int id = user.getIdMO();
            mo = moJDBCTemplate.getMO(id);
        }
        return new ModelAndView("settings","mo",mo);
    }

    @RequestMapping(value = "/settings", method = RequestMethod.POST)
    public String saveMO(@ModelAttribute("mo") MO mo, Model model)
    {
        moJDBCTemplate.updateMO(mo.getName(),mo.getAddress(),mo.getFioDir(),mo.getFioBuh(),mo.getShortName(),3);
        return "Данные успешно сохранены";
    }
}
