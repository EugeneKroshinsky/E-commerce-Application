package innowise.internship.onlineshop.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private UserDto user;
    private String lastName;
    private String firstName;
    private String email;
    private String phone;
    private String status;
    private LocalDateTime createdAt;
    private String address;
    private Double totalPrice;
    private String comment;
    private List<CartDto> orderItems;
}
