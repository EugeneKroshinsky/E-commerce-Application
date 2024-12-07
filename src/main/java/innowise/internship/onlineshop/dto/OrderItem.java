package innowise.internship.onlineshop.dto;

import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private int id;
    private int orderId;
    private int productId;
    private int quantity;
}
