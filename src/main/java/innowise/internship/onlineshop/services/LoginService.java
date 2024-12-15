package innowise.internship.onlineshop.services;

import jakarta.servlet.http.HttpServletRequest;

public interface LoginService {
    boolean authenticate(String login, String password, HttpServletRequest request);
}
