package ru.tfomsbrk.pvhd.mvc.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ru.tfomsbrk.pvhd.mvc.bean.AllReport;
import ru.tfomsbrk.pvhd.mvc.bean.CustomUser;
import ru.tfomsbrk.pvhd.mvc.jdbc.Template.AllReportTemplate;

@Controller
@SessionAttributes(value = "idReport")
public class AllReportController {
    @Autowired
    private AllReportTemplate allReportTemplate;

    @RequestMapping(value = "/newreport", method = RequestMethod.GET)
    public ModelAndView setReport()
    {
        AllReport nullAllReport = new AllReport();
        return new ModelAndView("newreport", "resultObject", nullAllReport);
    }

    @RequestMapping(value = "/newreport", method = RequestMethod.POST)
    public String saveReport(@ModelAttribute("resultObject") AllReport allreport, Model model)
    {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        CustomUser user;
        if(null != securityContext.getAuthentication()) {
            user = (CustomUser) securityContext.getAuthentication().getPrincipal();
            int id = user.getIdMO();
            allReportTemplate.CreateReport(id,1,allreport.getDtStart(),allreport.getDtEnd());
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/newreport-monthly", method = RequestMethod.GET)
    public ModelAndView setReportMonthly()
    {
        AllReport nullAllReport = new AllReport();
        return new ModelAndView("newreport-monthly", "resultObject", nullAllReport);
    }

    @RequestMapping(value = "/newreport-monthly", method = RequestMethod.POST)
    public String saveReportMonthly(@ModelAttribute("resultObject") AllReport allreport, Model model)
    {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        CustomUser user;
        if(null != securityContext.getAuthentication()) {
            user = (CustomUser) securityContext.getAuthentication().getPrincipal();
            int id = user.getIdMO();
            allReportTemplate.CreateReport(id,2,allreport.getDtStart(),allreport.getDtEnd());
            allReportTemplate.CreateReport(id,3,allreport.getDtStart(),allreport.getDtEnd());
            allReportTemplate.CreateReport(id,4,allreport.getDtStart(),allreport.getDtEnd());
            allReportTemplate.CreateReport(id,5,allreport.getDtStart(),allreport.getDtEnd());
        }
        return "redirect:/monthly";
    }

}
