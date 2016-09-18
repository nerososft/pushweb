<%--
  Created by IntelliJ IDEA.
  User: nero
  Date: 16-9-10
  Time: 下午10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="/resources/script/layer/layer.js"></script>
<div class="row" style="padding: 0;margin: 0;">
    <div style="background: transparent;padding: 0;margin: 0;" class="col-md-12">
        <div class="container-fluid" style="padding: 0;margin: 0;">
    <script>
        var ul_over= function (oj) {
            oj.style.transition="all 0.3s";
           oj.style.background="#111a26";
        };
        var ul_out= function (oj) {
            oj.style.background="transparent";
        };
    </script>
            <ul onmouseover="javascript:ul_over(this);" onmouseout="javascript:ul_out(this);" class="col-md-12" style="display: inline-block;color: #fff;font-size: 1em;padding: 0;height: 5em;line-height: 5em;">
                <li class="col-md-2" style="display: inline-block;color: #fff;height: 5em;line-height: 5em;padding-left: 4em;"><img src="/resources/img/qcloud-logo.png"/></li>
                <li class="col-md-1" style="display: inline-block;color: #fff;height: 5em;line-height: 5em;">推送云</li>
                <li class="col-md-1" style="display: inline-block;color: #fff;height: 5em;line-height: 5em;">即时通讯</li>
                <li class="col-md-1" style="display: inline-block;color: #fff;height: 5em;line-height: 5em;">直播云</li>
                <li class="col-md-5" style="display: inline-block;color: #fff;height: 5em;line-height: 5em;">云监控</li>
                <li class="col-md-2" style="display: inline-block;color: #fff;height: 5em;line-height: 5em;">
                    <a style="color: #fff;" href="javascript:window.location.href='/developer/login';">
                        <span>登录</span>
                    </a>&nbsp;|&nbsp;
                    <a style="color: #fff;" href="javascript:window.location.href='/developer/register';">
                        <span>注册</span>
                    </a>&nbsp;&nbsp;
                    <a style="color: #fff;" href="javascript:window.location.href='/page/myapps';">
                        <span style="border: solid 0.1px #fff;padding: 3px;border-radius: 2px;">管理中心</span>
                    </a>
                </li>

            </ul>
        </div>
    </div>
</div>
