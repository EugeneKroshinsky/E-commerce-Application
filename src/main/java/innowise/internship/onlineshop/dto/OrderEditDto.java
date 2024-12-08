package innowise.internship.onlineshop.dto;

import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderEditDto {
    private Long id;
    private UserDto user;
    private String lastName;
    private String firstName;
    private String email;
    private String phone;
    private String status;
    private String address;
    private Double totalPrice;
    private String comment;
    private List<Long> orderItemsId;
}
