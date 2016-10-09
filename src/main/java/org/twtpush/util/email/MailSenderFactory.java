package org.twtpush.util.email;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-4
 * time: 下午4:30.
 */
public class MailSenderFactory {

    /**
     * 服务邮箱
     */
    private static SimpleMailSender serviceSms = null;

    /**
     * 获取邮箱
     *
     * @param type 邮箱类型
     * @return 符合类型的邮箱
     */
    public static SimpleMailSender getSender(MailSenderType type) {
        if (type == MailSenderType.SERVICE) {
            if (serviceSms == null) {
                serviceSms = new SimpleMailSender("click@smilewithu.com",
                        "c.l.i.c.k.123");
            }
            return serviceSms;
        }
        return null;
    }

}
