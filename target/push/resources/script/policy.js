var policy={
    APP:{
      getId:function () {
          return window.location.href.substr(window.location.href.indexOf("/app/")+5);

      }
    },
    URL:{
        addpolicy:function (policyname,appid) {
            return "";
        },
        getpolicylist:function (offset,limit) {
            return "/policy/"+$.cookie("developerId")+"/"+$.cookie("developerToken")+"/auth/"+policy.APP.getId()+"/list/"+offset+"/"+limit;
        }
    },
    View:{
        addpolicy:function () {
            layer.open({
                type: 1,
                area: ['32em', '24em'],
                shadeClose: true, //点击遮罩关闭
                title: "创建新策略",
                content: "<div class='col-md-12' style='padding: 2em;'>" +
                "<div id='createnewPolicy' class='col-md-12' style='margin:0;padding: 0;'></div>" +
                "<label class='col-md-12' style='padding: 0;margin:0;' for='policyname'>策略名称:</label>" +
                "<div class='col-md-12' style='padding:0;margin:0;margin-top: 0.1em;'><span class='glyphicon glyphicon-exclamation-sign' style='color: #EB650C;'></span>提示:怎么创建<a href='javascript:;  '>规范策略</a>!</div>" +
                "<input id='policyname' class='col-md-12 form-control' placeholder='policy name' style='border-radius: 1px;margin-top: 0.1em;'/>" +
                "<label class='col-md-12' style='padding: 0;margin:0;margin-top: 1em;' for='confirmPass'>安全码:</label>" +
                "<input id='changeConfirmPass' class='col-md-12 form-control' type='password' placeholder='password' style='border-radius: 1px;'/>" +
                "<a href='javascript:policy.Operate.addpolicy();'><button style='background: #EB650C;border: none;padding: 0.4em;color:#F2F3F7;border-radius: 4px;margin-top: 1em;' class='col-md-12'>创建</button></a>" +
                "</div>"
            });
        }
    },
    Operate:{
        addpolicy:function () {
            $.post(policy.URL.getpolicylist(0,100),{},function (data,status) {

            });
        }
    }
};