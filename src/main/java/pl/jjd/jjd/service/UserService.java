package pl.jjd.jjd.service;

import org.springframework.stereotype.Service;
import pl.jjd.jjd.dto.UserDto;
import pl.jjd.jjd.entity.User;
import pl.jjd.jjd.reposiotry.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(UserDto userDto) {
        User user = userDto.dtoToUser(userDto);
        userRepository.save(user);
        return userDto.dtoToUser(userDto);
    }
}
