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
public class Order {
    private int id;
    private int userId;
    private String status;
    private LocalDateTime date;
    private String address;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String comment;
    private double totalPrice;
    private List<OrderItem> items;
}
