package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by GeoLin on 2017/5/25.
 */
@Controller
public class GrabController {
    @RequestMapping(value = "/grab",method = RequestMethod.GET)
    public String grabHabits(){

        return "/grab";
    }

    @RequestMapping(value = "/garb",method = RequestMethod.POST)
    public String grabing(){
//        TODO their habits should post with a form or whatever,it should be done with webflow.
        return "/grab";
    }
}
