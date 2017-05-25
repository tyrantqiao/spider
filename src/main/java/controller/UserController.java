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
@ComponentScan(basePackages = {"data"})
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }
//    TODO Repository how to inject, make it not null...CrudRepository.interface seems well

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerPage(Model model){
        model.addAttribute(new User());
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String processRegister(@Valid User user,Errors errors){
        if(errors.hasErrors()){
            System.out.println("got error");
            return "/error";
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

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute(new User());
        return "/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String processLogin(@Valid User user,Errors errors){
        if(errors.hasErrors()){
            System.out.println("input type's error");
            return "/login";
        }
        User searchUser;
        try {
            searchUser = userRepository.findByUsername(user.getUsername());
            //cannot use == to discuss the string thing
            if(!searchUser.getPassword().equals(user.getPassword())) {
                System.out.println("search:"+searchUser.getPassword());
                System.out.println("user:"+user.getPassword());
                return "/register";
            }
        }catch(Exception e){
            System.out.println("Exception, might be not catch the thing");
            return "/error";
        }
        //TODO make the actual error message

        return "redirect:/user/"+searchUser.getUsername();
    }
}
