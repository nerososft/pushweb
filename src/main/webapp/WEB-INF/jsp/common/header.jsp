<%--
  Created by IntelliJ IDEA.
  User: nero
  Date: 16-8-21
  Time: 下午3:10
  To change this template use File | Settings | File Templates.
--%>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="/resources/script/layer/layer.js"></script>
<style>
    *{
        outline: none;
    }
    a:link{
        color:#EB650C;
    }
    .navbar-brand:hover {
        color: #EB650C;
    }
    label{
        color: #888;
    }
</style>

<div class="row">
    <div style="background: #FFFFFF;box-shadow: 0px 0px 5px 2px #ddd; " class="col-md-12">
        <div class="container-fluid">
            <div  class="col-md-12" style="border-radius: 0px;">
                <a class="navbar-brand col-md-2" href="javascript:gotoPage('/');">
                    <img style="height: 1.5em;" alt="TWTPush" src="/resources/img/logo.png">
                </a>
                <div  class="col-md-6">
                    <a style="text-align: center;font-weight: lighter;color: #333333;font-size: 1.2em;" class="navbar-brand col-md-2" href="javascript:gotoPage('/');">
                        主页 <span style="font-size: 0.5em;color: #d3d3d3;" class="glyphicon glyphicon-menu-down"></span>
                    </a>
                    <a style="text-align: center;font-weight: lighter;color: #333333;font-size: 1.2em;" class="navbar-brand col-md-2" href="javascript:gotoPage('/page/document');">
                        文档 <span style="font-size: 0.5em;color: #d3d3d3;" class="glyphicon glyphicon-menu-down"></span>
                    </a>
                    <a style="text-align: center;font-weight: lighter;color: #333333;font-size: 1.2em;" class="navbar-brand col-md-2" href="javascript:gotoPage('/page/download');">
                        下载 <span style="font-size: 0.5em;color: #d3d3d3;" class="glyphicon glyphicon-menu-down"></span>
                    </a>
                    <a style="text-align: center;font-weight: lighter;color: #333333;font-size: 1.2em;" class="navbar-brand col-md-2" href="javascript:gotoPage('/page/community');">
                         社区 <span style="font-size: 0.5em;color: #d3d3d3;" class="glyphicon glyphicon-menu-down"></span>
                    </a>
                    <a style="text-align: center;font-weight: lighter;color: #333333;font-size: 1.2em;" class="navbar-brand col-md-2" href="javascript:gotoPage('/page/about');">
                         关于 <span style="font-size: 0.5em;color: #d3d3d3;" class="glyphicon glyphicon-menu-down"></span>
                    </a>
                    <div class="col-md-3"></div>
                </div>
                <div class="col-md-2"></div>
                <div class="col-md-2">
                    <div class="navbar-brand col-md-12" style="text-align: center;" id="developerName"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/resources/script/jquery.rotate.js" type="text/javascript"></script>
<script src="/resources/script/developer.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/script/jquery.cookie.js"></script>
<script type="text/javascript">

    $(function () {
        //developer.auth();
            });
</script>

<script>
    $("a").mouseover(function(){
        $(this).css("color", "#EB650C");
        $(this).find("span").css("color","#EB650C");
        $(this).find("span").animate({rotate: '180'}, 300);
        //$(this).find("span").attr("class","glyphicon glyphicon-menu-up");
    });

    $("a").mouseout(function(){
        $(this).css("color", "#333333");
        $(this).find("span").css("color","#d3d3d3");
        $(this).find("span").animate({rotate: '0'}, 300);
        //$(this).find("span").attr("class","glyphicon glyphicon-menu-down");
    });
    $("#developerName").mouseover(function(){
        $(this).find("p").css("color","#FFF");
        $(this).find("p").css("background","#2AC7E3");
        //$(this).find("span").attr("class","glyphicon glyphicon-menu-up");
    });
    $("#developerName").mouseout(function(){
        $(this).find("p").css("color","#FFF");
        $(this).find("p").css("background","#EB650C");
        //$(this).find("span").attr("class","glyphicon glyphicon-menu-up");
    });

    var gotoPage = function (page) {
        window.location.href=page;
    }

</script>