package pl.jjd.jjd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.jjd.jjd.entity.Role;
import pl.jjd.jjd.entity.User;

import java.util.*;


@Data
@AllArgsConstructor
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserDto() {
    }

    public User dtoToUser(UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return user;
    }

    public UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
