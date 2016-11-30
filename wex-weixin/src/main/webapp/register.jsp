<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>驾考通</title>
    <jsp:include page="jsp/common/common_js_css.jsp"/>
</head>
<body>
<div class="weui_cells_title">注册页面</div>
<%--<form method="post" action="wx/user/insertUser.action">--%>
    <div class="weui_cells weui_cells_form">
        <div class="weui_cell">
            <div class="weui_cell_hd"><label class="weui-label">身份证号：</label></div>
            <div class="weui_cell_bd">
                <input class="weui_input" name="idcardno" type="text" placeholder="请输入身份证号"/>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd"><label class="weui-label">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label></div>
            <div class="weui_cell_bd">
                <input class="weui_input" name="username" type="text" placeholder="请输入真实姓名"/>
            </div>
        </div>

        <div class="weui_cell">
            <div class="weui_cell_hd"><label
                    class="weui-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label></div>
            <div class="weui_cell_bd">
                <input class="weui_input" name="password" type="password" placeholder="请输入密码"/>
            </div>
        </div>

        <div class="weui_cell">
            <div class="weui_cell_hd"><label class="weui-label">手&nbsp;&nbsp;机&nbsp;&nbsp;号：</label></div>
            <div class="weui_cell_bd">
                <input class="weui_input" name="mobile" type="text" placeholder="请输入手机号"/>
            </div>
        </div>

        <%--<div class="weui_cell">
            <div class="weui_cell_hd"><label class="weui-label">微&nbsp;&nbsp;信&nbsp;&nbsp;号：</label></div>
            <div class="weui_cell_bd">
                <input class="weui_input" type="text"  placeholder="请输入微信号"/>
            </div>
        </div>--%>

        <div class="weui_cell">
            <div class="weui_cell_hd"><label
                    class="weui-label">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</label></div>
            <div class="weui_cell_bd">
                <input class="weui_input" name="age" type="text" placeholder="请输入年龄"/>
            </div>
        </div>

        <div class="weui_cell">
            <div class="weui_cell weui_cell_select">
                <div class="weui_cell_hd">
                    <label for="" class="weui_label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
                </div>
                <div class="weui_cell_bd">
                    <select class="weui_select" id="sex">
                        <option value="0">请选择</option>
                        <option value="1">男</option>
                        <option value="2">女</option>
                    </select>
                </div>
            </div>
        </div>
    </div>
    <div class="weui_cells_tips">本系统由XXX驾校提供</div>
    <div class="weui_btn_area">
        <a class="weui_btn weui_btn_primary" id="showTooltips">注册</a>
    </div>
    <%--<input type="submit" onclick="aa()">--%>
<%--</form>--%>

<script>
    function aa() {
        alert($('input[name="idcardno"]').val());
    }

    $(function () {
        var ok1 = false;
        var ok2 = false;
        var ok3 = false;
        var ok4 = false;
        var ok5 = false;
        $('input[name="idcardno"]').change(function () {
            if ($(this).val().length == 0 || $(this).val() == null) {
                $.toast("身份证号码不能为空", "text");
            } else {
                ok1 = true;
            }
        });

        $('input[name="password"]').change(function () {
            if ($(this).val().length == 0 || $(this).val() == null) {
                $.toast("密码不能为空", "text");
            } else {
                ok2 = true;
            }
        });
        $('input[name="mobile"]').change(function () {
            if ($(this).val().length == 0 || $(this).val() == null) {
                $.toast("手机号不能为空", "text");
            } else {
                ok3 = true;
            }
        });

        $('input[name="age"]').change(function () {
            if ($(this).val().length == 0 || $(this).val() == null) {
                $.toast("年龄不能为空", "text");
            } else {
                ok4 = true;
            }
        });
        $('input[name="username"]').change(function () {
            if ($(this).val().length == 0 || $(this).val() == null) {
                $.toast("姓名不能为空", "text");
            } else {
                ok5 = true;
            }
        });

        $('#showTooltips').click(function () {
            if (ok1 && ok2 && ok3 && ok4&&ok5) {
                register();
//                $("form").attr("method","get");
//                $('form').submit();
            } else {
                $.toast("请填写注册资料", "cancel");
                return false;
            }
        });
    });

    function register() {
//        $.ajaxSettings.async = false; //设置getJson同步
        var idcar = $('input[name="idcardno"]').val();
        var userna = $('input[name="username"]').val();
        var pass = $('input[name="password"]').val();
        var mob = $('input[name="mobile"]').val();
        var ag = $('input[name="age"]').val()
        var se = $("#sex").val();
        $.getJSON('/wx/user/insertUser.action',{idcardno:idcar,username:encodeURI(userna),password:pass,mobile:mob,age:ag,
            sex:se},
                function (data) {
            if (data.status == 1) {
                dialog(data.message);
            }
            if (data.status == 2) {
                dialog(data.message);
            }
        })
//        $.ajaxSettings.async = true; //设置getJson异步
    };
    function dialog(content) {
        $.modal({
            title:"提示",
            text: content,
            buttons:[
                {text:"下一步",onClick:function () {
                    window.location.href="/wx/user/forUpdateUserBytime.action?idcardno="+$('input[name="idcardno"]').val();
                }}
            ]
        })
    }
</script>
</body>
</html>
