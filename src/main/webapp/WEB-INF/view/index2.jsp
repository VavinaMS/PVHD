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
                <div class="col-md-12">
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
                            <c:forEach items="${stat}" var="stat">
                                <c:if test="${stat.id<3||stat.id>38}">
                                    <div class="row">
                                            <div class="col-md-4">
                                                <label class="control-label"><c:out value="${stat.name}"/></label>
                                            </div>
                                            <div class="col-md-8">
                                                <c:forEach items="${reportRecord}" var="item">
                                                    <c:if test="${item.idStat == stat.id}">
                                                        <input type="number" id="ktStart${stat.id}" class="form-control" value="${item.ktStart.setScale(2)}" onchange="SaveKtStart(this.value,${item.id}); GetSummktStart(${item.IDreportAll},${stat.id});" <c:if test="${stat.lock||item.lock}"> readonly="true" </c:if> />
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                    </div>
                                </c:if>
                                <c:if test="${stat.id>2 && stat.id<39 && stat.summto==0}">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <div class="row">
                                                <div class="col-md-10">
                                                    <label class="control-label"><c:out value="${stat.name}"/></label>
                                                </div>
                                                <div class="col-md-2 text-right">
                                                    <a data-toggle="collapse" data-parent="#collapseOne${stat.id}" href="#collapseOne${stat.id}">
                                                        <i class="fa fa-pencil"> Редактировать</i>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="collapseOne${stat.id}" class="collapse">
                                            <div class="panel-body">
                                                <div class="row">
                                                    <div class="col-md-4 text-center">
                                                        <label class="control-label">Сумма задолженности на начало отчетного периода</label>
                                                    </div>
                                                    <div class="col-md-4">
                                                    </div>
                                                    <div class="col-md-4 text-center">
                                                        <label class="control-label">Задолженность на конец отчетного периода</label>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-2 text-center">
                                                        <label class="control-label">Кт</label>
                                                    </div>
                                                    <div class="col-md-2 text-center">
                                                        <label class="control-label">в т.ч. просроченная</label>
                                                    </div>
                                                    <div class="col-md-2 text-center">
                                                        <label class="control-label">Выставлено счетов к оплате</label>
                                                    </div>
                                                    <div class="col-md-2 text-center">
                                                        <label class="control-label">Оплачено в отчетном периоде</label>
                                                    </div>
                                                    <div class="col-md-2 text-center">
                                                        <label class="control-label">Кт</label>
                                                    </div>
                                                    <div class="col-md-2 text-center">
                                                        <label class="control-label">в т.ч. просроченная</label>
                                                    </div>
                                                </div>
                                                    <div class="row">
                                                        <div class="col-md-2">
                                                            <c:forEach items="${reportRecord}" var="item">
                                                                <c:if test="${item.idStat == stat.id}">
                                                                    <input type="number" id="ktStart${stat.id}" class="form-control" value="${item.ktStart.setScale(2)}" onchange="SaveKtStart(this.value,${item.id},${stat.id}); GetSummktStart(${item.IDreportAll},${stat.id});" <c:if test="${stat.lock||item.lock}"> readonly="true" </c:if>/>
                                                                </c:if>
                                                            </c:forEach>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <c:forEach items="${reportRecord}" var="item">
                                                                <c:if test="${item.idStat == stat.id}">
                                                                    <input type="number" id="prosrochStart${stat.id}" class="form-control" value="${item.prosrochStart.setScale(2)}" onchange="SaveProsrochStart(this.value,${item.id}); GetSummProsrochStart(${item.IDreportAll},${stat.id});" <c:if test="${stat.lock||item.lock}"> readonly="true" </c:if>/>
                                                                </c:if>
                                                            </c:forEach>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <c:forEach items="${reportRecord}" var="item">
                                                                <c:if test="${item.idStat == stat.id}">
                                                                    <input type="number" id="vistavleno${stat.id}" class="form-control" value="${item.vistavleno.setScale(2)}" onchange="SaveViplacheno(this.value,${item.id},${stat.id}); GetSummVistavleno(${item.IDreportAll},${stat.id});" <c:if test="${stat.lock||item.lock}"> readonly="true" </c:if>/>
                                                                </c:if>
                                                            </c:forEach>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <c:forEach items="${reportRecord}" var="item">
                                                                <c:if test="${item.idStat == stat.id}">
                                                                    <input type="number" id="oplacheno${stat.id}" class="form-control" value="${item.oplacheno.setScale(2)}" onchange="SaveOplacheno(this.value,${item.id},${stat.id}); GetSummOplacheno(${item.IDreportAll},${stat.id});" <c:if test="${stat.lock||item.lock}"> readonly="true" </c:if>/>
                                                                </c:if>
                                                            </c:forEach>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <c:forEach items="${reportRecord}" var="item">
                                                                <c:if test="${item.idStat == stat.id}">
                                                                    <input type="number" id="ktEnd${stat.id}" class="form-control" readonly="true" value="${item.ktEnd.setScale(2)}" onchange="SaveKtEnd(this.value,${item.id}); GetSummktEnd(${item.IDreportAll},${stat.id});"/>
                                                                </c:if>
                                                            </c:forEach>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <c:forEach items="${reportRecord}" var="item">
                                                                <c:if test="${item.idStat == stat.id}">
                                                                    <input type="number" id="prosrochEnd${stat.id}" class="form-control" value="${item.prosrochEnd.setScale(2)}" onchange="SaveProsrochEnd(this.value,${item.id}); GetSummprosrochEnd(${item.IDreportAll},${stat.id});" <c:if test="${stat.lock||item.lock}"> readonly="true" </c:if>/>
                                                                </c:if>
                                                            </c:forEach>
                                                        </div>
                                                    </div>

                                                <c:forEach items="${stat2}" var="stat2">
                                                    <c:if test="${stat2.summto == stat.id}">
                                                        <div class="row"  style="background-color: #f5f2ef; margin: 5px;">
                                                            <div class="col-md-11">
                                                                <label class="control-label"><c:out value="${stat2.name}"/></label>
                                                            </div>
                                                            <div class="col-md-1 text-right" >
                                                                <a data-toggle="collapse" data-parent="#collapseOne${stat2.id}" href="#collapseOne${stat2.id}">
                                                                    <i class="fa fa-pencil"></i>
                                                                </a>
                                                            </div>
                                                        </div>
                                                <div id="collapseOne${stat2.id}" class="collapse" style="padding: 15px;">
                                                        <div class="row">
                                                            <div class="col-md-4 text-center">
                                                                <label class="control-label">Сумма задолженности на начало отчетного периода</label>
                                                            </div>
                                                            <div class="col-md-4">
                                                            </div>
                                                            <div class="col-md-4 text-center">
                                                                <label class="control-label">Задолженность на конец отчетного периода</label>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-md-2 text-center">
                                                                <label class="control-label">Кт</label>
                                                            </div>
                                                            <div class="col-md-2 text-center">
                                                                <label class="control-label">в т.ч. просроченная</label>
                                                            </div>
                                                            <div class="col-md-2 text-center">
                                                                <label class="control-label">Выставлено счетов к оплате</label>
                                                            </div>
                                                            <div class="col-md-2 text-center">
                                                                <label class="control-label">Оплачено в отчетном периоде</label>
                                                            </div>
                                                            <div class="col-md-2 text-center">
                                                                <label class="control-label">Кт</label>
                                                            </div>
                                                            <div class="col-md-2 text-center">
                                                                <label class="control-label">в т.ч. просроченная</label>
                                                            </div>
                                                        </div>
                                                            <div class="row">
                                                                <div class="col-md-2">
                                                                    <c:forEach items="${reportRecord}" var="item">
                                                                        <c:if test="${item.idStat == stat2.id}">
                                                                            <input type="number" id="ktStart${stat2.id}" class="form-control" value="${item.ktStart.setScale(2)}" onchange="SaveKtStart(this.value,${item.id},${stat2.id}); GetSummktStart(${item.IDreportAll},${stat2.id});" <c:if test="${stat2.lock||item.lock}"> readonly="true" </c:if>/>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </div>
                                                                <div class="col-md-2">
                                                                    <c:forEach items="${reportRecord}" var="item">
                                                                        <c:if test="${item.idStat == stat2.id}">
                                                                            <input type="number" id="prosrochStart${stat2.id}" class="form-control" value="${item.prosrochStart.setScale(2)}" onchange="SaveProsrochStart(this.value,${item.id}); GetSummProsrochStart(${item.IDreportAll},${stat2.id});" <c:if test="${stat2.lock||item.lock}"> readonly="true" </c:if>/>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </div>
                                                                <div class="col-md-2">
                                                                    <c:forEach items="${reportRecord}" var="item">
                                                                        <c:if test="${item.idStat == stat2.id}">
                                                                            <input type="number" id="vistavleno${stat2.id}" class="form-control" value="${item.vistavleno.setScale(2)}" onchange="SaveViplacheno(this.value,${item.id},${stat2.id}); GetSummVistavleno(${item.IDreportAll},${stat2.id});" <c:if test="${stat2.lock||item.lock}"> readonly="true" </c:if>/>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </div>
                                                                <div class="col-md-2">
                                                                    <c:forEach items="${reportRecord}" var="item">
                                                                        <c:if test="${item.idStat == stat2.id}">
                                                                            <input type="number" id="oplacheno${stat2.id}" class="form-control" value="${item.oplacheno.setScale(2)}" onchange="SaveOplacheno(this.value,${item.id},${stat2.id}); GetSummOplacheno(${item.IDreportAll},${stat2.id});" <c:if test="${stat2.lock||item.lock}"> readonly="true" </c:if>/>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </div>
                                                                <div class="col-md-2">
                                                                    <c:forEach items="${reportRecord}" var="item">
                                                                        <c:if test="${item.idStat == stat2.id}">
                                                                            <input type="number" id="ktEnd${stat2.id}" class="form-control" readonly="true" value="${item.ktEnd.setScale(2)}" onchange="SaveKtEnd(this.value,${item.id}); GetSummktEnd(${item.IDreportAll},${stat2.id});"/>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </div>
                                                                <div class="col-md-2">
                                                                    <c:forEach items="${reportRecord}" var="item">
                                                                        <c:if test="${item.idStat == stat2.id}">
                                                                            <input type="number" id="prosrochEnd${stat2.id}" class="form-control" value="${item.prosrochEnd.setScale(2)}" onchange="SaveProsrochEnd(this.value,${item.id}); GetSummprosrochEnd(${item.IDreportAll},${stat2.id});" <c:if test="${stat2.lock||item.lock}"> readonly="true" </c:if>/>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </div>
                                                            </div>
                                                </div>
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>

                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>

</page:template>
