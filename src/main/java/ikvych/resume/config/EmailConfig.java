package ikvych.resume.config;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.security.GeneralSecurityException;
import java.util.Properties;

@Configuration
public class EmailConfig {

    @Autowired
    private ConfigurableEnvironment environment;

    @Bean
    public JavaMailSender mailSender() throws GeneralSecurityException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(environment.getRequiredProperty("email.smtp.server"));
        mailSender.setUsername(environment.getRequiredProperty("email.smtp.username"));
        mailSender.setPassword(environment.getRequiredProperty("email.smtp.password"));
        mailSender.setPort(Integer.parseInt(environment.getRequiredProperty("email.smtp.port")));
        mailSender.setDefaultEncoding("UTF-8");
        mailSender.setJavaMailProperties(javaMailProperties());
        return mailSender;
    }

    private Properties javaMailProperties() throws GeneralSecurityException {
        Properties p = new Properties();
        p.setProperty("mail.smtp.auth", "true");
        p.setProperty("mail.smtp.starttls.enable", "true");
        MailSSLSocketFactory socketFactory= new MailSSLSocketFactory();
        socketFactory.setTrustAllHosts(true);
        p.put("mail.smtp.ssl.socketFactory", socketFactory);
        return p;
    }

}
