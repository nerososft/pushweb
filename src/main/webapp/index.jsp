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
        <div class="col-md-10">
            <div class="col-md-12" id="tip"></div>
            <div class="col-md-12" id="apps_container">
                <div style='margin-left:1em;background: #FFF;box-shadow: 0px 0px 1px  2px #eee;margin-top: 1em;padding: 1em;border-radius: 1px;' class='app col-md-2'>
                    <span class="glyphicon glyphicon-plus-sign col-md-12" style="font-size: 8em;color: #EB650C;"></span>
                </div>
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
        app.find.allapp({
            offset:0,
            limit:100
        });
       $(".app").mouseover(function () {
           $(this).find("img").css("background","#000,");

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