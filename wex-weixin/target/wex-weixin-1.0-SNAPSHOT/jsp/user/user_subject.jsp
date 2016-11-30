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
    <div class="weui_cells_title">欢迎学员:${user.username }</div>
    <div class="weui_cells">
        <div class="weui_cell">
            <div class="weui_cell_bd weui_cell_primary">
                <p>科目一</p>
            </div>
            <div class="weui_cell_ft">
                <c:if test="${user.subject1==1}">
                    未通过
                </c:if>
                <c:if test="${user.subject1==2}">
                    通过
                </c:if>
            </div>
        </div>
    </div>
    <div class="weui_cells">
        <div class="weui_cell">
            <div class="weui_cell_bd weui_cell_primary">
                <p>科目二</p>
            </div>
            <div class="weui_cell_ft">
                <c:if test="${user.subject2==1}">
                    未通过
                </c:if>
                <c:if test="${user.subject2==2}">
                    通过
                </c:if>
            </div>
        </div>
    </div>
    <div class="weui_cells">
        <div class="weui_cell">
            <div class="weui_cell_bd weui_cell_primary">
                <p>科目三</p>
            </div>
            <div class="weui_cell_ft">
                <c:if test="${user.subject3==1}">
                    未通过
                </c:if>
                <c:if test="${user.subject3==2}">
                    通过
                </c:if>
            </div>
        </div>
    </div>
    <div class="weui_cells">
        <div class="weui_cell">
            <div class="weui_cell_bd weui_cell_primary">
                <p>科目四</p>
            </div>
            <div class="weui_cell_ft">
                <c:if test="${user.subject4==1}">
                    未通过
                </c:if>
                <c:if test="${user.subject4==2}">
                    通过
                </c:if>
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
