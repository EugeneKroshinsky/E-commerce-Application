package innowise.internship.onlineshop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
    private String comment;
    private List<OrderItemDto> orderItems;
    private String status = "In process";

    @NotEmpty(message = "Last name is required")
    private String lastName;

    @NotEmpty(message = "First name is required")
    private String firstName;

    @Email(message = "Email is invalid")
    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Phone is required")
    private String phone;

    @NotEmpty(message = "Address is required")
    private String address;

    private String createdAt;

}
