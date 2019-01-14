<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>ТФОМС Брянской области - ПВХД</title>
    <link rel="stylesheet" href="/resources/css/reset.css">
    <link rel="stylesheet" href="/resources/css/animate.css">
    <link rel="stylesheet" href="/resources/css/styles.css">
</head>
<body>

<div id="container">
    <form name= "form" action= "<c:url value='/j_spring_security_check' />" method= "post">
        <security:authorize access= "hasAnyRole('ROLE_ADMIN','ROLE_SUPER_USER', 'ROLE_USER')" var= "isUSer"/>
        <label>Логин:</label>
        <input type="name" name="username"/>
        <label>Пароль:</label>
        <input type="password" name="password"/>
        <c:if test="${param.error != null}">
            <p><a>Проверьте правильность ввода логина и пароля.</a></p>
        </c:if>
        <div id="lower">
            <input type= "checkbox" id= "rememberme"  name= "_spring_security_remember_me"/><label class="check">Запомнить меня</label>
            <input type="submit" value="Войти">
        </div>
    </form>
</div>
</body>
</html>


