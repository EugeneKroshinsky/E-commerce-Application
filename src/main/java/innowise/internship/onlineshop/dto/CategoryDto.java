package innowise.internship.onlineshop.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    @NotEmpty
    private String name;
}
