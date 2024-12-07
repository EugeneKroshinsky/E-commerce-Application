package innowise.internship.onlineshop.dto;

import lombok.*;

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
    private String category;
    private String imageUrl;
    private double quantity;
}
