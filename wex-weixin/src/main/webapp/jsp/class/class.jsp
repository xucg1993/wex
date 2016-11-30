<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>驾考通</title>
    <jsp:include page="../../jsp/common/common_js_css.jsp" />
</head>
<body>
<div class="weui_cells_title">绑定教练和班型</div>
<div class="weui_cells weui_cells_form">
    <input type="hidden" name="idcardno" value="${idno}" />
    <div class="weui_cell">
    <div class="weui_cell weui_cell_select">
        <div class="weui_cell_hd">
            <label for="" class="weui_label">教&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;练：</label>
        </div>
        <div class="weui_cell_bd">
            <select class="weui_select" id="cid">
                <option value="0">请选择</option>
                <c:forEach var="coa" items="${clist}">
                    <option value="${coa.cid}">${coa.coachname}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_hd"><label for="" class="weui_label">报名日期：</label></div>
        <div class="weui_cell_bd weui_cell_primary">
            <input class="weui_input" name="time" type="date" value="">
        </div>
    </div>

    <div class="weui_cell">
        <div class="weui_cell weui_cell_select weui-cell_select-after">
            <div class="weui_cell_hd">
                <label for="" class="weui_label">班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型：</label>
            </div>
            <div class="weui_cell_bd">
                <select class="weui_select" id="tid">
                    <option value="0">请选择</option>
                    <c:forEach var="te" items="${tlist}">
                        <option value="${te.tid}">${te.teamname}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    </div>
</div>
<div class="weui_btn_area">
    <a class="weui_btn weui_btn_primary"  id="showTooltips">绑定</a>
</div>
<div class="weui_btn_area">
    <a class="weui_btn weui_btn_primary" href="../../login.jsp" id="show">未报名，跳过</a>
</div>

<script>

    $(function () {
        var ok1 = false;
        var ok2 = false;
        var ok3 = false;
        $("#cid").change(function () {
            if ($(this).val() == 0) {
                $.toast("请选择教练", "text");
            } else {
                ok1 = true;
            }
        });

        $('input[name="time"]').change(function () {
            if ($(this).val().length == 0 || $(this).val() == null) {
                $.toast("请选择时间", "text");
            } else {
                ok2 = true;
            }
        });
        $("#tid").change(function () {
            if ($(this).val() == 0) {
                $.toast("请选择班型", "text");
            } else {
                ok3 = true;
            }
        });
        $('#showTooltips').click(function () {
            if (ok1 && ok2 && ok3) {
                reget();
//                $('form').submit();
            } else {
                $.toast("请填写完整", "cancel");
                return false;
            }
        });
    });
    function reget() {
        $.ajaxSettings.async = false; //设置getJson同步
        $.getJSON('updateUserBytime.action',{idcardno:$('input[name="idcardno"]').val(),cid:$("#cid").val(),time:$('input[name="time"]').val(),tid:$("#tid").val()}, function (data) {
            if (data.status == 1) {
                dialog(data.message);
            }
            if (data.status == 2) {
                dialog2(data.message);
            }
        })
        $.ajaxSettings.async = true; //设置getJson异步
    };
    function dialog(content) {
        $.modal({
            title:"提示",
            text: content,
            buttons:[
                {text: "取消", className: "default", onClick: function(){ console.log(3)} },
                {text:"去登陆",onClick:function () {
                    window.location.href="../../login.jsp"
                }}
            ]
        })
    };
    function dialog2(content) {
        $.modal({
            title:"提示",
            text: content,
            buttons:[
                {text:"重新绑定",onClick:function () {
                    window.location.reload();
                }},
                { text: "取消", className: "default", onClick: function(){ console.log(3)} },
            ]
        })
    };

</script>
</body>
</html>
