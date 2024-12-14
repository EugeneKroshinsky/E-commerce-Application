package innowise.internship.onlineshop.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public interface FileService {
    String uploadFile(HttpServletRequest request);
}
