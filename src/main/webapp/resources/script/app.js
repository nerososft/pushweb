var app = {
    URL:{
        allapp:function (offset,limit) {
            return "/app/"+$.cookie("developerId")+"/"+$.cookie("developerToken")+"/auth/"+offset+"/"+limit+"/apps";
        },
        app:function (appId) {
            return "/app/" + $.cookie("developerId") + "/" + $.cookie("developerToken") + "/auth/" + appId + "/app";
        },
        broker:function (appKey,appSecretKey) {
            return "/broker/"+$.cookie("developerId") + "/" + $.cookie("developerToken") + "/auth/"+appKey+"/"+appSecretKey+"/broker";
        },
        changename:function (developerPass,appId,newAppName) {
            return "/app/"+$.cookie("developerId") + "/" + $.cookie("developerToken") + "/auth/"+developerPass+"/verify/"+appId+"/"+newAppName+"/changename";
        },
        resetapp:function (developerPass,appId) {
            return "/app/"+$.cookie("developerId") + "/" + $.cookie("developerToken") + "/auth/"+developerPass+"/verify/"+appId+"/reset";
        },
        delete:function (developerPass,appId) {
            return "/app/"+$.cookie("developerId") + "/" + $.cookie("developerToken") + "/auth/"+developerPass+"/verify/"+appId+"/delete";
        },add:function (developerPass,appname,company) {
            return "/app/"+$.cookie("developerId") + "/" + $.cookie("developerToken") + "/auth/"+developerPass+"/verify/"+appname+"/create";
        }
    },
    operate:{
        changename:function () {
            if(!$("#changeConfirmPass").val() || !$("#newNameText").val()){
                $("#changeNameTip").html("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> Incomplete form!</p>");
                return;
            }
            if(patrn.exec($("#newNameText").val())){
                $("#changeNameTip").html("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> Name can not be Chinese!</p>");
                return;
            }
            var id = window.location.href.substr(window.location.href.indexOf("/app/")+5);
            $.post(app.URL.changename($("#changeConfirmPass").val(),id,$("#newNameText").val()),{},function (result,state) {
                if(state){
                    if(result.success){
                        $("#changeNameTip").html("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> Change Success!</p>");
                        app.find.app(id);
                        layer.closeAll();
                    }else{
                        $("#changeNameTip").html(result.error);
                    }
                }else{
                    $("#changeNameTip").html("<p>There is Something Wrong whit Server!</p>");
                }
            });
        },
        reset:function () {
            if(!$("#resetconfirmPass").val()){
                $("#changeNameTip").html("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> Incomplete form!</p>");
                return;
            }
            var id = window.location.href.substr(window.location.href.indexOf("/app/")+5);
            $.post(app.URL.resetapp($("#resetconfirmPass").val(),id),{},function (result,state) {
                if(state){
                    if(result.success){
                        $("#changeNameTip").html("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> Reset Success!</p>");
                        app.find.app(id);
                        layer.closeAll();
                    }else{
                        $("#changeNameTip").html("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> "+result.error+"</p>");
                    }
                }else{
                    $("#changeNameTip").html("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> There is Something Wrong whit Server!</p>");
                }
            });
        },
        delete:function () {
            if(!$("#deleteconfirmPass").val()){
                $("#changeNameTip").html("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> Incomplete form!</p>");
                return;
            }
            var id = window.location.href.substr(window.location.href.indexOf("/app/")+5);
            $.post(app.URL.delete($("#deleteconfirmPass").val(),id),{},function (result,state) {
                if(state){
                    if(result.success){
                        $("#changeNameTip").html("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> Delete Success!</p>");
                        layer.closeAll();
                        window.location.href="/";
                    }else{
                        $("#changeNameTip").html("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> "+result.error+"</p>");
                    }
                }else{
                    $("#changeNameTip").html("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> There is Something Wrong whit Server!</p>");
                }
            });
        },
        add:function () {
            if(!$("#addconfirmPass").val() || !$("#appname_text").val() || !$("#company_text").val()){
                $("#changeNameTip").html("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> Incomplete form!</p>");
                return;
            }
            var patrn=/[\u4E00-\u9FA5]|[\uFE30-\uFFA0]/gi;
            if(patrn.exec($("#appname_text").val())){
                $("#changeNameTip").html("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> Name can not be Chinese!</p>");
                return;
            }
            var url=app.URL.add($("#addconfirmPass").val(),$("#appname_text").val(),$("#company_text").val());
            console.log("add:","http://localhost:8080"+url);
            $.post(url,{},function (result,state) {
                if(state){
                    if(result.success){
                        $("#changeNameTip").html("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> Delete Success!</p>");
                        layer.closeAll();
                        window.location.href="/";
                    }else{
                        $("#changeNameTip").html("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> "+result.error+"</p>");
                    }
                }else{
                    $("#changeNameTip").html("<p style='color: #EB650C;'><span class='glyphicon glyphicon-exclamation-sign'></span> There is Something Wrong whit Server!</p>");
                }
            });
        }
        
    },utils: {
        changeName: function () {
            layer.open({
                type: 1,
                area: ['32em', '24em'],
                shadeClose: true, //点击遮罩关闭
                title: "ChangeAppName",
                content: "<div class='col-md-12' style='padding: 2em;'>" +
                "<div id='changeNameTip' class='col-md-12' style='margin:0;padding: 0;'></div>" +
                "<label class='col-md-12' style='padding: 0;margin:0;' for='newNameText'>New Name:</label>" +
                "<input id='newNameText' class='col-md-12 form-control' placeholder='new name' style='border-radius: 1px;'/>" +
                "<label class='col-md-12' style='padding: 0;margin:0;margin-top: 1em;' for='confirmPass'>Password:</label>" +
                "<input id='changeConfirmPass' class='col-md-12 form-control' type='password' placeholder='password' style='border-radius: 1px;'/>" +
                "<a href='javascript:app.operate.changename();'><button style='background: #EB650C;border: none;padding: 0.4em;color:#F2F3F7;border-radius: 4px;margin-top: 1em;' class='col-md-12'>Change</button></a>" +
                "</div>"
            });
        },
        showAppKey: function (key) {
            layer.open({
                type: 1,
                area: ['32em', '10em'],
                shadeClose: true, //点击遮罩关闭
                title: "Refresh",
                content: "<div class='col-md-12' style='padding: 2em;'>" +
                "<input readonly='readonly' class='col-md-12 form-control' value='" + key + "'/>" +
                "</div>"
            });
        }, refreshAppKey: function (title) {
            layer.open({
                type: 1,
                area: ['32em', '24em'],
                shadeClose: true, //点击遮罩关闭
                title: title,
                content: "<div class='col-md-12' style='padding: 2em;'>" +
                "<div id='changeNameTip' class='col-md-12' style='margin:0;padding: 0;'></div>" +
                "<label class='col-md-12' for='confirmPass'>Password:</label>" +
                "<input id='resetconfirmPass' class='col-md-12 form-control' type='password' placeholder='password' style='border-radius: 1px;'/>" +
                "<div class='col-md-12' style='padding:0;margin:0;margin-top: 1em;'><span style='color: #EB650C;' class='glyphicon glyphicon-exclamation-sign'></span> Please proceed with caution!</div>" +
                "<div class='col-md-12' style='padding:0;margin:0;'><span class='glyphicon glyphicon-exclamation-sign' style='color: #EB650C;'></span> Will cause the existing device to be unable to connect!</div>" +
                "<a href='javascript:app.operate.reset();'><button style='background: #EB650C;border: none;padding: 0.4em;color:#F2F3F7;border-radius: 4px;margin-top: 1em;' class='col-md-12'>Refresh</button></a>" +
                "</div>"
            });
        },delete:function () {
            layer.open({
                type: 1,
                area: ['32em', '24em'],
                shadeClose: true, //点击遮罩关闭
                title: "Delete",
                content: "<div class='col-md-12' style='padding: 2em;'>" +
                "<div id='changeNameTip' class='col-md-12' style='margin:0;padding: 0;'></div>" +
                "<label class='col-md-12' style='margin: 0;padding: 0;' for='confirmPass'>Password:</label>" +
                "<input id='deleteconfirmPass' class='col-md-12 form-control' type='password' placeholder='password' style='border-radius: 1px;'/>" +
                "<div class='col-md-12' style='padding:0;margin:0;margin-top: 1em;'><span style='color: #EB650C;' class='glyphicon glyphicon-exclamation-sign'></span> Please proceed with caution!</div>" +
                "<div class='col-md-12' style='padding:0;margin:0;'><span class='glyphicon glyphicon-exclamation-sign' style='color: #EB650C;'></span> Will cause the existing device to be unable to connect!</div>" +
                "<a href='javascript:app.operate.delete();'><button style='background: #EB650C;border: none;padding: 0.4em;color:#F2F3F7;border-radius: 4px;margin-top: 1em;' class='col-md-12'>Delete</button></a>" +
                "</div>"
            });
        },add:function () {
            layer.open({
                type: 1,
                area: ['24em', '34em'],
                shadeClose: true, //点击遮罩关闭
                title: "CreateApp",
                content: "<div class='col-md-12' style='padding: 2em;'>" +
                "<div id='changeNameTip' class='col-md-12' style='margin:0;padding: 0;'></div>" +
                "<label class='col-md-12' style='margin: 0;padding: 0;color: #888;' for='appname_text'>Name:</label>" +
                "<input id='appname_text' class='col-md-12 form-control' placeholder='app name' style='border-radius: 1px;'/>" +
                "<label style='margin: 0;padding: 0;margin-top: 1em;color: #888;' class='col-md-12' for='company_text'>Company/Group:</label>" +
                "<input id='company_text' class='col-md-12 form-control' placeholder='company/group' style='border-radius: 1px;'/>" +
                "<div class='col-md-12' style='margin: 0;padding: 0;margin-top: 1em;'>" +
                "<label class='col-md-6' style='margin: 0;padding: 0;color: #888;' for='type_text'>Type:</label>" +
                "<select class='col-md-6' style='margin0;background: #EB650C;border: none;color:#fff;padding: 0.3em;border-radius: 1px;'>" +
                "<option>Server</option>" +
                "<option>Android</option>" +
                "<option>Ios</option></select></div>" +
                "<label class='col-md-12' style='padding: 0;margin: 0;margin-top: 1em;color: #888;' for='confirmPass'>Password:</label>" +
                "<input id='addconfirmPass' class='col-md-12 form-control' placeholder='password' style='border-radius: 1px;'/>" +
                "<span class='glyphicon glyphicon-info-sign' style='color: #EB650C;margin-top: 1em;'></span> Means that you accept the <a href='javascript:app.utils.agreement();'>agreement</a>!" +
                "<a href='javascript:app.operate.add();'><button style='background: #EB650C;border: none;padding: 0.4em;color:#F2F3F7;border-radius: 4px;margin-top: 1em;' class='col-md-12'>Create</button></a>" +
                "</div>"
            });
        }
    }
    ,
    find:{
        init:function (developerId,developerToken) {
            
        },
        allapp:function (Params) {
            var offset = Params["offset"];
            var limit = Params["limit"];
            app.find.init($.cookie("developerId"),$.cookie("developerToken"));
            $.post(app.URL.allapp(offset,limit),{},function (result) {
                console.log(app.URL.allapp(offset,limit),result);
                if(result.success){
                    console.log("apps={}",result.data);
                    $.each(result.data,function (key,value) {
                        var data = new Date(value.appCreatetime);
                        var data=data.getFullYear()+"-"+data.getMonth()+"-"+data.getDate();
                            $("#apps_container").append("<div style='margin-left:1em;background: #FFF;box-shadow: 0px 0px 1px  2px #eee;margin-top: 1em;padding: 0;padding-bottom: 0.5em;border-radius: 1px;' class='app col-md-2'><img style='border-radius: 1px;' class='col-md-12' src='resources/img/"+value.appType+".png'/><a style='color:#333;font-weight: lighter;font-size: 1em;margin-top: 0.5em;' href='/app/"+value.appId+"' class='col-md-12'>"+value.appName.substr(0,15)+"</a><span style='color: #aaaaaa;font-size: 0.5em;' class='col-md-12'>"+value.appCompany.substr(0,15)+"</span><span style='margin-top:1em;' class='glyphicon glyphicon-time col-md-12'>"+data+"</span></div>")
                    });
                }else{
                    $("#tip").html("<strong>"+result.msg+"</strong>");
                }
            });
        },
        app:function (id) {
            $.post(app.URL.app(id), {}, function (result) {
                console.log(result);
                if(result.success){
                    $("#app_info").html("<strong class='col-md-12'>APP</strong><hr>");
                    $("#app_info").append("<p class='col-md-12'>Name : "+result.data.appName+" <a id='changeName' href='javascript:app.utils.changeName();' style='color: #EB650C;'><span class='glyphicon glyphicon-pencil'></span></a></p>");
                    $("#app_info").append("<p class='col-md-12'>Company : "+result.data.appCompany+"</p>");
                    $("#app_info").append("<p class='col-md-12'>Type : "+result.data.appType+"</p>");
                    var appKey=result.data.appKey+"";
                    var appSecretKey=result.data.appSecretKey+"";
                    $("#app_info").append("<p class='col-md-12'  style='overflow: hidden;'>AppKey : "+result.data.appKey.substr(0,20)+" <a href='javascript:app.utils.showAppKey(\""+appKey+"\");' style='color: #EB650C;'><span class='glyphicon glyphicon-option-horizontal'></span></a></p>");
                    $("#app_info").append("<p class='col-md-12' style='overflow: hidden;'>SecretKey : "+result.data.appSecretKey.substr(0,20)+" <a href='javascript:app.utils.showAppKey(\""+appSecretKey+"\");' style='color: #EB650C;'><span class='glyphicon glyphicon-option-horizontal'></span></a></p>");
                    //Up Since: 2016/8/23 下午10:44:09
                    var date = new Date(result.data.appCreatetime);
                    var hours = "";
                    if(date.getHours()<12){
                        hours = "am"+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
                    }else{
                        hours = "pm"+(date.getHours()-12)+":"+date.getMinutes()+":"+date.getSeconds();
                    }
                    date  = date.getFullYear()+"/"+date.getMonth()+"/"+date.getDay()+" "+hours;
                    $("#app_info").append("<p class='col-md-12'>CreateTime:"+date+"</p>");
                    $("#app_info").append("<p class='col-md-12'><a href='javascript:app.utils.refreshAppKey(\"RefreshKey\");' style='color: #EB650C;'><span class='glyphicon glyphicon-refresh'></span></a>" +
                        " <a href='javascript:app.utils.delete(\"DeleteApp\");' style='color: #EB650C;'><span class='glyphicon glyphicon-remove'></span></a></p>");

                    console.log("appKey={}",result.data.appKey);
                    console.log("appSecretKey={}",result.data.appSecretKey);
                    app.find.broker(result.data.appKey,result.data.appSecretKey);
                }
            });
        },refresh:function (time) {
            setTimeout(function () {
                var id = window.location.href.substr(window.location.href.indexOf("/app/")+5);
                console.log("id={}",id);
                app.find.app(id);
            },time);
        }, broker:function (appKey,appSecretKey) {
            var url=app.URL.broker(appKey,appSecretKey);
            console.log("broker_url={}",url);
            $.post(url,{},function (result,status) {
                console.log(result);
                if(status && result.success){
                    $("#virtualhost_info").html("<strong class='col-md-12'>VirtualHost</strong><hr>");
                    $.each(result.data.virtual_hosts,function (key,value) {
                            $("#virtualhost_info").append("<p class='col-md-12'>" + result.data.virtual_hosts[key] + "</p>");
                    });

                    $("#broker_info").html("<strong class='col-md-12'>Broker</strong><hr>");
                    $("#broker_info").append("<p class='col-md-12'>Instance Directory : "+result.data.base_location+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>Connected : "+result.data.connected+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>ConnectionCounter : "+result.data.connection_counter+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>"+result.data.current_time+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>Install Directory : "+result.data.home_location+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>MessagedReceived : "+result.data.messages_received+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>MessageSend : "+result.data.messages_sent+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>ReadCounter "+result.data.read_counter+"</p>");
                    $("#broker_tip").html("<p class='col-md-12'>State : "+result.data.state+"</span></p>");
                    $("#broker_info").append("<p class='col-md-12'>StartedSince : "+result.data.state_since+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>"+result.data.write_counter+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>Version : "+result.data.version+"</p>");


                    $.each(result.data.connections,function (key,val) {
                        $("#app_connect_table").append("<tr class='col-md-12'><td class='col-md-2'>"+result.data.connections[key].id+"</td><td class='col-md-10'>"+result.data.connections[key].label+"</td></tr>");
                    })

                    //jvm info
                    $("#jvm_info").html("<strong class='col-md-12'>JVM</strong><hr>");
                    $("#jvm_info").append("<p class='col-md-12' >Version : "+result.data.jvm_metrics.jvm_name+"</p>");
                    $("#jvm_info").append("<p class='col-md-12'>ClassLoaded : "+result.data.jvm_metrics.classes_loaded+"</p>");
                    $("#jvm_info").append("<p class='col-md-12'>ClassUpdated : "+result.data.jvm_metrics.classes_unloaded+"</p>");
                    $("#jvm_info").append("<p class='col-md-12'>HeapMemory : "+result.data.jvm_metrics.heap_memory+"</p>");
                    $("#jvm_info").append("<p class='col-md-12'>NonHeapMempry : "+result.data.jvm_metrics.non_heap_memory+"</p>");
                    //node info
                    $("#node_info").html("<strong class='col-md-12'>NODE</strong><hr>");
                    $("#node_info").append("<p class='col-md-12'>Name : "+result.data.jvm_metrics.os_name+"</p>");
                    $("#node_info").append("<p class='col-md-12'>Architecture : "+result.data.jvm_metrics.os_arch+"</p>");
                    $("#node_info").append("<p class='col-md-12'>NodeName : "+result.data.jvm_metrics.runtime_name+"</p>");
                    $("#node_info").append("<p class='col-md-12'>Memory Free/Total : "+result.data.jvm_metrics.os_memory_free+" / "+result.data.jvm_metrics.os_memory_total+"</p>");
                    $("#node_info").append("<p class='col-md-12'>CPUtime : "+result.data.jvm_metrics.os_cpu_time+"</p>");
                    $("#node_info").append("<p class='col-md-12'>FD Open/Max : "+result.data.jvm_metrics.os_fd_open+" / "+result.data.jvm_metrics.os_fd_max+"</p>");
                    $("#node_info").append("<p class='col-md-12'>Load Average "+result.data.jvm_metrics.os_load_average+"</p>");
                    $("#node_info").append("<p class='col-md-12'>Processor : "+result.data.jvm_metrics.os_processors+"</p>");
                    $("#node_info").append("<p class='col-md-12'>Swap Used/Available : "+result.data.jvm_metrics.os_swap_total+" / "+result.data.jvm_metrics.os_swap_free+"</p>");
                    $("#node_info").append("<p class='col-md-12'>StartedTime : "+result.data.jvm_metrics.start_time+"</p>");
                    $("#node_info").append("<p class='col-md-12'>ThreadCurrent : "+result.data.jvm_metrics.threads_current+"</p>");
                    $("#node_info").append("<p class='col-md-12'>ThreadPeak : "+result.data.jvm_metrics.threads_peak+"</p>");
                    $("#node_info").append("<p class='col-md-12'>Up Time : "+result.data.jvm_metrics.uptime+"</p>");

                    app.find.refresh(10000);
                }else {
                    $("#broker_tip").append("<p style='color: #ff0000;'><span class='glyphicon glyphicon-exclamation-sign'></span> Broker state exception!</p>" +
                                            "<p><span id='repire_cog' class='glyphicon glyphicon-cog'></span> Attempting to repair automatically!</p>" +
                                            "<p><span id='repire_cog' class='glyphicon glyphicon-cog'></span> Please Waiting.... </p>");
                    //repire ajax
                    app.find.refresh(5000);
                }
            });
        }
    },
    create:{
        createapp:function (appname) {
            
        }
    }
}