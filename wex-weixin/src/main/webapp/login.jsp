<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>驾考通</title>
    <jsp:include page="jsp/common/common_js_css.jsp" />
</head>
<body>
<div class="weui_cells_title">欢迎登陆</div>
<form method="post" action="wx/user/userLogin.action" >
<div class="weui_cells weui-cells_form">
    <div class="weui_cell">
        <div class="weui_cell__hd"><label class="weui-label">身份证号：</label></div>
        <div class="weui_cell__bd weui_cell_primary">
            <input class="weui_input" name="idcardno" type="number"   placeholder="请输入身份证号"/>
        </div>
    </div>

    <div class="weui_cell">
        <div class="weui_cell__hd"><label class="weui-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label></div>
        <div class="weui_cell__bd weui_cell_primary" >
            <input class="weui_input" name="password" type="password"  placeholder="请输入密码"/>
        </div>
    </div>

</div>
<div class="weui_cells_tips">本系统由XXX驾校提供</div>

    <div class="weui_btn_area">
        <a class="weui_btn weui_btn_primary"   id="showTooltips">登录</a>
    </div>
</form>
<div class="weui_cells weui_cells_access">
    <a class="weui_cell" href="wx/user/forInsertUser.action">
        <div class="weui_cell_bd weui_cell_primary">
            <p>没有账号？</p>
        </div>
        <div class="weui_cell_ft">
            立即注册
        </div>
    </a>
</div>
<script >
    $(function () {
        var ok1=false;
        var ok2=false;
        $('input[name="idcardno"]').change(function () {
            if ($(this).val().length==0||$(this).val()==null){
                $.toast("身份证号码不能为空","text");
            }else {
                ok1=true;
            }
        });

        $('input[name="password"]').change(function () {
           if ($(this).val().length==0||$(this).val()==null){
                $.toast("密码不能为空","text");
           }else {
               ok2=true;
           }
        });
        $('#showTooltips').click(function () {
            if (ok1&&ok2){
                $.showLoading("正在登录...");
                $('form').submit();
            }else {
                $.toast("请填写账号和密码","cancel");
                return false;
            }
        });
    });
</script>

</body>
</html>
