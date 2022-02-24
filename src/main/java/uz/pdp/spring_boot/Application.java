package uz.pdp.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.pdp.spring_boot.config.PasswordEncoderConfigurations;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
       // PasswordEncoderConfigurations passwordEncoderConfigurations=new PasswordEncoderConfigurations();
         SpringApplication.run(Application.class, args);
    }

}

