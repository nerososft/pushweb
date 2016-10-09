<%--
  Created by IntelliJ IDEA.
  User: nero
  Date: 16-9-6
  Time: 上午12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载</title>
</head>
<body style="background: #F2F3F7;">
<div class="container-fluid" style="padding: 0;margin: 0;">
    <%@include file="common/header.jsp" %>
    <div class="row" style="padding: 0;margin: 0;">
        <div class="col-md-1"></div>
        <script>
           var flowup = function (oj) {
                //alert("on");
                oj.style.transition="all 1s";
                oj.style.boxShadow="0px 5px 20px 2px #d3d3d3";
                oj.style.marginTop="0.5em";
            };
           var flowdown=function (oj) {
                //alert("down");
                oj.style.boxShadow="0px 0px 5px  2px #eee";
                oj.style.marginTop="1em";
            };
           var gotopage=function(url) {
                window.location.href=url;
            };
        </script>
        <div class="col-md-10">
            <div onmouseover="javascript:flowup(this);" onmouseout="javascript:flowdown(this);" style='margin-left:1em;height:15.9em;line-height:15.9em;background: #fff;box-shadow: 0px 0px 5px  2px #eee;margin-top: 1em;padding: 1em;border-radius: 1px;'
                 class='app col-md-3'>
                <center>
                    <img class="col-md-12" src="/resources/img/ios.png"/>
                </center>
            </div>
            <div onmouseover="javascript:flowup(this);" onmouseout="javascript:flowdown(this);" style='margin-left:1em;height:15.9em;line-height:15.9em;background: #fff;box-shadow: 0px 0px 5px  2px #eee;margin-top: 1em;padding: 1em;border-radius: 1px;'
                 class='app col-md-3'>
                <center>
                    <img class="col-md-12" src="/resources/img/android.png"/>
                </center>
            </div>
            <div onmouseover="javascript:flowup(this);" onmouseout="javascript:flowdown(this);" style='margin-left:1em;height:15.9em;line-height:15.9em;background: #fff;box-shadow: 0px 0px 5px  2px #eee;margin-top: 1em;padding: 1em;border-radius: 1px;'
                 class='app col-md-3'>
                <center>
                    <img class="col-md-12" src="/resources/img/server.png"/>
                </center>
            </div>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>


</body>
<script>
    $(function () {
        developer.auth();
    });
</script>
</html>
