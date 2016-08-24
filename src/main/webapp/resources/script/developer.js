var developer={
    URL:{
        login:function (developerEmail,developerPassword) {
            return "/developer/"+developerEmail+"/"+developerPassword+"/login";
        },
        auth:function (developerId,developerToken) {
            return "/developer/"+developerId+"/"+developerToken+"/auth";
        }
    },
    validateEmail:function (email) {
        //对电子邮件的验证
        var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        if(!myreg.test(email)){
            return false;
        }
        return true;
    },
    login:{
        init : function (params) {
            var developerEmail = params['developerEmail'];
            var developerPassword = params['developerPassword'];
            if (!developer.validateEmail(developerEmail)){
                return false;
            }
            return true;
        },
        login:function (params) {
            if(developer.login.init(params)){
                var url =developer.URL.login(params['developerEmail'],params["developerPassword"]);
                console.log("login:","http://localhost:8080"+url);
                $.post(url,
                    {},
                    function (result) {
                    if(result&&result.success){
                        $("#tip").html("<span style='color: #EB650C;'><span style='color: #EB650C;' class='glyphicon glyphicon-bell'></span> "+result.data.msg+"</span>");
                        if(result.data.state){
                            console.log("developerToken={}",result.data.developer.developerToken);
                            $.cookie('developerId', result.data.developer.developerId, { expires: 7 ,path:"/"}); // 存储一个带7天期限的 cookie
                            $.cookie('developerToken', result.data.developer.developerToken, { expires: 7 ,path:"/"});
                            console.log("cookieToken={}",$.cookie("developerToken"));

                            window.location.href="/";
                        }
                    }else{
                        $("#tip").html("<span style='color: #EB650C;'><span style='color: #EB650C;' class='glyphicon glyphicon-bell'></span> server error!</span>");
                    }
                });
            }else{
                $("#tip").html("<span style='color: #EB650C;'><span style='color: #EB650C;' class='glyphicon glyphicon-bell'></span> email not format!</span>");
            }
        }
    },
    auth:function () {
        if(!$.cookie("developerId")||!$.cookie("developerToken")){
            window.location.href="/developer/login";
        }else{
            var url=developer.URL.auth($.cookie("developerId"),$.cookie("developerToken"));
            console.log("auth","http://localhost:8080/"+url);
            $.post(url,{},
                function (result) {
               if(!result || !result.success){
                   window.location.href="/developer/login";
               } else{
                   $("#developerName").html("<a style='font-weight: lighter;' href='javascript:;'><p style='background: #EB650C;width: 1.5em;height: 1.5em;border-radius: 1.5em;text-align: center;line-height: 1.5em;color: #FFFFFF;text-decoration: none;'>"+result.data.developerName.substr(0,1).toUpperCase()+"</p></a>")
               }
            });
        }
    }
}