# TwTPushKit API -Version 1.0



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
    "msg": "你确定要退学吗？"
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
  "pic": "1",
  "title": "这是推送标题",
  "content": "这是推送内容"
}
```
