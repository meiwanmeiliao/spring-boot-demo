package com.zl.config;

import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @AUTH zhuolin
 * @DATE 2018/9/11
 * @description:
 **/
@Component
public class JavaMailComponent {

    private static final String TEMPLATES = "mail.ftl";

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Autowired
    private ZLJavaMailSender javaMailSender;

    public void sendMail(String mail) {
        Map<String, Object> map = new HashMap<>();
        map.put("mail", mail);
        try {
            String text = getTextByTemplate(TEMPLATES, map);
            send(mail, text);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private String getTextByTemplate(String template, Map<String, Object> model) throws IOException, TemplateException {
        return FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerConfigurer.getConfiguration().getTemplate(template), model);
    }

    private String send(String mail, String text) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        InternetAddress from = new InternetAddress();
        from.setAddress(javaMailSender.getUsername());
        from.setPersonal("😀", "UTF-8");
        helper.setFrom(from);
        helper.setText(mail);
        helper.setTo(new String[]{"18325569073@163.com"});
//        helper.
        helper.setSubject("邮件11");
        helper.setText(text, true);
        javaMailSender.send(message);
        return text;
    }


}
