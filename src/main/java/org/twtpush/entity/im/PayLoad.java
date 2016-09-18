package org.twtpush.entity.im;

/**
 * 数据协议
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-5
 * time: 上午11:54.
 */
class PayLoadHead{
    /**
     * 消息头
     * img 图片文件(调起ImgView)
     * url 链接(调起WebView)
     * audio 声音(调起相应播放器)
     * video
     * user 用户信息
     * map 地址信息(调起MapSDK)
     * file 其他文件
     * friends 好友申请
     */
    private PayLoadType type;
}
class PayLoadBody{
    private String head;
    private String msg;
}
public final class PayLoad {


    private final PayLoadHead payloadHead;//消息头(img,url,audio,video,file,friends,)

    private final PayLoadBody payloadBody;//消息体

    public PayLoad(PayLoadHead payloadHead, PayLoadBody payloadBody) {
        this.payloadHead = payloadHead;
        this.payloadBody = payloadBody;
    }
}
