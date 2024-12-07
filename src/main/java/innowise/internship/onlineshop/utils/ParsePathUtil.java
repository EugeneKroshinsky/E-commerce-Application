package innowise.internship.onlineshop.utils;

import jakarta.servlet.http.HttpServletRequest;

public class ParsePathUtil {
    public static Long parsePath(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo != null && pathInfo.startsWith("/")) {
            pathInfo = pathInfo.substring(1);
        }
        return Long.parseLong(request.getPathInfo().substring(1));
    }
}
