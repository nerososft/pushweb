# 天鸽云通用API VERSION v1.0
## 开发者验证
### <font color = "#5791c1">功能描述<font>
使用云平台开发者帐号获取操作 token
### <font color = "#5791c1">调用地址<font>
https://api.domain/developer
### <font color = "#5791c1">请求示例<font>
```sh
curl -X POST -v http://10.0.0.173:60613/developer/testemail@testemail.com/testnewpassword/login
```
### <font color="#5791c1">返回示例<font>
```http
< HTTP/1.0 200 OK
< Content-Type:application/json
```
```json
{
  "success":"true",
  "data": {
    "state": "true",
    "msg": "login success!",
    "resultCode": 1003,
    "developer": {
      "developerName": "neroyang",
      "developerEmail": "testemail@testemail.com",
      "developerToken": "269584904d621777b67fd7af3e3dfcf7",
      "developerId": 3
    }
  }
}

```

## 获取应用列表
### <font color = "#5791c1">功能描述<font>
获取当前开发者在云平台创建的应用信息
### <font color = "#5791c1">调用地址<font>
https://api.domain/app
### <font color = "#5791c1">请求示例<font>
```sh
curl -X POST -v http://10.0.0.173:60613/app/3/269584904d621777b67fd7af3e3dfcf7/auth/0/10/apps
```
### <font color="#5791c1">返回示例<font>
```http
< HTTP/1.0 200 OK
< Content-Type:application/json
```
```json
{
  "success":true,
  "data":[
    {
      "appId":37,
      "appName":"wenjin",
      "appKey":"wenjin_4a722d767e779f7936111a64ad3288f5",
      "appSecretKey":"fe283b635bc7755168dd7798023e1d14159fdbee59669eef5a18e68dfdd10f36528c553e6eec88595e73d87c019fe988",
      "appDeveloperId":3,
      "appType":"server",
      "appCompany":"twtstudio",
      "appCreatetime":1472042681000
    },
    {
      "appId":38,
      "appName":"party",
      "appKey":"party_036bc5fa4017077fbec4ff245025d843",
      "appSecretKey":"d8ef79eaa6797dea0a57daba55002aa1dca98290bda7ff3e996333c4a7107495f0507375fb4208295df31d029f4208a0",
      "appDeveloperId":3,
      "appType":"server",
      "appCompany":"twtstudio",
      "appCreatetime":1472042690000
    },
    {
      "appId":39,
      "appName":"weipeiyang",
      "appKey":"weipeiyang_b1c01712576c792d8148cbcba327e06d",
      "appSecretKey":"7696b7e30369f8e0ec0016a7816381cbdd2999e01792a1abab46a44404d3b70640af09535d24b8d4fddc36158a110853",
      "appDeveloperId":3,
      "appType":"server",
      "appCompany":"twtstudio",
      "appCreatetime":1472042700000
    },
    {
      "appId":42,
      "appName":"weipeiyang",
      "appKey":"weipeiyang_096fe5929baa3aaec86c83fb26297bcb",
      "appSecretKey":"0dc3c419c0121a12f0027c8e5b554c07118d5161b98ad911f146388bd2564fae05fc3b0bf8bbdc13bade9024541550c7",
      "appDeveloperId":3,
      "appType":"server",
      "appCompany":"twtstudio",
      "appCreatetime":1472106327000
    }
  ],
  "error":null
}
```
# 天鸽 API -Version 1.0



## 推送概述

### <font color="#5791c1">功能说明<font>

向某单个设备或者某设备列表推送一条通知、或者消息。
推送的内容只能是 JSON 表示的一个推送对象。


### <font color="#5791c1">调用地址<font>

POST http://10.0.0.173:8080/push

### <font color="#5791c1">请求示例<font>

```sh
  curl -X POST -v http://10.0.0.173:8080/push/3/269584904d621777b67fd7af3e3dfcf7/auth/10.0.0.173:60613/wenjin/wenjin_4a722d767e779f7936111a64ad3288f5/fe283b635bc7755168dd7798023e1d14159fdbee59669eef5a18e68dfdd10f36528c553e6eec88595e73d87c019fe988/version/{"head": {"type": "VERSION"},"body":{"head":"iOS","msg":"你确定要退学吗？"}}/push
```
### <font color="#5791c1">返回示例<font>
```http
< HTTP/1.0 200 OK
< Content-Type:application/json
```
```json
{ "state":"true","msg":"推送成功","resultCode":100002 }

```
## 调用验证
{ variable }
http://domain/push/{developerId}/{developerToken}/auth/{broker}/{appname}/{appkey}/{appsecretkey}/{policy}/{content}/push

## content 协议
| 关键字 | 选项 | 含义 |
|-------|-----|------|
| head | 必填 | 通过 head 进行「推送类型」的判断 |
| body | 必填 | 推送消息的主体 |

### <font color = "#5791c1">示例与说明<font>

```json
{
  "head": {
    "type": "VERSION"
  },
  "body": {
    "head": "iOS",
    "msg": "修复了一系列bug"
  }
}
```

## head: 消息类型
其中的 `type` 字段代表推送类型。其关键字分别为 `VERSION`, `NORMAL`

## body.head: `head` 对应关键字
此关键字为 `head` 对应关键字，代表 `head` 操作的相关信息。
当 `head.type` 为 `VERSION` 时，该关键字可选 `iOS` 或 `Android`。
当 `head.type` 为 `NORMAL` 时目前可由服务端自己定义，代表客户端相应操作
## body.msg: 消息主体
此关键字为 JSON 表示的消息对象，可由服务端与客户端协定，例如：
```json
{
  "sound": "2",
  "pic": {
    "name": "pic_demo",
    "url": "http://www.baidu.com"
  },
  "title": "这是推送标题",
  "content": "这是推送内容"
}
```
长度小于1024即可.
## 获取推送策略组
### <font color="#5791c1">功能说明<font>

支持多种推送接口，包括全量、单个、批量推送等。
推送策略一般为批量或全量推送.
### <font color="#5791c1">调用地址<font>

POST https://api.domain/policy

### <font color="#5791c1">请求示例<font>

```sh
  curl -X POST -v http://10.0.0.173:8080/policy/3/269584904d621777b67fd7af3e3dfcf7/auth/37/list/0/10
```
### <font color="#5791c1">返回示例<font>
```http
< HTTP/1.0 200 OK
< Content-Type:application/json
```
```json
{
  "success":true,
  "data":[
    {
      "policyId":1006,
      "appId":37,
      "policyName":"/scs",
      "createTime":null
    },
    {
      "policyId":1008,
      "appId":37,
      "policyName":"/scs/boy",
      "createTime":null
    },
    {
      "policyId":1012,
      "appId":37,
      "policyName":"/version",
      "createTime":null
    }
  ],
    "error":null
}
```
## IOS推送
### <font color = "#5791c1">功能描述<font>
IOS推送
### <font color = "#5791c1">调用地址<font>
https://api.domain/push
### <font color = "#5791c1">请求示例<font>
```sh
curl -X POST -v http://10.0.0.173:60613/push/{developerId}/{developerToken}/auth/{appKey}/{secretKey}/{deviceToken}/{content}/push
```
### <font color = "#5791c1">返回示例<font>
```http
< HTTP/1.0 200 OK
< Content-Type:application/json
```
```json
{ "state":"true","msg":"推送成功","resultCode":100002 }

```
## 历史消息
### <font color = "#5791c1">功能描述<font>
获取某应用历史推送消息
### <font color = "#5791c1">调用地址<font>
https://api.domain/msg
### <font color = "#5791c1">请求示例<font>
```sh
curl -X POST -v http://10.0.0.173:60613/msg/wenjin_4a722d767e779f7936111a64ad3288f5/fe283b635bc7755168dd7798023e1d14159fdbee59669eef5a18e68dfdd10f36528c553e6eec88595e73d87c019fe988/3/msg
```
### <font color = "#5791c1">返回示例<font>
```http
< HTTP/1.0 200 OK
< Content-Type:application/json
```
```json
{
"success":true,
  "data":[
    {
      "id":1,
      "appId":3,
      "msg":"test",
      "topic":wenjin/scs,
      "device_type":"ANDROID",
      "ctime":null
    },
    {
      "id":1,
      "appId":3,
      "msg":"test",
      "topic":wenjin/scs,
      "device_type":"ANDROID",
      "ctime":null
    }, 
    {
      "id":1,
      "appId":3,
      "msg":"test",
      "topic":wenjin/scs,
      "device_type":"ANDROID",
      "ctime":null
    }
  ],
  "error":null
}
```
## 推送策略(精准推送)
### 推送说明:
1.推送策略仅对android有效，IOS暂无推送策略方案（后期或用线程池解决），请暂时用 `deviceToken` 。
2.`!!!非常严重`安卓推送请求策略中`/`请用`_`代替。
### 安卓推送策略说明
#### 策略示例 
1.`scs`
2.`scs_boy`
3.`scs_boy_305218102`
4.`...`
注：3策略可收到2策略，2策略可收到1策略
