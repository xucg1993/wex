<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>Title</title>
    <jsp:include page="../common/common_js_css.jsp"/>
    <jsp:include page="../common/common_jstl.jsp"/>
</head>
<body ontouchstart>
<div class="weui-pull-to-refresh-layer">
    <div class="pull-to-refresh-arrow"></div> <!-- 上下拉动的时候显示的箭头 -->
    <div class="pull-to-refresh-preloader"></div> <!-- 正在刷新的菊花 -->
    <div class="down">下拉刷新</div><!-- 下拉过程显示的文案 -->
    <div class="up">释放刷新</div><!-- 下拉超过50px显示的文案 -->
    <div class="refresh">正在刷新...</div><!-- 正在刷新时显示的文案 -->
</div>
<div class="weui_cells_title">学员列表</div>
<div class="weui_panel weui_panel_access">
    <div class="weui_panel_bd">
        <div id="wait-approval"></div>
    </div>
</div>

<div id="about" class="weui-popup-container popup-bottom">
    <div class="weui-popup-overlay"></div>
    <div class="weui-popup-modal">
        <div class="weui_grids">
            <a href="javascript:smsconfirm();" class="weui_grid js_grid" data-id="button">
                <div class="weui_grid_icon">
                    <img src="/weui/dist/example/images/icon_nav_dialog.png" alt="">
                </div>
                <p class="weui_grid_label">
                    发送短信
                </p>
            </a>
            <a href="javascript:;" class="weui_grid js_grid" data-id="button">
                <div class="weui_grid_icon">
                    <img src="/weui/dist/example/images/icon_nav_article.png" alt="">
                </div>
                <p class="weui_grid_label">
                    详细信息
                </p>
            </a>
            <a href="javascript:;" class="weui_grid js_grid" data-id="button">
                <div class="weui_grid_icon">
                    <img src="/weui/dist/example/images/icon_nav_button.png" alt="">
                </div>
                <p class="weui_grid_label">
                    其他选项
                </p>
            </a>
        </div>
    </div>
</div>
<script>
    $(function () {
        appendUserCoachList();
    });
    $(function () {
        $(document.body).pullToRefresh();
        $(document.body).on("pull-to-refresh", function () {
            $("#wait-approval").empty();
            appendUserCoachList();
            $(document.body).pullToRefreshDone();
        });
    });


    function appendUserCoachList() {
        $.getJSON("/wx/coach/findUserCoachList.action", function (data) {
            data.forEach(function (x) {
                var htmlStr = '';
                htmlStr += '<a href="javascript:alpopup(' + x.mobile + ',' + x.uid +');" class="weui_media_box weui_media_appmsg">';
                htmlStr += '<div class="weui_media_hd">';
                htmlStr += '<img class="weui_media_appmsg_thumb" src="/weui/dist/example/images/icon_intro.png" alt="">';
                htmlStr += '</div>';
                htmlStr += '<div class="weui_media_bd">';
                htmlStr += '<div><span id="username" class="weui_media_title">' + x.username + '</span></div>';
                htmlStr += '<span class="weui_media_desc">手机号：' + x.mobile + '</span>';
                if (x.subject1 == 1 && x.subject2 == 1 && x.subject3 == 1 && x.subject4 == 1) {
                    htmlStr += '<span class="weui_media_desc">考试进度：未考试任何科目</span>';
                }
                if (x.subject1 == 2 && x.subject2 == 1 && x.subject3 == 1 && x.subject4 == 1) {
                    htmlStr += '<span class="weui_media_desc">考试进度：科目一已通过</span>';
                }
                if (x.subject1 == 2 && x.subject2 == 2 && x.subject3 == 1 && x.subject4 == 1) {
                    htmlStr += '<span class="weui_media_desc">考试进度：科目二已通过</span>';
                }
                if (x.subject1 == 2 && x.subject2 == 2 && x.subject3 == 2 && x.subject4 == 1) {
                    htmlStr += '<span class="weui_media_desc">考试进度：科目三已通过</span>';
                }
                if (x.subject1 == 2 && x.subject2 == 2 && x.subject3 == 2 && x.subject4 == 2) {
                    htmlStr += '<span class="weui_media_desc">考试进度：已全部通过</span>';
                }
                htmlStr += '</div>';
                htmlStr += '</a>';
                $("#wait-approval").append(htmlStr);
            })
        });
    }
    ;
    var mob;
    function alpopup(mobile,uid) {
        mob = mobile;
        $("#about").popup();
    }

    function smsconfirm() {
        $.confirm({
            title: '提示',
            text: '你确定要给'+mob+'发送短信通知吗？',
            onOK: function () {
                smsuser();
            },
            onCancel: function () {

            }
        });
    }

    function smsuser() {
        $.getJSON("")
    }

</script>
</body>
</html>
