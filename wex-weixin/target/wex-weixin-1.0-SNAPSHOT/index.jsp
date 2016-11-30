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
<div class="weui_tab">
    <div class="weui_cells_title">欢迎学员:${user.username }</div>
<div class="weui_panel weui_panel_access" style="height: 100%;overflow-y: auto">
    <div class="weui_panel_hd">教练名单</div>
    <div class="weui_panel_bd">
        <c:forEach var="co" items="${coachlist }">
        <a href="javascript:void(0);" class="weui_media_box weui_media_appmsg">
            <div class="weui_media_hd">
                <img class="weui_media_appmsg_thumb" src="" alt="">
            </div>
            <div class="weui_media_bd">
                <div><span class="weui_media_title">${co.coachname}</span></div>
                <p class="weui_media_desc">${co.remark}</p>
            </div>
        </a>
        </c:forEach>
    </div>
    <%--<a class="weui_panel_ft" href="javascript:void(0);">查看更多</a>--%>
</div>
<jsp:include page="jsp/common/common_user_tab.jsp"/>
</div>
</body>
<script>
    function dd() {
        $.hideLoading();
    }
</script>
</html>
