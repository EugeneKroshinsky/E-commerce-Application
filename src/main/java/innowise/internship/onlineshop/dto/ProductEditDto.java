package innowise.internship.onlineshop.dto;

import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEditDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private CategoryDto category;
    private String imageUrl;
    private int quantity;
}
