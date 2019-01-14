<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<page:template>

    <jsp:attribute name="title">ТФОМС Брянской области - ПВХД</jsp:attribute>

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
                                            <a href="/monthly" onClick="GetIDReportMonthly(${allreport.id})"> ${allreport.start} - ${allreport.end}</a>
                                <c:if test="${allreport.lock}" ></span></c:if>
                            </li>
                        </c:forEach>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="col-md-10">
            <div class="tabtabs">
                <input id="tabtabs1" type="radio" name="tabtabs" checked>
                <label for="tabtabs1" title="Вкладка 1">Поступление</label>

                <input id="tabtabs2" type="radio" name="tabtabs">
                <label for="tabtabs2" title="Вкладка 2">Начисления</label>

                <input id="tabtabs3" type="radio" name="tabtabs">
                <label for="tabtabs3" title="Вкладка 3">Кассовые расходы</label>

                <input id="tabtabs4" type="radio" name="tabtabs">
                <label for="tabtabs4" title="Вкладка 4">Дт и Кт</label>

                <section id="content-tabtabs1">
                        <c:forEach items="${stat}" var="stat">
                        <div class="row">
                            <div class="col-md-8">
                                <label class="control-label"><c:out value="${stat.name}"/></label>
                            </div>
                            <div class="col-md-4">
                            <c:forEach items="${reportRecord}" var="item">
                                <c:if test="${item.idStat == stat.id}">
                                    <input type="number" id="ktStart${stat.id}" class="form-control" value="${item.val.setScale(2)}" onchange="SaveKtStart(this.value,${item.id});" <c:if test="${stat.lock||item.lock}"> readonly="true" </c:if> />
                                </c:if>
                            </c:forEach>
                            </div>
                        </div>
                        </c:forEach>
                </section>
                <section id="content-tabtabs2">
                    <c:forEach items="${stat1}" var="stat1">
                        <c:if test="${stat1.summto==0}">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-md-10">
                                    <label class="control-label"><c:out value="${stat1.name}"/></label>
                                </div>
                                <div class="col-md-2 text-right">
                                    <a data-toggle="collapse" data-parent="#collapseOne${stat1.id}" href="#collapseOne${stat1.id}">
                                        <i class="fa fa-pencil"> Редактировать</i>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div id="collapseOne${stat1.id}" class="collapse">
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-12 text-center">
                                        <label class="control-label">В рамках базовой программы ОМС</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-1 text-center">
                                        <label class="control-label">Амбулаторная медицинская помощь</label>
                                    </div>
                                    <div class="col-md-1 text-center">
                                        <label class="control-label">Стоматологическая помощь</label>
                                    </div>
                                    <div class="col-md-1 text-center">
                                        <label class="control-label">Стационарная помощь</label>
                                    </div>
                                    <div class="col-md-1 text-center">
                                        <label class="control-label">в т.ч.  ВМП</label>
                                    </div>
                                    <div class="col-md-1 text-center">
                                        <label class="control-label">в т.ч. реабилитация</label>
                                    </div>
                                    <div class="col-md-1 text-center">
                                        <label class="control-label">Дневной стационар</label>
                                    </div>
                                    <div class="col-md-1 text-center">
                                        <label class="control-label">в т.ч.  ВМП</label>
                                    </div>
                                    <div class="col-md-1 text-center">
                                        <label class="control-label">в т.ч. реабилитация</label>
                                    </div>
                                    <div class="col-md-1 text-center">
                                        <label class="control-label">Скорая помощь</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-1">
                                        <c:forEach items="${reportRecord1}" var="item">
                                            <c:if test="${item.idStat == stat1.id}">
                                                <input type="number" id="APP${stat1.id}" class="form-control" value="${item.app.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="col-md-1">
                                        <c:forEach items="${reportRecord1}" var="item">
                                            <c:if test="${item.idStat == stat1.id}">
                                                <input type="number" id="Stomat${stat1.id}" class="form-control" value="${item.stomat.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="col-md-1">
                                        <c:forEach items="${reportRecord1}" var="item">
                                            <c:if test="${item.idStat == stat1.id}">
                                                <input type="number" id="Stac${stat1.id}" class="form-control" value="${item.stat.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="col-md-1">
                                        <c:forEach items="${reportRecord1}" var="item">
                                            <c:if test="${item.idStat == stat1.id}">
                                                <input type="number" id="VMP${stat1.id}" class="form-control" value="${item.vmp.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="col-md-1">
                                        <c:forEach items="${reportRecord1}" var="item">
                                            <c:if test="${item.idStat == stat1.id}">
                                                <input type="number" id="Reab${stat1.id}" class="form-control" value="${item.reab.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="col-md-1">
                                        <c:forEach items="${reportRecord1}" var="item">
                                            <c:if test="${item.idStat == stat1.id}">
                                                <input type="number" id="DnStac${stat1.id}" class="form-control" value="${item.dnStac.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="col-md-1">
                                        <c:forEach items="${reportRecord1}" var="item">
                                            <c:if test="${item.idStat == stat1.id}">
                                                <input type="number" id="vmpDnStac${stat1.id}" class="form-control" value="${item.vmpDnStac.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="col-md-1">
                                        <c:forEach items="${reportRecord1}" var="item">
                                            <c:if test="${item.idStat == stat1.id}">
                                                <input type="number" id="reabDnStac${stat1.id}" class="form-control" value="${item.reabDnStac.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="col-md-1">
                                        <c:forEach items="${reportRecord1}" var="item">
                                            <c:if test="${item.idStat == stat1.id}">
                                                <input type="number" id="smp${stat1.id}" class="form-control" value="${item.smp.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </div>

                                <c:forEach items="${stat2}" var="stat2">
                                    <c:if test="${stat2.summto == stat1.id}">
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
                                        <div id="collapseOne${stat2.id}" class="collapse col-md-12" style="padding: 15px;">
                                            <div class="row">
                                                <div class="col-md-12 text-center">
                                                    <label class="control-label">В рамках базовой программы ОМС</label>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-2 text-center">
                                                    <label class="control-label">Амбулаторная медицинская помощь</label>
                                                </div>
                                                <div class="col-md-2 text-center">
                                                    <label class="control-label">Стоматологическая помощь</label>
                                                </div>
                                                <div class="col-md-2 text-center">
                                                    <label class="control-label">Стационарная помощь</label>
                                                </div>
                                                <div class="col-md-2 text-center">
                                                    <label class="control-label">в т.ч.  ВМП</label>
                                                </div>
                                                <div class="col-md-2 text-center">
                                                    <label class="control-label">в т.ч. реабилитация</label>
                                                </div>
                                                <div class="col-md-2 text-center">
                                                    <label class="control-label">Дневной стационар</label>
                                                </div>
                                                <div class="col-md-2 text-center">
                                                    <label class="control-label">в т.ч.  ВМП</label>
                                                </div>
                                                <div class="col-md-2 text-center">
                                                    <label class="control-label">в т.ч. реабилитация</label>
                                                </div>
                                                <div class="col-md-2 text-center">
                                                    <label class="control-label">Скорая помощь</label>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-2">
                                                    <c:forEach items="${reportRecord1}" var="item">
                                                        <c:if test="${item.idStat == stat2.id}">
                                                            <input type="number" id="app${stat2.id}" class="form-control" value="${item.app.setScale(2)}" onchange="SaveKtStart(this.value,${item.id},${stat2.id}); GetSummktStart(${item.idAllReport},${stat2.id});" <c:if test="${stat2.lock||item.lock}"> readonly="true" </c:if>/>
                                                        </c:if>
                                                    </c:forEach>
                                                </div>
                                                <div class="col-md-2">
                                                    <c:forEach items="${reportRecord1}" var="item">
                                                        <c:if test="${item.idStat == stat2.id}">
                                                            <input type="number" id="stomat${stat2.id}" class="form-control" value="${item.stomat.setScale(2)}" onchange="SaveProsrochStart(this.value,${item.id}); GetSummProsrochStart(${item.idAllReport},${stat2.id});" <c:if test="${stat2.lock||item.lock}"> readonly="true" </c:if>/>
                                                        </c:if>
                                                    </c:forEach>
                                                </div>
                                                <div class="col-md-2">
                                                    <c:forEach items="${reportRecord1}" var="item">
                                                        <c:if test="${item.idStat == stat2.id}">
                                                            <input type="number" id="stat${stat2.id}" class="form-control" value="${item.stat.setScale(2)}" onchange="SaveViplacheno(this.value,${item.id},${stat2.id}); GetSummVistavleno(${item.idAllReport},${stat2.id});" <c:if test="${stat2.lock||item.lock}"> readonly="true" </c:if>/>
                                                        </c:if>
                                                    </c:forEach>
                                                </div>
                                                <div class="col-md-2">
                                                    <c:forEach items="${reportRecord1}" var="item">
                                                        <c:if test="${item.idStat == stat2.id}">
                                                            <input type="number" id="vmp${stat2.id}" class="form-control" value="${item.vmp.setScale(2)}" onchange="SaveOplacheno(this.value,${item.id},${stat2.id}); GetSummOplacheno(${item.idAllReport},${stat2.id});" <c:if test="${stat2.lock||item.lock}"> readonly="true" </c:if>/>
                                                        </c:if>
                                                    </c:forEach>
                                                </div>
                                                <div class="col-md-2">
                                                    <c:forEach items="${reportRecord1}" var="item">
                                                        <c:if test="${item.idStat == stat2.id}">
                                                            <input type="number" id="reab${stat2.id}" class="form-control" readonly="true" value="${item.reab.setScale(2)}" onchange="SaveKtEnd(this.value,${item.id}); GetSummktEnd(${item.idAllReport},${stat2.id});"/>
                                                        </c:if>
                                                    </c:forEach>
                                                </div>
                                                <div class="col-md-2">
                                                    <c:forEach items="${reportRecord1}" var="item">
                                                        <c:if test="${item.idStat == stat2.id}">
                                                            <input type="number" id="dnStac${stat2.id}" class="form-control" value="${item.dnStac.setScale(2)}" onchange="SaveProsrochEnd(this.value,${item.id}); GetSummprosrochEnd(${item.idAllReport},${stat2.id});" <c:if test="${stat2.lock||item.lock}"> readonly="true" </c:if>/>
                                                        </c:if>
                                                    </c:forEach>
                                                </div>
                                                <div class="col-md-2">
                                                    <c:forEach items="${reportRecord1}" var="item">
                                                        <c:if test="${item.idStat == stat2.id}">
                                                            <input type="number" id="vmpDnStac${stat2.id}" class="form-control" value="${item.vmpDnStac.setScale(2)}" onchange="SaveProsrochEnd(this.value,${item.id}); GetSummprosrochEnd(${item.idAllReport},${stat2.id});" <c:if test="${stat2.lock||item.lock}"> readonly="true" </c:if>/>
                                                        </c:if>
                                                    </c:forEach>
                                                </div>
                                                <div class="col-md-2">
                                                    <c:forEach items="${reportRecord1}" var="item">
                                                        <c:if test="${item.idStat == stat2.id}">
                                                            <input type="number" id="reabDnStac${stat2.id}" class="form-control" value="${item.reabDnStac.setScale(2)}" onchange="SaveProsrochEnd(this.value,${item.id}); GetSummprosrochEnd(${item.idAllReport},${stat2.id});" <c:if test="${stat2.lock||item.lock}"> readonly="true" </c:if>/>
                                                        </c:if>
                                                    </c:forEach>
                                                </div>
                                                <div class="col-md-2">
                                                    <c:forEach items="${reportRecord1}" var="item">
                                                        <c:if test="${item.idStat == stat2.id}">
                                                            <input type="number" id="smp${stat2.id}" class="form-control" value="${item.smp.setScale(2)}" onchange="SaveProsrochEnd(this.value,${item.id}); GetSummprosrochEnd(${item.idAllReport},${stat2.id});" <c:if test="${stat2.lock||item.lock}"> readonly="true" </c:if>/>
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
                </section>
                <section id="content-tabtabs3">
                    <p>
                        Здесь размещаете любое содержание....
                    </p>
                </section>
                <section id="content-tabtabs4">
                    <p>
                        Здесь размещаете любое содержание....
                    </p>
                </section>
            </div>
        </div>

    </jsp:body>

</page:template>
