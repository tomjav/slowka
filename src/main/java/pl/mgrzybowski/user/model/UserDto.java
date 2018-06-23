package pl.mgrzybowski.user.model;

import lombok.Data;

@Data
public class UserDto {

    private Long userId;
    private String name;
    private String surname;
    private String email;
}
