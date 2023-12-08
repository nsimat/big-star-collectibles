package nsimat.edu.collectibles.controllers;

import jakarta.validation.Valid;
import nsimat.edu.collectibles.beans.User;
import nsimat.edu.collectibles.dao.UserRepository;
import nsimat.edu.collectibles.validators.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    //private final UserValidator userValidator;
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        //this.userValidator = userValidator;
        this.userRepository = userRepository;
    }

    /*@InitBinder
    public void bindUser(WebDataBinder binder){
        binder.addValidators(this.userValidator);
    }*/

    @GetMapping("/newUser")
    public String displayRegistrationForm(Model model){

        model.addAttribute("user", new User());
        return "register-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult result,
                           Model model){

        if(result.hasErrors()) {
            return "register-user";
        }

        var userSaved = userRepository.save(user);
        if(userSaved != null){
            model.addAttribute("userSaved", true);
        }
        return "register-user";
    }
}
