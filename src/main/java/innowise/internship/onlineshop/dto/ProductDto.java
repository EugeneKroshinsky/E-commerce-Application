package innowise.internship.onlineshop.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Description is required")
    private String description;
    @DecimalMin(value ="0.0", message = "Price must be greater than 0")
    private double price;
    @Min(value = 0, message = "Quantity must be greater than 0")
    private int quantity;

    private Long categoryId;
    private CategoryDto category;
    private String imageUrl;
}
