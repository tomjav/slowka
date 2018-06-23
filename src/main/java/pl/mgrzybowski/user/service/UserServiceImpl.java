package pl.mgrzybowski.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mgrzybowski.user.model.UserDto;
import pl.mgrzybowski.user.model.UserEnity;
import pl.mgrzybowski.user.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public Long addUser(UserDto userDto) {

        UserEnity entitiy = new UserEnity();
        entitiy.setEmail(userDto.getEmail());
        entitiy.setName(userDto.getName());
        entitiy.setSurname(userDto.getSurname());

        return userRepository.save(entitiy).getUserId();
    }

    @Override
    public UserDto getUserById(Long userId) {

        Optional<UserEnity> entity = userRepository.findById(userId);

        UserEnity user = entity.orElseThrow(() -> new RuntimeException("Nie znaleziono uzytkownika"));

        UserDto dto = new UserDto();
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setSurname(user.getEmail());

        return dto;
    }

    @Override
    public List<UserDto> getUsers() {
        List<UserEnity> users = userRepository.findAll();


        List<UserDto> userDtoList = users.stream().map(entity -> {
            UserDto userDto = new UserDto();
            userDto.setSurname(entity.getSurname());
            userDto.setName(entity.getName());
            userDto.setEmail(entity.getEmail());
            return userDto;
        }).collect(Collectors.toList());

        return userDtoList;
    }
}
