<%--
  Created by IntelliJ IDEA.
  User: nero
  Date: 16-8-21
  Time: 下午3:10
  To change this template use File | Settings | File Templates.
--%>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
    *{
        outline: none;
    }
    a:link{
        color:#EB650C;
    }
    .navbar-brand:hover{
        color: #EB650C;
    }
</style>

<div class="row">
    <nav style="background: #FFFFFF;" class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header col-md-12">
                <a class="navbar-brand col-md-2" href="#">
                    <img style="height: 1.5em;" alt="TWTPush" src="//www.twt.edu.cn/static/logo.png">
                </a>
                <div  class="col-md-6">
                    <a style="text-align: center;font-weight: lighter;color: #333333;font-size: 1.2em;" class="navbar-brand col-md-3" href="javascript:;">
                        Document <span style="font-size: 0.5em;color: #d3d3d3;" class="glyphicon glyphicon-menu-down"></span>
                    </a>
                    <a style="text-align: center;font-weight: lighter;color: #333333;font-size: 1.2em;" class="navbar-brand col-md-3" href="javascript:;">
                         Social <span style="font-size: 0.5em;color: #d3d3d3;" class="glyphicon glyphicon-menu-down"></span>
                    </a>
                    <a style="text-align: center;font-weight: lighter;color: #333333;font-size: 1.2em;" class="navbar-brand col-md-3" href="javascript:;">
                         About <span style="font-size: 0.5em;color: #d3d3d3;" class="glyphicon glyphicon-menu-down"></span>
                    </a>
                    <div class="col-md-3"></div>
                </div>
                <div class="col-md-2"></div>
                <div class="col-md-2">
                    <div class="navbar-brand col-md-12" style="text-align: center;" id="developerName"></div>
                </div>
            </div>
        </div>
    </nav>
</div>

<script>
    $("a").mouseover(function(){
        $(this).css("color", "#EB650C");
    });

    $("a").mouseout(function(){
        $(this).css("color", "#333333");
    });

</script>