<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>驾考通</title>
    <jsp:include page="jsp/common/common_js_css.jsp" />
    <jsp:include page="jsp/common/common_jstl.jsp"   />

</head>
<body>
<script>
    $(function () {
        login();
    });

    function login() {
        $.alert("用户名或密码错误，请重新登陆","警告",function () {
            window.location.href="../../login.jsp"
        });
    };
</script>
</body>

</html>
