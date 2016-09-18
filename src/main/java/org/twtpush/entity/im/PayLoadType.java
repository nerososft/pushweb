package org.twtpush.entity.im;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-18
 * time: 上午8:45.
 */
public enum PayLoadType {
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
    IMG("img"),

    URL("url"),

    AUDIO("audio"),

    VIDEO("video"),

    USERINFO("user"),

    MAP("map"),

    FILE("file"),

    FRIEND("friend"),

    GROUP("group");


    private String name;

    PayLoadType(String name) {
        this.name = name;
    }
}
