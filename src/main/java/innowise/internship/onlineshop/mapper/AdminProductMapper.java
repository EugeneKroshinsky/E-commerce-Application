package innowise.internship.onlineshop.mapper;

import innowise.internship.onlineshop.dto.AdminProductDto;
import jakarta.servlet.http.HttpServletRequest;

public class AdminProductMapper {
    public static AdminProductDto toDto(HttpServletRequest request) {
        return new AdminProductDto(

        );
    }
}
