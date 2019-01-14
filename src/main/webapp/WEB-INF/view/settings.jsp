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

        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-md-4">
                        <label class="control-label">Информация о МО</label>
                    </div>
                    <div class="col-md-8 text-right">
                        <a data-toggle="collapse" data-parent="#collapseOne" href="#collapseOne">
                            <i class="fa fa-pencil"> Редактировать</i>
                        </a>
                    </div>
                </div>
            </div>
        <div id="collapseOne" class="collapse">
            <div class="panel-body">
                <form:form class="col-md-8" modelAttribute="mo" action="/settings" method="post">
                    <div class="form-group row">
                        <label for="MOname" class="control-label">Полное наименование МО</label>
                        <form:input type="text" class="form-control" id="MOname" path="name"/>
                    </div>
                    <div class="form-group row">
                        <label for="shortName" class="control-label">Краткое наименование</label>
                        <form:input type="text" class="form-control" id="shortName" path="shortName"/>
                    </div>
                    <div class="form-group row">
                        <label for="address" class="control-label">Адрес МО</label>
                        <form:input type="text" class="form-control" id="address" path="address" />
                    </div>
                    <div class="form-group row">
                        <label for="fiodir" class="control-label">ФИО руководителя</label>
                        <form:input type="text" class="form-control" id="fiodir" path="fioDir" />
                    </div>
                    <div class="form-group row">
                        <label for="fiobuh" class="control-label">ФИО бухгалтера</label>
                        <form:input type="text" class="form-control" id="fiobuh" path="fioBuh" />
                    </div>
                    <div class="form-group row">
                        <button type="submit" class="btn btn-primary">Сохранить</button>
                    </div>
                </form:form>
            </div>
        </div>
        </div>


    </jsp:body>

</page:template>