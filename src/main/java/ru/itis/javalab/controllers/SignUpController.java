package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.services.UsersService;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class SignUpController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/signup")
    public String getSignUpPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "sign_up_page";
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        return "success_signup";
    }

    @PostMapping("/signup")
    public String signUp(@Valid UserForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().anyMatch(error -> {
                if (Objects.requireNonNull(error.getCodes())[0].equals("userForm.ValidPasswords")) {
                    model.addAttribute("passwordsErrorMessage", error.getDefaultMessage());
                }
                return true;
            });
            model.addAttribute("userForm", form);
            return "sign_up_page";
        }
        usersService.addUser(form);
        return "redirect:/success";
    }

}
