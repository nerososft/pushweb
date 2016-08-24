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
        }
    },
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
                    $("#app_info").append("<p class='col-md-12'>Name:"+result.data.appName+" <a style='color: #EB650C;'><span class='glyphicon glyphicon-pencil'></span></a></p>");
                    $("#app_info").append("<p class='col-md-12'>Company:"+result.data.appCompany+"</p>");
                    $("#app_info").append("<p class='col-md-12'>Type:"+result.data.appType+"</p>");
                    $("#app_info").append("<p class='col-md-12'  style='overflow: hidden;'>AppKey:"+result.data.appKey.substr(0,20)+" <a style='color: #EB650C;'><span class='glyphicon glyphicon-option-horizontal'></span></a> <a style='color: #EB650C;'><span class='glyphicon glyphicon-refresh'></span></a></p>");
                    $("#app_info").append("<p class='col-md-12' style='overflow: hidden;'>SecretKey:"+result.data.appSecretKey.substr(0,20)+" <a style='color: #EB650C;'><span class='glyphicon glyphicon-option-horizontal'></span></a> <a style='color: #EB650C;'><span class='glyphicon glyphicon-refresh'></span></a></p>");
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
                    console.log("appKey={}",result.data.appKey);
                    console.log("appSecretKey={}",result.data.appSecretKey);
                    app.find.broker(result.data.appKey,result.data.appSecretKey);
                }
            });
        },
        broker:function (appKey,appSecretKey) {
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
                    $("#broker_info").append("<p class='col-md-12'>Instance Directory:"+result.data.base_location+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>Connected:"+result.data.connected+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>ConnectionCounter:"+result.data.connection_counter+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>"+result.data.current_time+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>Install Directory"+result.data.home_location+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>MessagedReceived:"+result.data.messages_received+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>MessageSend:"+result.data.messages_sent+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>ReadCounter"+result.data.read_counter+"</p>");
                    $("#broker_tip").html("<p class='col-md-12'>State:"+result.data.state+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>StartedSince:"+result.data.state_since+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>"+result.data.version+"</p>");
                    $("#broker_info").append("<p class='col-md-12'>Version:"+result.data.write_counter+"</p>");


                    $.each(result.data.connections,function (key,val) {
                        $("#app_connect_table").append("<tr class='col-md-12'><td class='col-md-2'>"+result.data.connections[key].id+"</td><td class='col-md-10'>"+result.data.connections[key].label+"</td></tr>");
                    })

                    //jvm info
                    $("#jvm_info").html("<strong class='col-md-12'>JVM</strong><hr>");
                    $("#jvm_info").append("<p class='col-md-12' >Version:"+result.data.jvm_metrics.jvm_name+"</p>");
                    $("#jvm_info").append("<p class='col-md-12'>ClassLoaded:"+result.data.jvm_metrics.classes_loaded+"</p>");
                    $("#jvm_info").append("<p class='col-md-12'>ClassUpdated:"+result.data.jvm_metrics.classes_unloaded+"</p>");
                    $("#jvm_info").append("<p class='col-md-12'>HeapMemory:"+result.data.jvm_metrics.heap_memory+"</p>");
                    $("#jvm_info").append("<p class='col-md-12'>NonHeapMempry:"+result.data.jvm_metrics.non_heap_memory+"</p>");
                    //node info
                    $("#node_info").html("<strong class='col-md-12'>NODE</strong><hr>");
                    $("#node_info").append("<p class='col-md-12'>Name:"+result.data.jvm_metrics.os_name+"</p>");
                    $("#node_info").append("<p class='col-md-12'>Architecture:"+result.data.jvm_metrics.os_arch+"</p>");
                    $("#node_info").append("<p class='col-md-12'>NodeName:"+result.data.jvm_metrics.runtime_name+"</p>");
                    $("#node_info").append("<p class='col-md-12'>Memory Free/Total:"+result.data.jvm_metrics.os_memory_free+" / "+result.data.jvm_metrics.os_memory_total+"</p>");
                    $("#node_info").append("<p class='col-md-12'>CPUtime:"+result.data.jvm_metrics.os_cpu_time+"</p>");
                    $("#node_info").append("<p class='col-md-12'>FD Open/Max:"+result.data.jvm_metrics.os_fd_open+" / "+result.data.jvm_metrics.os_fd_max+"</p>");
                    $("#node_info").append("<p class='col-md-12'>Load Average"+result.data.jvm_metrics.os_load_average+"</p>");
                    $("#node_info").append("<p class='col-md-12'>Processor:"+result.data.jvm_metrics.os_processors+"</p>");
                    $("#node_info").append("<p class='col-md-12'>Swap Used/Available: "+result.data.jvm_metrics.os_swap_total+" / "+result.data.jvm_metrics.os_swap_free+"</p>");
                    $("#node_info").append("<p class='col-md-12'>StartedTime:"+result.data.jvm_metrics.start_time+"</p>");
                    $("#node_info").append("<p class='col-md-12'>ThreadCurrent:"+result.data.jvm_metrics.threads_current+"</p>");
                    $("#node_info").append("<p class='col-md-12'>ThreadPeak:"+result.data.jvm_metrics.threads_peak+"</p>");
                    $("#node_info").append("<p class='col-md-12'>Up Time:"+result.data.jvm_metrics.uptime+"</p>");

                }else {
                    $("#broker_tip").append("<p style='color: #ff0000;'><span class='glyphicon glyphicon-exclamation-sign'></span> Broker state exception!</p><p><span id='repire_cog' class='glyphicon glyphicon-cog'></span> Attempting to repair automatically!</p><p><span id='repire_cog' class='glyphicon glyphicon-cog'></span> Please Waiting.... </p>");
                    //repire ajax
                    setTimeout(function () {
                        var id = window.location.href.substr(window.location.href.indexOf("/app/")+5);
                        console.log("id={}",id);
                        app.find.app(id);
                    },5000);
                }
            });
        }
    },
    create:{
        createapp:function (appname) {
            
        }
    }
}