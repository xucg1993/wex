<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>驾考通</title>
    <jsp:include page="../common/common_js_css.jsp" />
    <jsp:include page="../common/common_jstl.jsp"   />
</head>
<body>
<div class="weui_tab">
    <c:if test="${user.status ==1}">
        <div class="weui_cells_title">绑定教练</div>
        <div class="weui_cells_title">你还没有教练,点击绑定教练,以便更好的安排练车时间</div>
        <div class="weui_btn_area">
            <a class="weui_btn weui_btn_primary" id="showTooltips">绑定教练</a>
        </div>
    </c:if>
    <c:if test="${user.status ==2}">
        <div class="weui_cells_title">我的教练</div>
    </c:if>
<jsp:include page="../common/common_user_tab.jsp"/>
</div>
</body>
<script>
    $(function () {
        $('#showTooltips').click(function () {
            window.location.href="/wx/user/forUpdateUserBytimetab.action";
        });
    });
</script>
</html>
