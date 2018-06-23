package pl.mgrzybowski.user;

import com.sun.xml.internal.ws.api.pipe.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.mgrzybowski.user.model.UserDto;
import pl.mgrzybowski.user.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user")
    public Long addUser(UserDto userDto){
        log.info("Tworze uzytkownika {}", userDto.getName());
        Long userId = userService.addUser(userDto);

        log.info("Stworzono uzytkownika {} id {}", userDto.getName(), userId);
        return userId;
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId, HttpServletRequest request){
        log.info("Pobieram uzytkownika {}", userId);

        UserDto userById;
        userById = userService.getUserById(userId);
        return new ResponseEntity<UserDto>(userById, HttpStatus.OK);
    }

    @GetMapping(value = "/user")
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

}
