package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.CategoryDto;
import innowise.internship.onlineshop.dto.ProductEditDto;
import jakarta.servlet.http.HttpServletRequest;

public class AdminProductMapper {
    public static ProductEditDto toEditDto(HttpServletRequest request) {
        ProductEditDto productDto = new ProductEditDto();
        String productIdParam = request.getParameter("id");
        Long productId = productIdParam == null ? null : Long.parseLong(productIdParam);
        productDto.setId(productId);
        Long id = Long.parseLong(request.getParameter("categoryId"));
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(id);
        productDto.setCategory(categoryDto);
        productDto.setName(request.getParameter("name"));
        productDto.setDescription(request.getParameter("description"));
        productDto.setPrice(Double.parseDouble(request.getParameter("price")));
        productDto.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        productDto.setImageUrl("https://via.placeholder.com/150"); //TODO: add image upload
        return productDto;
    }
}
