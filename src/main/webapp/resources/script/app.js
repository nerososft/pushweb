var app = {
    URL:{
        allapp:function (offset,limit) {
            return "app/"+$.cookie("developerId")+"/"+$.cookie("developerToken")+"/auth/"+offset+"/"+limit+"/apps";
        },
        app:function () {
            
        }
    },
    find:{
        init:function (developerId,developerToken) {
            
        },
        allapp:function (Params) {
            var offset = Params["offset"];
            var limit = Params["limit"];
            app.find.init($.cookie("developerId",$.cookie("developerToken")));
            $.post(app.URL.allapp(offset,limit),{},function (result) {
                if(result.success){
                    console.log("apps={}",result.data);
                }else{
                    $("#tip").html("<strong>"+result.msg+"</strong>");
                }
            });
        },
        app:function (id) {
            
        }
    },
    create:{
        createapp:function (appname) {
            
        }
    }
}