package com.example.app.controller;

import com.example.app.domain.Role;
import com.example.app.domain.User;
import com.example.app.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
@Controller
public class MainController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "home";
    }


    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {



        model.addAttribute("messages");
        model.addAttribute("filter", filter);

        return "main";
    }
    /*@RequestMapping(value = "/showDb", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }*/
    /*@RequestMapping(value = "/showDb", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }*/
    /*@GetMapping("/showDb")
    public String addUser(User user, Model model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());
        model.addAttribute("userk", userFromDb);
        return "showDb";
    }*/

    @GetMapping("/showDb")
    public String showDb(Principal user, Model model){
        Iterable<User> users = userRepo.findAll();

        model.addAttribute("users",users);
        //Take authorized  user
        User userFromDb = userRepo.findByUsername(user.getName());
        model.addAttribute("userk", userFromDb);
        System.out.println(user.getName());
        return "showDb";
    }






}
