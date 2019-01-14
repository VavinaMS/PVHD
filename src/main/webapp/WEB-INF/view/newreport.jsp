<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<page:template>

    <jsp:attribute name="title">ТФОМС Брянской области - ПВХД</jsp:attribute>

    <jsp:body>
        <form:form class="col-md-8" action="/newreport" modelAttribute="resultObject" method="post">
            <div class="form-group row">
                <label for="dtStart" class="control-label">Дата начала</label>
                <form:input type="date" class="form-control" id="dtStart" path="dtStart" />
            </div>
            <div class="form-group row">
                <label for="dtEnd" class="control-label">Дата окончания</label>
                <form:input type="date" class="form-control" id="dtEnd" path="dtEnd" />
            </div>
            <div class="form-group row">
                <button type="submit" class="btn btn-primary">Сохранить</button>
            </div>
        </form:form>
    </jsp:body>

</page:template>
