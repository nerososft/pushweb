<%@page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>天大IT人自己的推送平台</title>
    <meta charset="UTF-8"/>
</head>
<body style="background: #F2F3F7;">
<div class="container-fluid">
    <%@include file="WEB-INF/jsp/common/header.jsp"%>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="col-md-12" id="tip"></div>
            <div class="col-md-12" id="apps_container">
                <a href="javascript:app.utils.add();">
                    <div style='margin-left:1em;height:15.9em;line-height:15.9em;background: #fff;box-shadow: 0px 0px 5px  2px #eee;margin-top: 1em;padding: 1em;border-radius: 1px;' class='app col-md-2'>
                    <center>
                        <span class="glyphicon glyphicon-plus-sign col-md-12" style="padding:0;margin:0;font-size: 8em;color: #EB650C;">
                             </span>
                        <%--<strong class="col-md-12" style="margin:0;padding:0;font-size:1em;">创建应用</strong>--%>

                    </center>
                    </div>
                </a>
           </div>
        </div>
        <div class="col-md-1">

        </div>
    </div>
</div>
</body>
<script src="/resources/script/developer.js" type="text/javascript"></script>
<script src="/resources/script/app.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/script/jquery.cookie.js"></script>
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
       $("#apps_container").find("div").mouseover(function () {
           $(this).css("transition","all 0.3s");
           $(this).css("box-shadow","0px 5px 20px 2px #d3d3d3");
           $(this).css("margin-top","0.5em");
       });
       $("#apps_container").find("div").mouseout(function () {
           $(this).css("box-shadow","0px 0px 5px  2px #eee");
           $(this).css("margin-top","1em");
       });
   });
</script>
</html>