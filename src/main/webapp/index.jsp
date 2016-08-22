<%@page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>TWTpush</title>
</head>
<body style="background: #F2F3F7;">
<div class="container-fluid">
    <%@include file="WEB-INF/jsp/common/header.jsp"%>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-8">
            <div class="col-md-12"><strong style="color:#333;"><span class="glyphicon glyphicon-th"></span> My Apps</strong></div>
            <div class="col-md-12" id="tip"></div>
            <div style="background: #FFF;border: solid 1px #dddddd;height: 10em;margin-top: 1em;" class="col-md-2">
               App1
            </div>
            <div style="background: #FFF;border: solid 1px #dddddd;height: 10em;margin-top: 1em;" class="col-md-offset-1 col-md-2">
                App2
            </div>
            <div style="background: #FFF;border: solid 1px #dddddd;height: 10em;margin-top: 1em;" class="col-md-offset-1 col-md-2">
                App3
            </div>
            <div style="background: #FFF;border: solid 1px #dddddd;height: 10em;margin-top: 1em;" class="col-md-offset-1 col-md-2">
                App4
            </div>
            <div style="background: #FFF;border: solid 1px #dddddd;height: 10em;margin-top: 1em;" class="col-md-2">
                App4
            </div>
            <div style="background: #FFF;border: solid 1px #dddddd;height: 10em;margin-top: 1em;" class="col-md-offset-1 col-md-2">
                App4
            </div>
            <div style="background: #FFF;border: solid 1px #dddddd;height: 10em;margin-top: 1em;" class="col-md-offset-1 col-md-2">
                App4
            </div>
            <div style="background: #FFF;border: solid 1px #dddddd;height: 10em;margin-top: 1em;" class="col-md-offset-1 col-md-2">
                App4
            </div>
            <div style="background: #FFF;border: solid 1px #dddddd;height: 10em;margin-top: 1em;" class="col-md-2">
                App4
            </div>
        </div>
        <div style="padding: 1em;">
            <button style="background: #EB650C;border: none;padding: 0.4em;color:#F2F3F7;border-radius: 4px;" class="col-md-2" class="btn btn-default">Create New App</button>
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
        app.find.allapp({
            offset:0,
            limit:10
        });
   });
</script>
</html>