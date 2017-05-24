package controller;

import data.JdbcUserRepository;
import data.User;
import data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
    private JdbcUserRepository userRepository;
//    TODO Repository how to inject, make it not null...CrudRepository.interface seems well

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerPage(Model model){
        model.addAttribute(new User());
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String processRegister(@Valid User user,Errors errors){
        if(errors.hasErrors()){
            return "/register";
        }

        userRepository.save(user);
        return "redirect:/user/"+user.getUsername();
    }

    @RequestMapping("/{username}")
    public String showUserProfile(@PathVariable String username,Model model){
        User user=userRepository.findByUsername(username);
        model.addAttribute(user);
        return "profile";
    }

}
