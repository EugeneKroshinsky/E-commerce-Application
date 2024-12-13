package innowise.internship.onlineshop.dto;
import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilterDto {
    private String categoryFilter;
    private double minPrice;
    private double maxPrice;
    private String sort;
}
