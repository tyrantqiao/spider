package launch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by GeoLin on 2017/5/21.
 */
@SpringBootApplication(scanBasePackages = "controller")
public class GrabApplicationEngine {
    public static void main(String[] args){
        SpringApplication.run(GrabApplicationEngine.class,args);
    }
}
