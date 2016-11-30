<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>驾考通</title>
    <jsp:include page="../../jsp/common/common_js_css.jsp" />
    <jsp:include page="../../jsp/common/common_jstl.jsp"   />
</head>
<body>
<div class="weui_tab">
    <div class="weui_cells_title">个人资料</div>
    <div class="weui_cells">
        <div class="weui_cell">
            <div class="weui_cell_bd weui_cell_primary">
                <p>姓名</p>
            </div>
            <div class="weui_cell_ft">
                ${user.username }
            </div>
        </div>
    </div>
    <div class="weui_cells">
        <div class="weui_cell">
            <div class="weui_cell_bd weui_cell_primary">
                <p>身份证号</p>
            </div>
            <div class="weui_cell_ft">
                ${user.idcardno }
            </div>
        </div>
    </div>

<div class="weui_cells">
        <div class="weui_cell">
            <div class="weui_cell_bd weui_cell_primary">
                <p>手机号</p>
            </div>
            <div class="weui_cell_ft">
                ${user.mobile }
            </div>
        </div>
    </div>

<div class="weui_cells">
        <div class="weui_cell">
            <div class="weui_cell_bd weui_cell_primary">
                <p>微信</p>
            </div>
            <div class="weui_cell_ft">
                ${user.weixin }
            </div>
        </div>
    </div>

<div class="weui_cells">
        <div class="weui_cell">
            <div class="weui_cell_bd weui_cell_primary">
                <p>性别</p>
            </div>
            <div class="weui_cell_ft">
                ${user.sex==1?"男":"女" }
            </div>
        </div>
    </div>
    <div class="weui_cells">
        <div class="weui_cell">
            <div class="weui_cell_bd weui_cell_primary">
                <p>年龄</p>
            </div>
            <div class="weui_cell_ft">
                ${user.age }
            </div>
        </div>
    </div>
    <div class="weui_cells">
        <div class="weui_cell">
            <div class="weui_cell_bd weui_cell_primary">
                <p>报名日期</p>
            </div>
            <div class="weui_cell_ft">
                ${user.formatEntrydate }
            </div>
        </div>
    </div>

<jsp:include page="../common/common_user_tab.jsp"/>
</div>
</body>
<script>
    function dd() {
        $.hideLoading();
    }
</script>
</html>
