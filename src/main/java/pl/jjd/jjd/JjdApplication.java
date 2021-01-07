package pl.jjd.jjd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.jjd.jjd.utils.JsonReader;


import java.util.*;


@SpringBootApplication
public class JjdApplication  {


    private JsonReader jsonReader;

    public JjdApplication(JsonReader jsonReader) {
        this.jsonReader = jsonReader;
    }

    public static void main(String[] args) {
        SpringApplication.run(JjdApplication.class, args);
    }

}
