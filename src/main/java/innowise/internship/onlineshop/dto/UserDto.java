package innowise.internship.onlineshop.dto;

import innowise.internship.onlineshop.model.Role;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private List<String> roles;
}
