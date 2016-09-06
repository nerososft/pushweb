<%@page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>TWTpush - app</title>
</head>
<body style="background: #F2F3F7;">
<style>
    @-webkit-keyframes repire_cog{
        0%{ transform:rotate(0deg); }
        100%{ transform:rotate(-360deg); }
    }
</style>
<div class="container-fluid">
    <%@include file="common/header.jsp"%>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="col-md-12" style="padding-left: 0em;padding-right: 4em;">

            <div class="col-md-12"  style="margin-left:1em;">
                <div class="col-md-12" style="padding: 0;margin: 0;">
                        <span style="color: #EB650C;" class="glyphicon glyphicon-chevron-left"></span><a style="color: #EB650C;text-decoration: none;" href="/"><strong>AllApps</strong></a>
                </div>
                    <%--<div class="col-md-2" style="padding: 0;margin: 0;">--%>
                        <%--<button style="background: #EB650C;border: none;padding: 0.2em;color:#F2F3F7;margin: 0;" class="col-md-12">Change App Name</button>--%>
                    <%--</div>--%>
                    <%--<div  class="col-md-2" style="padding: 0;margin: 0;">--%>
                        <%--<button style="background: #EB650C;border: none;padding: 0.2em;color:#F2F3F7;margin: 0;" class="col-md-12">Reset App Key</button>--%>
                    <%--</div>--%>
                    <%--<div  class="col-md-2" style="padding: 0;margin: 0;">--%>
                        <%--<button style="background: #EB650C;border: none;padding: 0.2em;color:#F2F3F7;margin: 0;" class="col-md-12">Reset App SecretKey</button>--%>
                    <%--</div>--%>
                    <%--<div  class="col-md-2" style="padding: 0;margin: 0;">--%>
                        <%--<button style="background: #EB650C;border: none;padding: 0.2em;color:#F2F3F7;margin: 0;" class="col-md-12">Delete App</button>--%>
                    <%--</div>--%>
            </div>
            </div>
            <div class="col-md-12" id="apps_container">
                <div class="col-md-4" style="padding: 0;margin: 0;">
                <div class="col-md-12">
                    <div id="app_info" class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 1px  2px #eee;margin-top: 1em;border-radius: 1px;'>
                        app info
                    </div>
                    <div id="policy" class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 1px  2px #eee;margin-top: 1em;border-radius: 1px;'>
                        <strong class='col-md-12'>推送策略</strong><hr>
                        <a href="javascript:policy.View.addpolicy();"><span class="col-md-12 glyphicon glyphicon-plus">新建策略</span></a>
                    </div>
                    <div id="node_info" class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 1px  2px #eee;margin-top: 1em;border-radius: 1px;'>
                        node info
                    </div>
                    <div id="app_connect" class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 1px  2px #eee;margin-top: 1em;border-radius: 1px;'>
                        <strong>CONNECTIONS</strong><hr>

                        <table id="app_connect_table" class="col-md-12">
                            <tr class="col-md-12"><td class="col-md-2">Id</td><td class="col-md-10">Label</td></tr>
                        </table>
                    </div>
                    <div id="app_device" class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 1px  2px #eee;margin-top: 1em;border-radius: 1px;'>
                        app device
                    </div>

                </div>
                </div>
                <div class="col-md-8" style="padding: 0;margin: 0;">
                    <div class="col-md-12">
                        <div class="col-md-12" style="padding:1em;background: #FFF;box-shadow: 0px 0px 1px  2px #eee;margin-top: 1em;border-radius: 1px;">
                            <p id="broker_tip"></p>
                        </div>
                    <div id="virtualhost_info"  class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 1px  2px #eee;margin-top: 1em;border-radius: 1px;'>
                        virtualhost
                    </div>
                    <div id="broker_info"  class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 1px  2px #eee;margin-top: 1em;border-radius: 1px;'>
                            broker info
                    </div>
                    <div id="jvm_info" class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 1px  2px #eee;margin-top: 1em;border-radius: 1px;'>
                            jvm info
                    </div>
                    <div id="msg_histroy" class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 1px  2px #eee;margin-top: 1em;border-radius: 1px;'>
                            msg histroy
                    </div>
                </div>
                    </div>
            </div>
        </div>

        <div class="col-md-1">

        </div>
    </div>
</div>
</body>
<script src ="/resources/script/policy.js" type="text/javascript"></script>
<script src="/resources/script/developer.js" type="text/javascript"></script>
<script src="/resources/script/app.js" type="text/javascript"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript">

    $(function () {
        developer.auth();
        var id = window.location.href.substr(window.location.href.indexOf("/app/")+5);
        console.log("id={}",id);
        app.find.app(id);
        $(".app").mouseover(function () {
            $(this).find("img").css("background","#000,");
            alert("ss");
        });
        $(".app").mouseout(function () {
            $(this).find("img").css("background","#FFF,");
        });
    });
</script>
</html>