package pl.mgrzybowski.user.service;

import pl.mgrzybowski.user.model.UserDto;

import java.util.List;

public interface UserService {

    Long addUser(UserDto userDto);
    UserDto getUserById(Long userId);
    List<UserDto> getUsers();
}
