package pl.jjd.jjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jjd.jjd.dto.UserDto;
import pl.jjd.jjd.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }

    @ModelAttribute("user")
    public UserDto user(){
        return new UserDto("","","","");
    }


    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")UserDto user){
        userService.save(user());
        return "redirect:/registration?success";
    }

}
