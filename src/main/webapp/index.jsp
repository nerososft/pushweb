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
            <div class="col-md-12"><strong style="color:#333;"><span class="glyphicon glyphicon-th"></span> My Apps</strong>
                <select style="background: #EB650C;border:solid 1px #EB650C;border-radius: 2px;color: #F2F3F7;margin: -2px;">
                    <option style="background: #EB650C;border:solid 1px #EB650C;color: #F2F3F7;">Android</option>
                    <option style="background: #EB650C;border:solid 1px #EB650C;color: #F2F3F7;">Ios</option>
                    <option style="background: #EB650C;border:solid 1px #EB650C;color: #F2F3F7;">Server</option>
                </select>
            </div>
            <div class="col-md-12" id="tip"></div>
            <div class="col-md-12" id="apps_container">

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
            limit:100
        });
       $(".app").mouseover(function () {
           $(this).find("img").css("background","#000,");
           alert("ss");
       });
       $(".app").mouseout(function () {
           $(this).find("img").css("background","#FFF,");
       });
       $("#apps_container").find("div").find("a").click(function() {
                   var herf = "/app/" + $(this).attr("ref");
                   window.location.href = href;
               }
       );
   });
</script>
</html>