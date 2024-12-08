package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.ProductEditDto;
import jakarta.servlet.http.HttpServletRequest;

public class AdminProductMapper {

    public static ProductEditDto toEditDto(HttpServletRequest request, Long id) {
        ProductEditDto productDto = new ProductEditDto();
        productDto.setCategoryId(id);
        String idParam = request.getParameter("id");
        productDto.setName(request.getParameter("name"));
        productDto.setDescription(request.getParameter("description"));
        productDto.setPrice(Double.parseDouble(request.getParameter("price")));
        productDto.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        //TODO: реализовать добавление картинок
        productDto.setImageUrl("https://via.placeholder.com/150");
        return productDto;
    }
}
