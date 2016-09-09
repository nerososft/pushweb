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
               <strong>welcome!</strong>
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
   });
</script>
</html>