package pl.jjd.jjd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;



@SpringBootApplication
public class JjdApplication  {


    public static void main(String[] args) {
        SpringApplication.run(JjdApplication.class, args);
    }
    @Bean
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
}
