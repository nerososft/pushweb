<%@page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>TWTpush - app</title>
</head>
<body style="background: #F2F3F7;">
<div class="container-fluid">
    <%@include file="common/header.jsp"%>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-8">
            <div class="col-md-12"><strong style="color:#333;height:2em;line-height: 2em;"><img src="/resources/img/ios.small.png"/><a href="/">AllApps</a> / App Info</strong>
            </div>
            <hr>
            <div class="col-md-12" id="tip"></div>
            <div class="col-md-12" id="apps_container">
                <div class="col-md-5" style='margin-left:1em;background: #FFF;box-shadow: 0px 0px 1px  2px #eee;margin-top: 1em;padding: 0;padding-bottom: 0.5em;border-radius: 1px;'>
                    <div class="col-md-12">
                        <strong style="color:#aaaaaa;">AppName:</strong>
                        <p></p>
                    </div>
                    <div class="col-md-12">
                        <strong style="color:#aaaaaa;">CreateTime:</strong>
                        <p></p>
                    </div>
                    <div class="col-md-12">
                        <strong style="color:#aaaaaa;">AppKey:</strong>
                        <p></p>
                    </div>
                    <div class="col-md-12">
                        <strong style="color:#aaaaaa;">Broker:</strong>
                        <p></p>
                    </div>
                    <div class="col-md-12">
                        <strong style="color:#aaaaaa;">AppDevice:</strong>
                        <p></p>
                    </div>
                    <div class="col-md-12">
                        <strong style="color:#aaaaaa;">AppSecretKey:</strong>
                        <p></p>
                    </div>
                </div>
                <div style="margin-left: 1em;margin-top: 1em;" class="col-md-5">
                    <strong>Broker state</strong>
                </div>
            </div>
        </div>
        <div class="col-md-2">
            <div style="padding: 1em;" class="col-md-12">
                <button style="background: #EB650C;border: none;padding: 0.4em;color:#F2F3F7;border-radius: 4px;" class="col-md-12" class="btn btn-default">Change App Name</button>
            </div>
            <div style="padding: 1em;" class="col-md-12">
                <button style="background: #EB650C;border: none;padding: 0.4em;color:#F2F3F7;border-radius: 4px;" class="col-md-12" class="btn btn-default">Reset App Key</button>
            </div>
            <div style="padding: 1em;" class="col-md-12">
                <button style="background: #EB650C;border: none;padding: 0.4em;color:#F2F3F7;border-radius: 4px;" class="col-md-12" class="btn btn-default">Reset App SecretKey</button>
            </div>
            <div style="padding: 1em;" class="col-md-12">
                <button style="background: #EB650C;border: none;padding: 0.4em;color:#F2F3F7;border-radius: 4px;" class="col-md-12" class="btn btn-default">Delete App</button>
            </div>
        </div>

        <div class="col-md-1">

        </div>
    </div>
</div>
</body>
<script src="/resources/script/developer.js" type="text/javascript"></script>
<script src="/resources/script/app.js" type="text/javascript"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript">
    $(function () {
        developer.auth();
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