/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: EMailTest
 * Author:   hyqin
 * Date:     2019-09-30 10:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.moduletest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hyqin
 * @create 2019-09-30
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EMailTest {
    public static final String SMTPSERVER = "smtp.163.com";
    public static final String SMTPPORT = "465";  //465
    public static final String ACCOUT = "hyqin930804@163.com";
    public static final String PWD = "huangyeqin840627";

    //yefei.chen@powersi.com.cn<yefei.chen@powersi.com.cn>
    public static final String toAccount = "970259402@qq.com";
    public static final String receiveAccount = "yeqin.huang@powersi.com.cn";

    @Test
    public void sendMail() throws Exception{
        //创建邮件配置
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
        properties.setProperty("mail.smtp.host", SMTPSERVER); // 发件人的邮箱的 SMTP 服务器地址
        properties.setProperty("mail.smtp.port", SMTPPORT);
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.auth", "true"); // 需要请求认证
        properties.setProperty("mail.smtp.ssl.enable", "true");// 开启ssl

        //根据邮件配置创建会话
        Session session = Session.getDefaultInstance(properties);

        session.setDebug(true);

        MimeMessage message = writeMail(session);

        //获取传输通道
        Transport transport = session.getTransport();
        transport.connect(SMTPSERVER,ACCOUT,PWD);

        //连接，并发送邮件
        transport.sendMessage(message,message.getAllRecipients());
        transport.close();
    }

    public MimeMessage writeMail(Session session) throws Exception{
        //根据会话创建邮件
        MimeMessage message = new MimeMessage(session);

        //address 邮件地址  personal 邮件昵称  charset 编码方法
        InternetAddress fromAddress = new InternetAddress(ACCOUT,"kimi","utf-8");

        //设置邮件发送方
        message.setFrom(fromAddress);

        //设置邮件接收方
        InternetAddress receiveAddress = new InternetAddress(receiveAccount,"test","utf-8");

        message.setRecipient(Message.RecipientType.TO ,receiveAddress );

        //设置标题
        message.setSubject("测试标题","utf-8");
        //设置文本
        message.setText("我是个程序员，一天我坐在路边一边喝水一边苦苦检查程序。 这时一个乞丐在我边上坐下了，开始要饭，我觉得可怜，就给了他1块钱。 然后接着调试程序。他可能生意不好，就无聊的看看我在干什么，然后过了一会，他缓缓地指着我的屏幕说，这里少了个分号");

        //设置显示的发送时间
        message.setSentDate(new Date());

        message.saveChanges();
        return  message;
    }

}
