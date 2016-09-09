var policy={
    APP:{
      getId:function () {
          return window.location.href.substr(window.location.href.indexOf("/app/")+5);
      }
    },
    URL:{
        addpolicy:function (policyname,appid,pass) {
            return "/policy/"+$.cookie("developerId")+"/"+$.cookie("developerToken")+"/auth/"+pass+"/verify/"+appid+"/"+policyname+"/create";
        },
        getpolicylist:function (offset,limit) {
            return "/policy/"+$.cookie("developerId")+"/"+$.cookie("developerToken")+"/auth/"+policy.APP.getId()+"/list/"+offset+"/"+limit;
        },
        delete:function (policyId,pass) {
            return "/policy/"+$.cookie("developerId")+"/"+$.cookie("developerToken")+"/auth/"+pass+"/verify/"+policyId+"/delete";
        },
        modify:function (policyId,policyName,pass) {
            return "/policy/"+$.cookie("developerId")+"/"+$.cookie("developerToken")+"/auth/"+pass+"/verify/"+policyId+"/"+policyName+"/modify";
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
        },
        delete:function (policyId) {
            layer.open({
                type: 1,
                area: ['32em', '24em'],
                shadeClose: true, //点击遮罩关闭
                title: "删除策略"+policyId,
                content: "<div class='col-md-12' style='padding: 2em;'>" +
                "<div id='changeNameTip' class='col-md-12' style='margin:0;padding: 0;'></div>" +
                "<label class='col-md-12' style='margin: 0;padding: 0;' for='confirmPass'>安全码:</label>" +
                "<input id='deleteconfirmPass' class='col-md-12 form-control' type='password' placeholder='password' style='border-radius: 1px;'/>" +
                "<div class='col-md-12' style='padding:0;margin:0;margin-top: 1em;'><span style='color: #EB650C;' class='glyphicon glyphicon-exclamation-sign'></span> Please proceed with caution!</div>" +
                "<div class='col-md-12' style='padding:0;margin:0;'><span class='glyphicon glyphicon-exclamation-sign' style='color: #EB650C;'></span> Will cause the existing device to be unable to connect!</div>" +
                "<a href='javascript:policy.Operate.delete("+policyId+");'><button style='background: #EB650C;border: none;padding: 0.4em;color:#F2F3F7;border-radius: 4px;margin-top: 1em;' class='col-md-12'>删除</button></a>" +
                "</div>"
            });
        },
        modify:function (policyId) {
            layer.open({
                type: 1,
                area: ['32em', '24em'],
                shadeClose: true, //点击遮罩关闭
                title: "修改策略" + policyId,
                content: "<div class='col-md-12' style='padding: 2em;'>" +
                "<div id='changeNameTip' class='col-md-12' style='margin:0;padding: 0;'></div>" +
                "<label class='col-md-12' style='padding: 0;margin:0;' for='newNameText'>新名称:</label>" +
                "<input id='newNameText' class='col-md-12 form-control' placeholder='new name' style='border-radius: 1px;'/>" +
                "<label class='col-md-12' style='padding: 0;margin:0;margin-top: 1em;' for='confirmPass'>安全码:</label>" +
                "<input id='changeConfirmPass' class='col-md-12 form-control' type='password' placeholder='password' style='border-radius: 1px;'/>" +
                "<a href='javascript:policy.Operate.modify("+policyId+");'><button style='background: #EB650C;border: none;padding: 0.4em;color:#F2F3F7;border-radius: 4px;margin-top: 1em;' class='col-md-12'>修改</button></a>" +
                "</div>"
            });
        }
    },
    Operate:{
        getpolicylist:function () {
            $.post(policy.URL.getpolicylist(0,100),{},function (data,status) {
                console.log("policy={}",data);
                if(!status || !data.success){
                    layer.msg('服务器开小差了!');
                }else{
                    $.each(data.data,function (key,value) {
                        $("#policy").append("<p class='col-md-12'><p class='col-md-8'>"+(key+1)+" : " +value.policyName+"</p>" +
                            "<p class='col-md-3'>" +
                            "<a href='javascript:policy.View.delete("+value.policyId+");'><span class='glyphicon glyphicon-remove'></span></a>&nbsp;&nbsp;" +
                            "<a href='javascript:policy.View.modify("+value.policyId+");'><span class='glyphicon glyphicon-pencil'></span></a>" +
                            "</p>" +
                            "</p>");
                    });
                }
            });
        },
        delete:function (policyId) {
            $.post(policy.URL.delete(policyId,$("#deleteconfirmPass").val()),{},function (data,status) {
                console.log("deletepolicy={}",data);
                if(!status || !data.state){
                    $("#changeNameTip").append("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> "+data.msg+"</p>");
                }else{
                    layer.closeAll();
                    layer.msg("删除成功!");
                    app.find.app(policy.APP.getId());
                }
            });
        },
        modify:function (policyId) {
            $.post(policy.URL.modify(policyId,$("#newNameText").val(),$("#changeConfirmPass").val()),{},function (data,status) {
                console.log("deletepolicy={}",data);
                if(!status || !data.state){
                    $("#changeNameTip").append("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> "+data.msg+"</p>");
                }else{
                    layer.closeAll();
                    layer.msg("修改成功!");
                    app.find.app(policy.APP.getId());
                }
            });
        },
        addpolicy:function () {
            $.post(policy.URL.addpolicy($("#policyname").val(),this.APP.getId(),$("#changeConfirmPass").val()),{},function (data,status) {
                console.log("deletepolicy={}",data);
                if(!status || !data.state){
                    $("#changeNameTip").append("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> "+data.msg+"</p>");
                }else{
                    layer.closeAll();
                    layer.msg("添加成功!");
                    app.find.app(policy.APP.getId());
                }
            });
        }
    }
};