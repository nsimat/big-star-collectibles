package nsimat.edu.collectibles.controllers;

import jakarta.validation.Valid;
import nsimat.edu.collectibles.beans.User;
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

    private final UserValidator userValidator;

    public UserController(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @InitBinder
    public void bindUser(WebDataBinder binder){
        binder.addValidators(this.userValidator);
    }

    @GetMapping("/newUser")
    public String displayRegistrationForm(Model model){

        model.addAttribute("user", new User());
        return "register-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult result,
                           Model model){
        //validate user and save it to DB
        return "register-user";
    }
}
