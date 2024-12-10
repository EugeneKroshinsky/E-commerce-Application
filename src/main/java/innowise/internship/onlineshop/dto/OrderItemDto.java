package innowise.internship.onlineshop.dto;

import jakarta.validation.constraints.Min;
import lombok.*;


@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private Long id;
    @Min(value = 0, message = "Quantity must be positive")
    private int quantity;
    private ProductDto product;
    private Long productId;
}
