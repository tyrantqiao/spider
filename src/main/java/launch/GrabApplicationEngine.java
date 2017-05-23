package launch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by GeoLin on 2017/5/21.
 */
@SpringBootApplication(scanBasePackages = "controller")
@ComponentScan("data")
public class GrabApplicationEngine {
    public static void main(String[] args){
        SpringApplication.run(GrabApplicationEngine.class,args);
    }
}
