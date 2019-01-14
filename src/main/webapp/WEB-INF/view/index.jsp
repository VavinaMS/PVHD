<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<page:template>

    <jsp:attribute name="title">ТФОМС Брянской области - ПВХД</jsp:attribute>
    <jsp:attribute name="pageName">Еженедельные отчеты</jsp:attribute>
    <jsp:attribute name="nameUser">${nameUser}</jsp:attribute>
    <jsp:attribute name="nameMO">${nameMO}</jsp:attribute>

    <jsp:body>
        <div class="container-fluid">
        <div class="row">
        <div class="col-md-2">
            <ul  id="browser" class="filetree">
                <li><span class="folder">2018</span>
                    <ul>
                        <c:forEach items="${allreport}" var="allreport">
                            <li><c:if test="${allreport.lock}" ><span class="file"></c:if>
                                <a href="/" onClick="GetIDReport(${allreport.id})"> ${allreport.start} - ${allreport.end}</a>
                                <c:if test="${allreport.lock}" ></span></c:if>
                            </li>
                        </c:forEach>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="col-md-10">
            <table class="tab8" id="tab8" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th rowspan="2">Наименование статьи</th>
                    <th colspan="2">Сумма задолженности на начало отчетного периода</th>
                    <th rowspan="2">Выставлено счетов к оплате</th>
                    <th rowspan="2">Оплачено в отчетном периоде</th>
                    <th colspan="2">Задолженность на конец отчетного периода</th>
                </tr>
                <tr>
                    <td>Кт</td>
                    <td>в т.ч. просроченная</td>
                    <td>Кт</td>
                    <td>в т.ч. просроченная</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${stat}" var="stat">
                    <tr>
                        <td><label class="control-label"><c:out value="${stat.name}"/></label></td>
                        <td>
                            <c:forEach items="${reportRecord}" var="item">
                                <c:if test="${item.idStat == stat.id}">
                                    <input type="number" id="ktStart${stat.id}" class="form-control" value="${item.ktStart.setScale(2)}" onchange="SaveKtStart(this.value,${item.id},${stat.id}); GetSummktStart(${item.IDreportAll},${stat.id});" <c:if test="${stat.lock||item.lock}"> readonly="true" </c:if>/>
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${reportRecord}" var="item">
                                <c:if test="${item.idStat == stat.id}">
                                    <input type="number" id="prosrochStart${stat.id}" class="form-control" value="${item.prosrochStart.setScale(2)}" onchange="SaveProsrochStart(this.value,${item.id}); GetSummProsrochStart(${item.IDreportAll},${stat.id});" <c:if test="${stat.lock||item.lock}"> readonly="true" </c:if>/>
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${reportRecord}" var="item">
                                <c:if test="${item.idStat == stat.id}">
                                    <input type="number" id="vistavleno${stat.id}" class="form-control" value="${item.vistavleno.setScale(2)}" onchange="SaveViplacheno(this.value,${item.id},${stat.id}); GetSummVistavleno(${item.IDreportAll},${stat.id});" <c:if test="${stat.lock||item.lock}"> readonly="true" </c:if>/>
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${reportRecord}" var="item">
                                <c:if test="${item.idStat == stat.id}">
                                    <input type="number" id="oplacheno${stat.id}" class="form-control" value="${item.oplacheno.setScale(2)}" onchange="SaveOplacheno(this.value,${item.id},${stat.id}); GetSummOplacheno(${item.IDreportAll},${stat.id});" <c:if test="${stat.lock||item.lock}"> readonly="true" </c:if>/>
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${reportRecord}" var="item">
                                <c:if test="${item.idStat == stat.id}">
                                    <input type="number" id="ktEnd${stat.id}" class="form-control" readonly="true" value="${item.ktEnd.setScale(2)}" onchange="SaveKtEnd(this.value,${item.id}); GetSummktEnd(${item.IDreportAll},${stat.id});"/>
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${reportRecord}" var="item">
                                <c:if test="${item.idStat == stat.id}">
                                    <input type="number" id="prosrochEnd${stat.id}" class="form-control" value="${item.prosrochEnd.setScale(2)}" onchange="SaveProsrochEnd(this.value,${item.id}); GetSummprosrochEnd(${item.IDreportAll},${stat.id});" <c:if test="${stat.lock||item.lock}"> readonly="true" </c:if>/>
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        </div>
        </div>
    </jsp:body>
</page:template>
