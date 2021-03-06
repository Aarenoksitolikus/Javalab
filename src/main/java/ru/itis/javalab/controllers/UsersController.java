package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.services.UsersService;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsersPage(@RequestParam(value = "page", required = false) Integer page,
                               @RequestParam(value = "size", required = false) Integer size,
                               Model model) {
        if (page != null && size != null) {
            model.addAttribute("users", usersService.getAllUsers(page, size));
        } else {
            model.addAttribute("users", usersService.getAllUsers());
        }
        return "users_view";
    }

    @RequestMapping(value = "/users/{user-id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto getUser(@PathVariable("user-id") Long userId) {
        return usersService.getUser(userId);
    }
}
