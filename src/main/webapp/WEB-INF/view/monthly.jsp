<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<page:template>

    <jsp:attribute name="title">ТФОМС Брянской области - ПВХД</jsp:attribute>
    <jsp:attribute name="pageName">Ежемесячные отчеты</jsp:attribute>
    <jsp:attribute name="nameUser">${nameUser}</jsp:attribute>
    <jsp:attribute name="nameMO">${nameMO}</jsp:attribute>

    <jsp:body>
        <!--Список отчетов-->
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
                    <table id="table10" class="table10" cellspacing="0" width="100%">
                        <thead>
                        <tr>
                            <th>Наименование показателя</th>
                            <th>Величина показателя</th>
                        </tr>
                        </thead>
                        <c:forEach items="${stat}" var="stat">
                            <tr>
                                <td><label class="control-label"><c:out value="${stat.name}"/></label></td>
                                <td>
                                    <c:forEach items="${reportRecord}" var="item">
                                        <c:if test="${item.idStat == stat.id}">
                                            <input type="number" id="value${stat.id}" class="form-control" value="<c:out value="${item.val.setScale(2)}"/>" <c:if test="${stat.lock||item.lock}"> readonly="true" </c:if>/>
                                        </c:if>
                                    </c:forEach>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </section>
                <section id="content-tabtabs2">
                    <table id="Nach" cellspacing="0" width="100%">
                        <thead>
                        <tr>
                            <th>Наименование показателя</th>
                            <th>Амбулаторная медицинская помощь</th>
                            <th>Стомат. помощь</th>
                            <th>Стационарная помощь всего</th>
                            <th>в т.ч.  ВМП</th>
                            <th>в т.ч. реабилитация</th>
                            <th>Дневной стационар  всего</th>
                            <th> в т.ч.  ВМП</th>
                            <th>в т.ч. реабилитация</th>
                            <th>Скорая помощь</th>
                        </tr>
                        </thead>
                        <c:forEach items="${stat1}" var="stat1">
                            <tr>
                                <td><label class="control-label"><c:out value="${stat1.name}"/></label></td>
                                <td>
                                    <c:forEach items="${reportRecord1}" var="item">
                                        <c:if test="${item.idStat == stat1.id}">
                                            <input type="number" id="APP${stat1.id}" class="form-control" value="${item.app.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach items="${reportRecord1}" var="item">
                                        <c:if test="${item.idStat == stat1.id}">
                                            <input type="number" id="Stomat${stat1.id}" class="form-control" value="${item.stomat.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach items="${reportRecord1}" var="item">
                                        <c:if test="${item.idStat == stat1.id}">
                                            <input type="number" id="Stac${stat1.id}" class="form-control" value="${item.stat.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach items="${reportRecord1}" var="item">
                                        <c:if test="${item.idStat == stat1.id}">
                                            <input type="number" id="VMP${stat1.id}" class="form-control" value="${item.vmp.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach items="${reportRecord1}" var="item">
                                        <c:if test="${item.idStat == stat1.id}">
                                            <input type="number" id="Reab${stat1.id}" class="form-control" value="${item.reab.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach items="${reportRecord1}" var="item">
                                        <c:if test="${item.idStat == stat1.id}">
                                            <input type="number" id="DnStac${stat1.id}" class="form-control" value="${item.dnStac.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach items="${reportRecord1}" var="item">
                                        <c:if test="${item.idStat == stat1.id}">
                                            <input type="number" id="vmpDnStac${stat1.id}" class="form-control" value="${item.vmpDnStac.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach items="${reportRecord1}" var="item">
                                        <c:if test="${item.idStat == stat1.id}">
                                            <input type="number" id="reabDnStac${stat1.id}" class="form-control" value="${item.reabDnStac.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach items="${reportRecord1}" var="item">
                                        <c:if test="${item.idStat == stat1.id}">
                                            <input type="number" id="smp${stat1.id}" class="form-control" value="${item.smp.setScale(2)}" onchange="" <c:if test="${stat1.lock||item.lock}"> readonly="true" </c:if>/>
                                        </c:if>
                                    </c:forEach>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </section>
            </div>
        </div>
        </div>
    </jsp:body>

</page:template>
