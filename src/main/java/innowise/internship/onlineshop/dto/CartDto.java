package innowise.internship.onlineshop.dto;

import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private int quantity;
    private ProductDto product;
}
