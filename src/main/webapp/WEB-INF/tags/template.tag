<!DOCTYPE html>
<%@tag description="Template Site tag" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@attribute name="title" fragment="true" %>
<%@attribute name="nameUser" fragment="true" %>
<%@attribute name="nameMO" fragment="true" %>
<%@attribute name="pageName" fragment="true" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../images/favicon.ico">

    <title><jsp:invoke fragment="title"/></title>

    <!-- Bootstrap 4.0-->
    <link rel="stylesheet" href="/resources/css/bootstrap.css">

    <!-- Bootstrap extend-->
    <link rel="stylesheet" href="/resources/css/bootstrap-extend.css">

    <!-- theme style -->
    <link rel="stylesheet" href="/resources/css/master_style.css">

    <!-- Superieur Admin skins -->
    <link rel="stylesheet" href="/resources/css/skins/_all-skins.css">

    <!-- daterange picker -->
    <link rel="stylesheet" href="/resources/css/daterangepicker.css">

    <!-- Morris charts -->
    <link rel="stylesheet" href="/resources/css/morris.css">

    <!-- Data Table-->
    <link rel="stylesheet" type="text/css" href="/resources/css/datatables.min.css"/>
    <link href="/resources/css/tabs.css" rel="stylesheet">


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->
        <a href="index.html" class="logo">
            <!-- mini logo -->
            <div class="logo-mini">
                <span class="light-logo"><img src="/resources/images/logo.png" alt="logo"></span>
                <span class="dark-logo"><img src="/resources/images/logo.png" alt="logo"></span>
            </div>
            <!-- logo-->
            <div class="logo-lg">
                <span class="light-logo"><img src="/resources/images/logo-text-light.png" alt="logo"></span>
                <span class="dark-logo"><img src="/resources/images/logo-text.png" alt="logo"></span>
            </div>
        </a>
        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top">

        </nav>
    </header>

    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar-->
        <section class="sidebar">

            <!-- sidebar menu-->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="user-profile treeview">
                    <a href="index.html">
                        <img src="/resources/images/avatar.jpg" alt="user">
                        <span>
				            <span class="d-block font-weight-600 font-size-16"><jsp:invoke fragment="nameUser"/></span>
				            <span class="email-id"><jsp:invoke fragment="nameMO"/></span>
			            </span>
                    </a>
                </li>
                <li class="header nav-small-cap"><i class="mdi mdi-drag-horizontal mr-5"></i>Отчеты</li>

                <li class="treeview active">
                    <a href="#">
                        <i class="mdi mdi-view-dashboard"></i>
                        <span>Еженежельные отчеты</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-right pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li class="active"><a href="/"><i class="mdi mdi-toggle-switch-off"></i>Просмотр</a></li>
                        <li><a href="/newreport"><i class="mdi mdi-toggle-switch-off"></i>Открыть период</a></li>
                        <li><a href="/"><i class="mdi mdi-toggle-switch-off"></i>Экспорт</a></li>
                        <li><a href="/"><i class="mdi mdi-toggle-switch-off"></i>Импорт</a></li>
                    </ul>
                </li>

                <li class="treeview active">
                    <a href="#">
                        <i class="mdi mdi-content-copy"></i>
                        <span>Ежемесячные отчеты</span>
                        <span class="pull-right-container">
                        <i class="fa fa-angle-right pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/monthly"><i class="mdi mdi-toggle-switch-off"></i>Просмотр</a></li>
                        <li><a href="/newreport-monthly"><i class="mdi mdi-toggle-switch-off"></i>Открыть период</a></li>
                        <li><a href="/"><i class="mdi mdi-toggle-switch-off"></i>Экспорт</a></li>
                        <li><a href="/"><i class="mdi mdi-toggle-switch-off"></i>Импорт</a></li>
                    </ul>
                </li>

                <li>
                    <a href="/">
                        <i class="mdi mdi-directions"></i>
                        <span>Выход</span>
                    </a>
                </li>

            </ul>
        </section>
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="d-flex align-items-center">
                <div class="mr-auto">
                    <h3 class="page-title"><jsp:invoke fragment="pageName"/></h3>
                    <div class="d-inline-block align-items-center">
                        <nav>
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="#"><i class="mdi mdi-home-outline"></i></a></li>
                                <li class="breadcrumb-item active" aria-current="page">На главную</li>
                            </ol>
                        </nav>
                    </div>
                </div>
                <div class="right-title w-170">

                </div>
            </div>
        </div>

        <!-- Main content -->
        <section class="content">
            <jsp:doBody/>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="pull-right d-none d-sm-inline-block">
            <ul class="nav nav-primary nav-dotted nav-dot-separated justify-content-center justify-content-md-end">
                <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0)">Помощь</a>
                </li>
            </ul>
        </div>
        &copy; 2018 <a href="http://xn--90asehmeeq.xn--p1ai/">ТФОМС Брянской области</a>.
    </footer>
</div>
<!-- ./wrapper -->



<!-- jQuery 3 -->
<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/jquery-3.3.1.js"></script>
<script src="/resources/js/jquery.lightbox.js"></script>

<!-- jQuery UI 1.11.4 -->
<script src="/resources/js/jquery-ui.js"></script>

<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>

<!-- popper -->
<script src="/resources/js/popper.min.js"></script>

<!-- date-range-picker -->
<script src="/resources/js/daterangepicker.js"></script>

<!-- Bootstrap 4.0-->
<script src="/resources/js/bootstrap.js"></script>

<!-- ChartJS -->
<script src="/resources/js/Chart.min.js"></script>

<!-- Slimscroll -->
<script src="/resources/js/jquery.slimscroll.js"></script>

<!-- FastClick -->
<script src="/resources/js/fastclick.js"></script>

<!-- Morris.js charts -->
<script src="/resources/js/raphael.min.js"></script>
<script src="/resources/js/morris.min.js"></script>

<!-- This is data table -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">

<script src="/resources/js/Ej.js"></script>
<script src="/resources/js/tbl.js"></script>
<script src="/resources/js/jquery.cookie.js"></script>
<script src="/resources/js/jquery.treeview.js"></script>

</body>
</html>
