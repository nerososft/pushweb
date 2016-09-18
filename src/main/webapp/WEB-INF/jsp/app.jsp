<%@page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>天外天推送-应用</title>
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
                        <span style="color: #EB650C;" class="glyphicon glyphicon-chevron-left"></span><a style="color: #EB650C;text-decoration: none;" href="/page/myapps"><strong>AllApps</strong></a>
                </div>
            </div>
            </div>
            <div class="col-md-12" id="apps_container">
                <div class="col-md-4" style="padding: 0;margin: 0;">
                <div class="col-md-12">
                    <div onmouseover="flowup(this);" onmouseout="flowdown(this);"  id="app_info" class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 5px  2px #eee;margin-top: 1em;border-radius: 1px;'>
                        app info
                    </div>
                    <div onmouseover="flowup(this);" onmouseout="flowdown(this);" id="policy" class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 5px  2px #eee;margin-top: 1em;border-radius: 1px;'>
                        <strong class='col-md-12'>推送策略 <a href="javascript:policy.View.addpolicy();"><span class="glyphicon glyphicon-plus">新建策略</span></a></strong><hr>

                    </div>
                    <div onmouseover="flowup(this);" onmouseout="flowdown(this);" id="node_info" class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 5px  2px #eee;margin-top: 1em;border-radius: 1px;'>
                        node info
                    </div>
                    <div onmouseover="flowup(this);" onmouseout="flowdown(this);" id="app_connect" class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 5px  2px #eee;margin-top: 1em;border-radius: 1px;'>
                        <strong>CONNECTIONS</strong><hr>

                        <table id="app_connect_table" class="col-md-12">
                            <tr class="col-md-12"><td class="col-md-2">Id</td><td class="col-md-10">Label</td></tr>
                        </table>
                    </div>
                    <div onmouseover="flowup(this);" onmouseout="flowdown(this);" id="app_device" class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 5px  2px #eee;margin-top: 1em;border-radius: 1px;'>
                        app device
                    </div>

                </div>
                </div>
                <div  class="col-md-8" style="padding: 0;margin: 0;">
                    <div class="col-md-12">
                        <div onmouseover="flowup(this);" onmouseout="flowdown(this);" class="col-md-12" style="padding:1em;background: #FFF;box-shadow: 0px 0px 5px  2px #eee;margin-top: 1em;border-radius: 1px;">
                            <p id="broker_tip"></p>
                        </div>
                    <div onmouseover="flowup(this);" onmouseout="flowdown(this);" id="virtualhost_info"  class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 5px  2px #eee;margin-top: 1em;border-radius: 1px;'>
                        virtualhost
                    </div>
                    <div onmouseover="flowup(this);" onmouseout="flowdown(this);" id="broker_info"  class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 5px  2px #eee;margin-top: 1em;border-radius: 1px;'>
                            broker info
                    </div>
                    <div onmouseover="flowup(this);" onmouseout="flowdown(this);" id="jvm_info" class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 5px  2px #eee;margin-top: 1em;border-radius: 1px;'>
                            jvm info
                    </div>
                    <div onmouseover="flowup(this);" onmouseout="flowdown(this);" id="msg_histroy" class="col-md-12" style='padding:1em;background: #FFF;box-shadow: 0px 0px 5px  2px #eee;margin-top: 1em;border-radius: 1px;'>
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
<script type="text/javascript" src="/resources/script/jquery.cookie.js"></script>
<script type="text/javascript">

    $(function () {
        developer.auth();
        var id = window.location.href.substr(window.location.href.indexOf("/app/")+5);
        console.log("id={}",id);

        app.find.app(id);//获取当前应用信息

        policy.Operate.getpolicylist();//获取当前应用的推送策略


    });
    var flowup = function (oj) {

        oj.style.transition="all 0.3s";
        oj.style.boxShadow="0px 5px 20px 2px #d3d3d3";
    };
    var flowdown = function (oj) {
        oj.style.boxShadow="0px 0px 5px  2px #eee";
        oj.style.marginTop="1em";
    };
</script>
</html>