package nsimat.edu.collectibles.controllers;

import jakarta.validation.Valid;
import nsimat.edu.collectibles.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

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
