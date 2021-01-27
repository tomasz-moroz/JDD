package pl.jjd.jjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    public String registerUserAccount(@ModelAttribute("user")UserDto userDto){
        userService.save(userDto);
        return "redirect:/registration?success";
    }

}
