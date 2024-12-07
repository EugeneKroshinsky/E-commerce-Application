package innowise.internship.onlineshop.dto;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductMainPageDto {
    private int id;
    private String name;
    private String description;
    private double price;
    private CategoryDto category;
    private String imageUrl;
    private int quantity;
    private LocalDateTime createdAt;
}
