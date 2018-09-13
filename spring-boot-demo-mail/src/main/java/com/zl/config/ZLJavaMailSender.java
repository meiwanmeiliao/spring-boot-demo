package com.zl.config;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

/**
 * @AUTH zhuolin
 * @DATE 2018/9/11
 * @description:
 **/
@Configuration
@EnableConfigurationProperties(MailProperties.class)
public class ZLJavaMailSender extends JavaMailSenderImpl implements JavaMailSender {

    private ArrayList<String> userNameList;

    private ArrayList<String> passwordList;

    private int currentMailId = 0;

    private final MailProperties properties;

    public ZLJavaMailSender(MailProperties properties) {
        this.properties = properties;
        if (userNameList == null) {
            userNameList = new ArrayList<>();
        }

        String[] userNames = this.properties.getUsername().split(",");
        if (userNames != null) {
            for (String user : userNames) {
                userNameList.add(user);
            }
        }

        // 初始化密码
        if (passwordList == null)
            passwordList = new ArrayList<String>();
        String[] passwords = this.properties.getPassword().split(",");
        if (passwords != null) {
            for (String pw : passwords) {
                passwordList.add(pw);
            }
        }
    }

    @Override
    protected void doSend(MimeMessage[] mimeMessage, Object[] object) throws MailException {
        super.setUsername(userNameList.get(currentMailId));
        super.setPassword(passwordList.get(currentMailId));

        // 设置编码和各种参数
        super.setHost(this.properties.getHost());
        super.setDefaultEncoding(this.properties.getDefaultEncoding().name());
        super.setJavaMailProperties(asProperties(this.properties.getProperties()));
        super.doSend(mimeMessage, object);

        // 轮询
        currentMailId = (currentMailId + 1) % userNameList.size();
    }

    private Properties asProperties(Map<String, String> source) {
        Properties properties = new Properties();
        properties.putAll(source);
        return properties;
    }

    @Override
    public String getUsername() {
        return userNameList.get(currentMailId);
    }

}
