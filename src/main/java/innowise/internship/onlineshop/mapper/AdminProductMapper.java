package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.ProductDto;
import innowise.internship.onlineshop.services.CategoryService;
import innowise.internship.onlineshop.services.CategoryServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class AdminProductMapper {
    private final static CategoryService categoryService = new CategoryServiceImpl();
    public static ProductDto toDto(HttpServletRequest request) {
        ProductDto productDto = new ProductDto();
        String idParam = request.getParameter("id");
        productDto.setId(idParam != null ? Long.parseLong(idParam) : null);
        productDto.setName(request.getParameter("name"));
        productDto.setDescription(request.getParameter("description"));
        productDto.setPrice(Double.parseDouble(request.getParameter("price")));
        productDto.setCategory(categoryService.getById(Long.parseLong(request.getParameter("categoryId"))));
        productDto.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        //TODO: реализовать добавление картинок
        productDto.setImageUrl("https://via.placeholder.com/150");
        return productDto;
    }
}
