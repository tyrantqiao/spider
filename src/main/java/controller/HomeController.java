package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.Template;

import javax.annotation.Resource;

/**
 * Created by GeoLin on 2017/5/21.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(){

        return "home";
    }
}
