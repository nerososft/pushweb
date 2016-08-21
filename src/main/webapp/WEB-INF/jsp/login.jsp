<%@page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>developer login</title>
</head>
<body>
<div class="container-fluid">
    <%@include file="common/header.jsp"%>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="col-md-6">
                <img class="col-md-12" alt="ADS" src=""/>
            </div>
            <div class="col-md-5">
                <br>
                    <div id="tip">

                    </div>
                    <div class="form-group">
                        <input type="email" class="form-control" id="developerEmail" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="developerPassword" placeholder="Password">
                    </div>
                    <button id="login" type="submit" class="btn btn-default">Login</button>
                    <a href="login.jsp">i want to be a developer!</a>
                </form>
            </div>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>
</body>
<script src="/resources/script/developer.js" type="text/javascript"></script>
<script type="text/javascript">
   $("#login").click(function () {
        developer.login.login({
            developerEmail:$("#developerEmail").val(),
            developerPassword:$("#developerPassword").val()
        });
    });
</script>
</html>