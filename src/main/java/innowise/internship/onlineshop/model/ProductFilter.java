package innowise.internship.onlineshop.model;
import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductFilter {
    private String categoryFilter;
    private double minPrice;
    private double maxPrice;
    private String sort;
}
