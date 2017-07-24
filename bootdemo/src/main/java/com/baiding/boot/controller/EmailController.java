package com.baiding.boot.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by BaiDing on 2017/7/23.
 *
 * 测试邮件服务
 */
@RestController
public class EmailController {

    @Autowired
    private JavaMailSender javaMailSender;
//    @Autowired
//    private FreeMarkerConfigurer freeMarkerConfigurer;
    /**
     * 发送一封简单的邮件
     */
    @RequestMapping("/simpleEmail")
    public void sendSimpleEmail(){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("1203544126@qq.com");
        message.setTo("1307054402@qq.com");
        message.setSubject("测试邮件(邮件主题)");
        message.setText("这是邮件内容");

        //发送简单邮件
        javaMailSender.send(message);
    }

    /**
     *发送一封带附件的邮件
     */
    @RequestMapping("/attachmentEmail")
    public void  sendAttachmentsEmail() throws Exception{
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);

        helper.setFrom("1203544126@qq.com");
        helper.setTo("1307054402@qq.com");
        helper.setSubject("主题：含有附件");
        helper.setText("有附件的邮件");

        FileSystemResource file1=new FileSystemResource(new File("D:/data/www/wifiin/upload/2011.jpg"));
        FileSystemResource file2=new FileSystemResource(new File("D:/git/doc/运维/服务器程序发布流程.txt"));

        helper.addAttachment("附件1.jpg",file1);
        helper.addAttachment("附件2.txt",file2);

        javaMailSender.send(mimeMessage);


    }

    /**
     * 发送内嵌了静态资源的邮件
     */
    @RequestMapping("/inlineEmail")
    public  void sendInlineEmail() throws Exception{
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);

        helper.setFrom("1203544126@qq.com");
        helper.setTo("1307054402@qq.com");
        helper.setSubject("主题嵌入静态资源");


//        StringBuffer sb=new StringBuffer();
//        sb.append("<h1>大标题</h1>")
//            .append("<p style='color:#F00'>红色字</p>")
//            .append("<p style='text-align:right'>右对齐</p>");
//        helper.setText(sb.toString(), true);

        helper.setText("<html><body><img src='cid:11'><p><img src='cid:22'></body></html>",true);
        FileSystemResource file1 = new FileSystemResource(new File("D:/data/www/wifiin/upload/2011.jpg"));
        FileSystemResource file2 = new FileSystemResource(new File("D:/data/www/wifiin/upload/24631.jpg"));
        helper.addInline("11", file1);
        helper.addInline("22", file2);

        javaMailSender.send(mimeMessage);
    }

    @RequestMapping("/templateEmail")
    public void templateEmail() throws Exception{
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);

//        helper.setFrom("1203544126@qq.com");
        //将显示在邮件里的发件人替换成自己的名字哦
        helper.setFrom(new InternetAddress("1203544126@qq.com","咸鱼", "UTF-8"));
        helper.setTo("1307054402@qq.com");
        helper.setSubject("主题:模板邮件");

        Map<String,Object> model =new HashMap<>();
        model.put("userName","刘俊");

        //读取 html 模板
        Configuration cfg=new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        // 设定去哪里读取相应的ftl模板
        cfg.setClassForTemplateLoading(this.getClass(), "/templates");
        // 在模板文件目录中寻找名称为name的模板文件
        Template template   = cfg.getTemplate("email.ftl");

        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        helper.setText(html, true);

        javaMailSender.send(mimeMessage);
    }

}
