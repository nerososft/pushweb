<%@page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html style="padding: 0;margin: 0;">
<head>
    <title>天外天</title>
    <meta charset="UTF-8"/>
</head>
<body style="background: #F2F3F7;padding: 0;margin: 0;overflow-x: hidden;">
<div class="container-fluid" style="padding: 0;margin: 0;">
    <%--<%@include file="WEB-INF/jsp/common/header.jsp"%>--%>
    <style>
        #tg_begin:hover {
            background: #0070cc;
        }

        #tg_begin {
            background: #2277da;
        }
    </style>
    <script>
        var index = 1;
        setInterval(function () {
            if (index < 6) {
                index++;
            } else {
                index = 1;
            }
            document.getElementById("top_banner").style.transition = "all 1s";
            document.getElementById("top_banner").style.background = "url('/resources/img/banner" + index + ".jpg')";
            document.getElementById("top_banner").style.backgroundSize = "100% 35em";
        }, 5000);
        var flowup = function (oj) {
            //alert("on");

            oj.style.transition = "all 0.3s";
            oj.style.marginTop = "-0.5em";
        };
        var flowdown = function (oj) {
            //alert("down");
            oj.style.marginTop = "0em";
        };
        var gotopage = function (url) {
            window.location.href = url;
        };
        var parent_up = function (oj) {
            $(this).find("img").css("transition", "all 0.3s");
            $(this).find("img").css("margin-top", "-0.5em");
            $(this).find("div").find("p").css("color", "#00ff00");
        };
        var parent_down = function (oj) {
            $(this).find("img").css("margin-top", "0em");
            $(this).find("div").find("p").css("color", "#999");
        };
    </script>
    <div id="top_banner" class="row"
         style="height: 35em;padding: 0;margin:0;margin-top: 0;background: url('/resources/img/banner2.jpg');background-size: 100% 35em;">
        <%@include file="WEB-INF/jsp/common/top.jsp" %>
        <div class="col-md-12">
            <div class="col-md-1" style="margin: 0;padding: 0;">
                <img style="margin-top: 10em;" src="/resources/img/left.png"/>
            </div>
            <div class="col-md-10" style="padding:4em;margin:0;height:24em;">
                <p class="col-md-12" style="padding:0;margin:0;color:#fff;font-size: 3em;">天鸽 TPush</p>
                <p class="col-md-12" style="padding:0;margin:0;margin-top: 2em;font-size: 1em;color: #fff;">天鸽推送（TWT
                    Push）专业移动App推送平台。支持百亿级的通知/消息推送，将相关信息及时送达精准定向的用户，并与用户持续友好互动。大幅提升用户活跃度、留存率。</p>
                <button onclick="javascript:window.location.href='/page/myapps';" id="tg_begin"
                        style="background: #EB650C;border: none;height: 3em;width: 12em;color: #fff;font-size: 1em;margin-top: 4em;">
                    立即使用
                </button>
            </div>
            <div class="col-md-1" style="margin: 0;padding: 0;">
                <img style="margin-top: 10em;" src="/resources/img/right.png"/>
            </div>
        </div>
        <div class="col-md-12">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <p class="col-md-2" style="height:0.5em;background:#fff;"></p>
                <p class="col-md-2" style="height:0.5em;background:#fff;opacity:0.5;"></p>
                <p class="col-md-2" style="height:0.5em;background:#fff;opacity:0.5;"></p>
                <p class="col-md-2" style="height:0.5em;background:#fff;opacity:0.5;"></p>
                <p class="col-md-2" style="height:0.5em;background:#fff;opacity:0.5;"></p>
                <p class="col-md-2" style="height:0.5em;background:#fff;opacity:0.5;"></p>
            </div>
            <div class="col-md-4"></div>
        </div>
    </div>
    <div class="col-md-12"
         style="padding:0;margin: 0;background: #fff;box-shadow: 0px 4px 5px 2px #eee;padding-left: 10em;padding-right: 10em;padding-top: 2em;padding-bottom: 2em;">
        <div onmouseover="javascript:parent_up(this);" onmouseout="javascript:parent_down(this);" class="col-md-3">
            <img onmouseover="javascript:flowup(this);" onmouseout="javascript:flowdown(this);" class="col-md-5"
                 src="/resources/img/push.png"/>
            <div class="col-md-7">
                <p class="col-md-12" style="padding: 0;margin: 0;color:#999;">推送</p>
                <p class="col-md-12" style="padding: 0;margin: 0;color:#999;">即时通讯</p>
                <p class="col-md-12" style="padding: 0;margin: 0;color:#999;">云MQ</p>
            </div>
        </div>
        <div class="col-md-3" style="border-right: solid 1px #d3d3d3;border-left: solid 1px #d3d3d3;">
            <img onmouseover="javascript:flowup(this);" onmouseout="javascript:flowdown(this);" class="col-md-5"
                 src="/resources/img/db.png"/>
            <div class="col-md-7">
                <p class="col-md-12" style="padding: 0;margin: 0;color:#999;">云数据库</p>
                <p class="col-md-12" style="padding: 0;margin: 0;color:#999;">云储存redis</p>
                <p class="col-md-12" style="padding: 0;margin: 0;color:#999;">云mongoDB</p>
            </div>
        </div>
        <div class="col-md-3" style="border-right: solid 1px #d3d3d3;">
            <img onmouseover="javascript:flowup(this);" onmouseout="javascript:flowdown(this);" class="col-md-5"
                 src="/resources/img/live.png"/>
            <div class="col-md-7">
                <p class="col-md-12" style="padding: 0;margin: 0;color:#999;">点播</p>
                <p class="col-md-12" style="padding: 0;margin: 0;color:#999;">直播</p>
                <p class="col-md-12" style="padding: 0;margin: 0;color:#999;">微视频</p>
            </div>
        </div>
        <div class="col-md-3">
            <img onmouseover="javascript:flowup(this);" onmouseout="javascript:flowdown(this);" class="col-md-5"
                 src="/resources/img/monitor.png"/>
            <div class="col-md-7">
                <p class="col-md-12" style="padding: 0;margin: 0;color:#999;">云监控</p>
                <p class="col-md-12" style="padding: 0;margin: 0;color:#999;">云日志</p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="col-md-12" id="tip"></div>
            <div class="col-md-12" id="apps_container">
                <div style="padding: 0;margin: 0;margin-top: 2em;" class="col-md-12">
                    <div class="col-md-3" style="padding: 1em;margin: 0;">
                        <center>
                            <img onmouseover="javascript:flowup(this);" onmouseout="javascript:flowdown(this);"
                                 style="box-shadow: 0px 0px 5px 2px #ddd;background: #fff;" class="col-md-12"
                                 src="/resources/img/1.png"/>
                            <p style="margin-top: 1em;" class="col-md-12"><strong>极速接入</strong></p>

                            <p class="col-md-12">10分钟极速接入推送服务，与数亿移动智能终端建立稳定的长连接</p>
                        </center>
                    </div>
                    <div class="col-md-3" style="padding: 1em;margin: 0;">
                        <center>
                            <img onmouseover="javascript:flowup(this);" onmouseout="javascript:flowdown(this);"
                                 style="box-shadow: 0px 0px 5px 2px #ddd;background: #fff;" class="col-md-12"
                                 src="/resources/img/2.png"/>
                            <p style="margin-top: 1em;" class="col-md-12"><strong>精准触达</strong></p>

                            <p class="col-md-12">多维度传递价值信息，每天可发送百亿级的通知/消息，精确抵达目标用户</p>
                        </center>
                    </div>
                    <div class="col-md-3" style="padding: 1em;margin: 0;">
                        <center>
                            <img onmouseover="javascript:flowup(this);" onmouseout="javascript:flowdown(this);"
                                 style="box-shadow: 0px 0px 5px 2px #ddd;background: #fff;" class="col-md-12"
                                 src="/resources/img/3.png"/>
                            <p style="margin-top: 1em;" class="col-md-12"><strong>接口灵活</strong></p>

                            <p class="col-md-12">开放推送能力，提供多种语言API，包括Java/PHP等，业务自由集成</p>
                        </center>
                    </div>
                    <div class="col-md-3" style="padding: 1em;margin: 0;">
                        <center>
                            <img onmouseover="javascript:flowup(this);" onmouseout="javascript:flowdown(this);"
                                 style="box-shadow: 0px 0px 5px 2px #ddd;background: #fff;" class="col-md-12"
                                 src="/resources/img/4.png"/>
                            <p style="margin-top: 1em;" class="col-md-12"><strong>全面监控</strong></p>

                            <p class="col-md-12">实时监控通知/消息的抵达用户量、转化量、转化率，推送效果一目了然</p>
                        </center>
                    </div>
                </div>

                <div style="padding: 0;margin: 0;" class="col-md-12">
                    <div class="col-md-3" style="padding: 1em;margin: 0;">
                        <center>
                            <div style="padding:1.5em; width:10em;height:10em;border-radius: 10em;border: solid 1px #ddd;background: #fff;padding-top:2.5em;">
                                <img onmouseover="javascript:flowup(this);" onmouseout="javascript:flowdown(this);"
                                     style="background: #fff;" class="col-md-12" src="/resources/img/5.png"/>
                            </div>
                            <p style="margin-top: 1em;" class="col-md-12"><strong>自定义推送通知</strong></p>

                            <p class="col-md-12">提供自定义通知、消息推送平台，您可以通过管理台或接口操作，将价值信息无延时的推送给目标用户并支持多种展现提示方。</p>
                        </center>
                    </div>
                    <div class="col-md-3" style="padding: 1em;margin: 0;">
                        <center>
                            <div style="padding:1.5em; width:10em;height:10em;border-radius: 10em;border: solid 1px #ddd;background: #fff;padding-top:2.5em;">
                                <img onmouseover="javascript:flowup(this);" onmouseout="javascript:flowdown(this);"
                                     style="background: #fff;" class="col-md-12" src="/resources/img/6.png"/>
                            </div>
                            <p style="margin-top: 1em;" class="col-md-12"><strong>细分目标用户</strong></p>

                            <p class="col-md-12">精细化目标用户分类，为目标用户打上画像标签，不论地理位置、是否活跃用户，还是各个版本用户均能准确定位。</p>
                        </center>
                    </div>
                    <div class="col-md-3" style="padding: 1em;margin: 0;">
                        <center>
                            <div style="padding:1.5em; width:10em;height:10em;border-radius: 10em;border: solid 1px #ddd;background: #fff;padding-top:2.5em;">
                                <img onmouseover="javascript:flowup(this);" onmouseout="javascript:flowdown(this);"
                                     style="background: #fff;" class="col-md-12" src="/resources/img/7.png"/>
                            </div>
                            <p style="margin-top: 1em;" class="col-md-12"><strong>运营数据全面监控</strong></p>

                            <p class="col-md-12">推送完成后，可及时查看推送效果，推送量、抵达量、点击量等关键运营数据一目了然，为您的运营提供充分数据支撑。</p>
                        </center>
                    </div>
                    <div class="col-md-3" style="padding: 1em;margin: 0;">
                        <center>
                            <div style="padding:1.5em; width:10em;height:10em;border-radius: 10em;border: solid 1px #ddd;background: #fff;padding-top:2.5em;">
                                <img onmouseover="javascript:flowup(this);" onmouseout="javascript:flowdown(this);"
                                     style="background: #fff;" class="col-md-12" src="/resources/img/8.png"/>
                            </div>
                            <p style="margin-top: 1em;" class="col-md-12"><strong>灵活的服务端接口</strong></p>
                            <p class="col-md-12">
                                支持多种推送接口，包括全量、单个、批量推送等。方便业务结合自身需求灵活调用。提供Java、PHP、Python、Node.js等多种SDK，方便开发者使用。</p>
                        </center>
                    </div>
                </div>

            </div>
        </div>
        <div class="col-md-1">

        </div>
    </div>
    <%@include file="WEB-INF/jsp/common/footer.jsp" %>
</div>
</body>
<script src="/resources/script/developer.js" type="text/javascript"></script>
<script src="/resources/script/app.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/script/jquery.cookie.js"></script>
<script type="text/javascript">
    $(function () {
        developer.auth();
    });
</script>
</html>