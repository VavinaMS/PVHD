package ru.tfomsbrk.pvhd.mvc.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.tfomsbrk.pvhd.mvc.bean.*;
import ru.tfomsbrk.pvhd.mvc.jdbc.Template.AllReportTemplate;
import ru.tfomsbrk.pvhd.mvc.jdbc.Template.NachTemplate;
import ru.tfomsbrk.pvhd.mvc.jdbc.Template.PrihJDBCTemplate;
import ru.tfomsbrk.pvhd.mvc.jdbc.Template.StatJDBCTemplate;

import java.util.List;

@Controller
@SessionAttributes(value = "idReportMonthly")
public class MonthlyController {
    @Autowired
    private StatJDBCTemplate statJDBCTemplate;
    @Autowired
    private AllReportTemplate allReportTemplate;
    @Autowired
    private PrihJDBCTemplate prihJDBCTemplate;
    @Autowired
    private NachTemplate nachTemplate;

    @RequestMapping(value = "/monthly", method = RequestMethod.GET)
    public ModelAndView showMonthlyReport(@ModelAttribute("idReportMonthly") Integer idReport)
    {
        ModelAndView modelAndView = new ModelAndView();
        List<Stat> stat = statJDBCTemplate.listStatToReport(2); //загрузка статей
        List<Stat> stat1 = statJDBCTemplate.listStatToReport(3); //загрузка статей
        List<Stat> stat2 = statJDBCTemplate.listStatToReport(4); //загрузка статей
        SecurityContext securityContext = SecurityContextHolder.getContext();
        CustomUser user;
        if(null != securityContext.getAuthentication()) {
            user = (CustomUser) securityContext.getAuthentication().getPrincipal(); //получение информации о пользователе
            int id = user.getIdMO(); //Получение ID МО
            List<AllReport> allReports = allReportTemplate.listReportFromMOandReport(id,2);
            modelAndView.addObject("allreport",allReports);//загрузка отчетов этой МО
            if(allReports.size()>0) {
                AllReport allReport = allReports.get(0);
                int idTop = allReport.getId();
                if (0 != idReport) {
                    List<Prih> prihList = prihJDBCTemplate.getPrihReport(idReport);
                    AllReport tmpReport = allReportTemplate.getReport(idReport);
                    AllReport nachReport = allReportTemplate.getReportByIDgroupAndIDreport(3, tmpReport.getGroup());
                    List<Nach> nachList = nachTemplate.getNachReport(nachReport.getId());
                    modelAndView.addObject("reportRecord", prihList);
                    modelAndView.addObject("reportRecord1", nachList);
                } else {
                    modelAndView.addObject("idReportMonthly",idTop);
                    List<Prih> prihList = prihJDBCTemplate.getPrihReport(idTop);
                    AllReport nachReport = allReportTemplate.getReportByIDgroupAndIDreport(3, allReport.getGroup());
                    List<Nach> nachList = nachTemplate.getNachReport(nachReport.getId());
                    modelAndView.addObject("reportRecord", prihList);
                    modelAndView.addObject("reportRecord1", nachList);
                }
            }
        }

        modelAndView.addObject("resultObject", new Prih());
        modelAndView.addObject("stat",stat);
        modelAndView.addObject("stat1",stat1);
        modelAndView.addObject("stat2",stat1);
        modelAndView.setViewName("monthly");
        return modelAndView;
    }

    @RequestMapping(value = "/idToSessionMonthly", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView saveIdToSession(@RequestParam("ID") Integer id)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("monthly");
        modelAndView.addObject("idReportMonthly",id);
        return modelAndView;
    }

    @ModelAttribute("idReportMonthly")
    public Integer createUser() {
        return 0;
    }

}
