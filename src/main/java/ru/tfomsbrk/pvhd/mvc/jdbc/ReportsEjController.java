package ru.tfomsbrk.pvhd.mvc.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.tfomsbrk.pvhd.mvc.bean.*;
import ru.tfomsbrk.pvhd.mvc.jdbc.Template.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/*")
@SessionAttributes(value = "idReport")
public class ReportsEjController {
    @Autowired
    private StatJDBCTemplate statJDBCTemplate;
    @Autowired
    private AllReportTemplate allReportTemplate;
    @Autowired
    private EjJDBCTemplete ejJDBCTemplete;
    @Autowired
    private MoJDBCTemplate moJDBCTemplate;
    @Autowired
    private IspJDBCTemplate ispJDBCTemplate;

    @ModelAttribute("idReport")
    public Integer createUser() {
        return 0;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showIndex(@ModelAttribute("idReport") Integer idReport)
    {
        ModelAndView model = new ModelAndView();
        List<Stat> stat = statJDBCTemplate.listStatToReport(1); //загрузка статей
        SecurityContext securityContext = SecurityContextHolder.getContext();
        CustomUser user;
        if(null != securityContext.getAuthentication()) {
            user = (CustomUser) securityContext.getAuthentication().getPrincipal(); //получение информации о пользователе
            int id = user.getIdMO(); //Получение ID МО
            int idUser = user.getIdIsp();
            String nameUser = ispJDBCTemplate.getFioIsp(idUser);
            String nameMO = moJDBCTemplate.getNameMO(id);
            model.addObject("nameMO",nameMO);
            model.addObject("nameUser",nameUser);
            List<AllReport> allReports = allReportTemplate.listReportFromMOandReport(id, 1);
            model.addObject("allreport",allReports);//загрузка отчетов этой МО
            AllReport allReport = allReports.get(0);
            int idTop = allReport.getId();
        if(0 != idReport) {
            List<Ej> ejList = ejJDBCTemplete.gerEjReport(idReport);
            model.addObject("reportRecord",ejList);
        }else {
            model.addObject("idReport",idTop);
            List<Ej> ejList = ejJDBCTemplete.gerEjReport(idTop);
            model.addObject("reportRecord",ejList);
        }
        }
        model.addObject("resultObject", new Ej());
        model.addObject("stat",stat);
        model.addObject("stat2",stat);

        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/saveKtStart")
    @ResponseBody
    public  String saveReportKtStart(@RequestParam("ktStart")BigDecimal kt, @RequestParam("ID") Integer id, Model model)
    {
        ejJDBCTemplete.updateKtStart(kt,id);
        Ej ej = ejJDBCTemplete.getEj(id);
        return ej.getKtEnd().toString();
    }

    @RequestMapping(value = "/saveProsrochStart", method = RequestMethod.POST)
    @ResponseBody
    public void saveReportProsrochStart(@RequestParam("prosrochStart") BigDecimal prosroch, @RequestParam("ID") Integer id, Model model)
    {
        ejJDBCTemplete.updateProsroshStart(prosroch,id);
    }

    @RequestMapping(value = "/saveViplacheno", method = RequestMethod.POST)
    @ResponseBody
    public String  saveReportViplacheno(@RequestParam("viplocheno") BigDecimal viplacheno, @RequestParam("ID") Integer id, Model model)
    {
        ejJDBCTemplete.updateVistavleno(viplacheno,id);
        Ej ej = ejJDBCTemplete.getEj(id);
        return ej.getKtEnd().toString();
    }

    @RequestMapping(value = "/saveOplacheno", method = RequestMethod.POST)
    @ResponseBody
    public String saveReportOplacheno(@RequestParam("oplacheno") BigDecimal oplacheno, @RequestParam("ID") Integer id, Model model)
    {
        ejJDBCTemplete.updateOplacheno(oplacheno,id);
        Ej ej = ejJDBCTemplete.getEj(id);
        return ej.getKtEnd().toString();
    }

    @RequestMapping(value = "/saveKtEnd", method = RequestMethod.POST)
    @ResponseBody
    public void saveReportKtEnd(@RequestParam("ktEnd") BigDecimal ktEnd, @RequestParam("ID") Integer id, Model model)
    {
        ejJDBCTemplete.updateKtEnd(ktEnd,id);
    }

    @RequestMapping(value = "/saveProsrochEnd", method = RequestMethod.POST)
    @ResponseBody
    public void saveProsrochEnd(@RequestParam("prosrochEnd") BigDecimal prosroch, @RequestParam("ID") Integer id)
    {
        ejJDBCTemplete.updateProsrochenoEnd(prosroch, id);
    }

    @RequestMapping(value = "/idToSession", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView saveIdToSession(@RequestParam("ID") Integer id)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("idReport",id);
        return modelAndView;
    }

    @RequestMapping(value = "/get290ktStart", method = RequestMethod.POST)
    @ResponseBody
    public String getKtStart290(@RequestParam("ID") Integer id)
    {
        Ej ej = ejJDBCTemplete.getEjByAllReportAndIdStat(id,8);
        return ej.getKtStart().toString();
    }
}
