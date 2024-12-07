package innowise.internship.onlineshop.dto;

import lombok.*;

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
    private String date;
    private String address;
    private String paymentMethod;
    private String deliveryMethod;
    private double totalPrice;
}
