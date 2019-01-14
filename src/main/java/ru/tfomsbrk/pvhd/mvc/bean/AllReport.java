package ru.tfomsbrk.pvhd.mvc.bean;

import java.sql.Date;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

public class AllReport {
    private Integer id;
    private Integer idMo;
    private Integer idReport;
    private Integer year;
    private String start;
    private String end;
    private Date dtStart;
    private Date dtEnd;
    private boolean lock;
    private Integer group;

    private String formatDate(Date dt)
    {
        String[] russianMonat = {
                "января",
                "февраля",
                "марта",
                "апреля",
                "мая",
                "июня",
                "июля",
                "августа",
                "сентября",
                "октября",
                "ноября",
                "декабря"
        };
        Locale loc = Locale.forLanguageTag("ru");
        DateFormatSymbols russSymbol = new DateFormatSymbols(loc);
        russSymbol.setMonths(russianMonat);
        SimpleDateFormat sdf = new SimpleDateFormat("d MMMM", russSymbol);
        return sdf.format(dt);
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Integer getId() {
        return id;
    }

    public void setDtStart(Date dtStart) {
        this.dtStart = dtStart;
        Calendar cal = Calendar.getInstance();
        cal.setTime(dtStart);
        this.year = cal.get(Calendar.YEAR);
        this.start = formatDate(dtStart);
    }

    public void setDtEnd(Date dtEnd) {
        this.dtEnd = dtEnd;
        this.end = formatDate(dtEnd);
    }

    public Date getDtStart() {
        return dtStart;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDtEnd() {
        return dtEnd;
    }

    public Integer getIdMo() {
        return idMo;
    }

    public Integer getIdReport() {
        return idReport;
    }

    public void setIdMo(Integer idMo) {
        this.idMo = idMo;
    }

    public void setIdReport(Integer idReport) {
        this.idReport = idReport;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getEnd() {
        return end;
    }

    public String getStart() {
        return start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    @Override
    public String toString() {
        return "ID: " + id +"\n"+
                "IDmo: " + idMo + "\n"+
                "IDreport" + idReport + "\n"+
                "dtStart" + dtStart + "\n"+
                "dtEnd" + dtEnd + "\n" +
                "lock" + lock + "\n";
    }
}
