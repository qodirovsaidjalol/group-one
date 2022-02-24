package uz.pdp.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.pdp.spring_boot.config.PasswordEncoderConfigurations;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//
//        PasswordEncoderConfigurations passwordEncoderConfigurations = new PasswordEncoderConfigurations();
//        String str = passwordEncoderConfigurations.passwordEncoder().encode("123");
//        System.out.println(str);
    }

}

