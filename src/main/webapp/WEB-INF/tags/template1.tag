<!DOCTYPE html>
<%@tag description="Template Site tag" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@attribute name="title" fragment="true" %>
<html>
<head>
    <title><jsp:invoke fragment="title"/></title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="/resources/css/jquery.treeview.css" rel="stylesheet"/>
    <link href="/resources/css/templatemo_misc.css" rel="stylesheet">
    <link href="/resources/css/templatemo_style.css" rel="stylesheet">
    <link href="/resources/css/tabs.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100,600' rel='stylesheet' type='text/css'>

    <script src="/resources/js/jquery-1.10.2.min.js"></script>
    <script src="/resources/js/jquery.lightbox.js"></script>
    <script src="/resources/js/templatemo_custom.js"></script>
    <script src="/resources/js/bootstrap.js"></script>
    <script src="/resources/js/Ej.js"></script>
    <script src="/resources/js/jquery.cookie.js"></script>
    <script src="<c:url value="/resources/js/jquery.treeview.js"/>"></script>

</head>
<body>
<div class="site-header">
    <div class="main-navigation">
        <div class="container">
            <div class="row templatemo_gallerygap">
                <div class="col-md-12 responsive-menu">
                    <a href="#" class="menu-toggle-btn">
                        <i class="fa fa-bars"></i>
                    </a>
                </div> <!-- /.col-md-12 -->
                <div class="col-md-3 col-sm-12">
                    <a href="http://тфомсбрк.рф"><img src="/resources/images/templatemo_logo.jpg" alt="ТФОМС Брянской области"></a>
                </div>
                <div class="col-md-9 main_menu">
                    <ul>
                        <li><a href="/">
                            <span class="fa fa-camera"></span>
                            Ежедневные отчеты</a></li>
                        <li><a href="/monthly">
                            <span class="fa fa-users"></span>
                            Ежемесячные отчеты</a></li>
                        <li><a href="/settings">
                            <span class="fa fa-cogs"></span>
                            Настройки</a></li>
                        <li><a class="show-5 templatemo_page5" href="#">
                            <span class="fa fa-envelope"></span>
                            Справка</a></li>
                    </ul>
                </div> <!-- /.col-md-12 -->
            </div> <!-- /.row -->
        </div> <!-- /.container -->
    </div> <!-- /.main-navigation -->
</div> <!-- /.site-header -->
<div class="container">
            <jsp:doBody/>
</div>
<!-- footer start -->
<div class="templatemo_footer">
    <div class="container">
        <div class="row">
            <div class="col-md-9 col-sm-12">
                <span>Copyright &copy; 2018 ТФОМС Брянской области </span>
            </div>
        </div>
    </div>
</div>
<!-- footer end -->
</body>
</html>