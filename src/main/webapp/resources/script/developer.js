var developer={
    URL:{
        login:function (developerEmail,developerPassword) {
            return "/developer/"+developerEmail+"/"+developerPassword+"/login";
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
                $.post(developer.URL.login(params['developerEmail'],params["developerPassword"]),
                    {},
                    function (result) {
                    if(result&&result.success){
                        $("#tip").html("<span>"+result.data.msg+"</span>");
                        if(result.data.state){
                            $.cookie('developerId', result.data.developer.developerId, { expires: 7 }); // 存储一个带7天期限的 cookie
                            $.cookie('developerToken', result.data.developer.developerToken, { expires: 7 });
                        }
                    }else{
                        $("#tip").html("<span>email not format!</span>");
                    }
                });
            }else{
                $("#tip").html("<span>email not format!</span>");
            }
        }
    }
}