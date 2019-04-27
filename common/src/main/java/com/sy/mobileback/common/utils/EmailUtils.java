package com.sy.mobileback.common.utils;

import com.sun.mail.util.MailSSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-21 16:43
 */
@Component
@ConfigurationProperties(prefix = "mailbox")
public class EmailUtils {

    private static Logger logger = LoggerFactory.getLogger(EmailUtils.class);
    //邮件服务器主机名
    // QQ邮箱的 SMTP 服务器地址为: smtp.qq.com

    private  String emailSMTPHost ;

    //发件人邮箱
    private  String number ;

    //发件人邮箱密码（授权码）
    //在开启SMTP服务时会获取到一个授权码，把授权码填在这里
    private  String authorizedCode ;

    private  String subject ;

    private  String officalWebsite;

    private  String emailProtocolName;

    private  String nickName;

    @Bean(value = "emailEntity")
    public EmailUtils accessConnection() {
        return new EmailUtils();
    }

    @Transactional
    public boolean passwordSendEmail(String emailSendTo, String password) {

        Properties props = new Properties();

        // 开启debug调试
        props.setProperty("mail.debug", "true");

        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");

        // 端口号
        props.put("mail.smtp.port", 465);

        // 设置邮件服务器主机名
        props.setProperty("mail.smtp.host", emailSMTPHost);

        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol",emailProtocolName );

        /**SSL认证，注意腾讯邮箱是基于SSL加密的，所以需要开启才可以使用**/
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            logger.error("邮箱 ssl 认证 出现问题");
            return false;
        }
        sf.setTrustAllHosts(true);

        //设置是否使用ssl安全连接（一般都使用）
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        //创建会话
        Session session = Session.getInstance(props);

        //获取邮件对象
        //发送的消息，基于观察者模式进行设计的
        Message msg = new MimeMessage(session);
        try {
            msg.setSubject(subject);
            //设置邮件内容
            //使用StringBuilder，因为StringBuilder加载速度会比String快，而且线程安全性也不错
            StringBuilder builder = new StringBuilder();
            //写入内容
            builder.append("\n" + "您的新密码为:" + password);
            //写入我的官网
            builder.append("\n官网:" + officalWebsite);

            //定义要输出日期字符串的格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            //在内容后加入邮件发送的时间
            builder.append("\n时间：" + sdf.format(new Date()));

            //设置显示的发件时间
            msg.setSentDate(new Date());

            //设置邮件内容
            msg.setText(builder.toString());

            //设置发件人邮箱
            // InternetAddress 的三个参数分别为: 发件人邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
            msg.setFrom(new InternetAddress(number, nickName, "UTF-8"));
        } catch (MessagingException e) {

            e.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }

//        /得到邮差对象
        Transport transport = null;
        try {
            transport = session.getTransport();
            //连接自己的邮箱账户
            //密码不是自己QQ邮箱的密码，而是在开启SMTP服务时所获取到的授权码
            //connect(host, user, password)
            transport.connect(emailSMTPHost, number, authorizedCode);
            //发送邮件
            transport.sendMessage(msg, new Address[]{new InternetAddress(emailSendTo)});
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public String getEmailSMTPHost() {
        return emailSMTPHost;
    }

    public void setEmailSMTPHost(String emailSMTPHost) {
        this.emailSMTPHost = emailSMTPHost;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAuthorizedCode() {
        return authorizedCode;
    }

    public void setAuthorizedCode(String authorizedCode) {
        this.authorizedCode = authorizedCode;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOfficalWebsite() {
        return officalWebsite;
    }

    public void setOfficalWebsite(String officalWebsite) {
        this.officalWebsite = officalWebsite;
    }

    public String getEmailProtocolName() {
        return emailProtocolName;
    }

    public void setEmailProtocolName(String emailProtocolName) {
        this.emailProtocolName = emailProtocolName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
