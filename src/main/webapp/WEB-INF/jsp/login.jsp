<%@page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>developer login</title>
</head>
<body style="background: #F2F3F7">
<div class="container-fluid">
    <%@include file="common/header.jsp"%>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div style="margin-top: 4em;padding-right: 8em;" class="col-md-8">
                <img class="col-md-12" alt="ADS" src="https://o8ci6tgz8.qnssl.com/push_console_pic_3.png?ver=201608191938"/>
            </div>
            <div style="margin-top: 5em;box-shadow: 0px 0px 1px 2px #eee;background: #fff;padding-bottom: 2em;" class="col-md-4">
                <br>
                    <div id="tip">

                    </div>
                    <div style="margin-top: 1em;" class="form-group">
                        <div class="input-group">
                            <label for="developerEmail">Email:</label>
                        <input type="email" style="width: 100%;border-radius: 0px;" class="form-control" id="developerEmail" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <label for="developerPassword">Password:</label><a style="float: right;">Forgot Password?</a>
                        <input type="password" style="width: 100%;border-radius: 0px;" class="form-control" id="developerPassword" placeholder="Password">
                        </div>
                    </div>
                <div style="margin-top: 2em;">
                    <button id="login" type="submit" style="background: #EB650C;border: none;padding: 0.4em;color:#F2F3F7;border-radius: 4px;" class="col-md-12">Login</button>
                    <a style="margin-top: 1em;float: right;" href="login.jsp">Free Join!</a>
                </div>
                </form>
            </div>
        </div>
        <div class="col-md-1"></div>
    </div>
    <%@include file="common/footer.jsp"%>
</div>
</body>
<script src="/resources/script/developer.js" type="text/javascript"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript">
    $(function () {
        developer.auth();
    });
   $("#login").click(function () {
        developer.login.login({
            developerEmail:$("#developerEmail").val(),
            developerPassword:$("#developerPassword").val()
        });
    });
</script>
</html>