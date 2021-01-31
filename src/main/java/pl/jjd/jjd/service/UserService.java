package pl.jjd.jjd.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.jjd.jjd.dto.UserDto;
import pl.jjd.jjd.entity.User;

public interface UserService extends UserDetailsService {
    User save(UserDto userDto);
}