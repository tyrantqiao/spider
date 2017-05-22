package controller;

import data.User;
import data.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by GeoLin on 2017/5/22.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private UserRepository userRepository;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String processLogin(@Valid User user,Errors errors){
        if(errors.hasErrors()){
            return "/login";
        }

        userRepository.save(user);
        return "redirect:/user/"+user.getUserName();
    }

    @RequestMapping("/{userName")
    public String showUserProfile(@PathVariable String userName,Model model){
        User user=userRepository.findByUsername(userName);
        model.addAttribute(user);
        return "profile";
    }

}
