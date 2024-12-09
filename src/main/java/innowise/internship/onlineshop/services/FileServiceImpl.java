package innowise.internship.onlineshop.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Optional;

@ApplicationScoped
public class FileServiceImpl implements FileService {
    private final static String UPLOAD_DIR = "uploads/";
    @Override
    public String uploadFile(HttpServletRequest request) {
        String uploadDir = null;
        try {
            request.getParameter("id");
            Part filePart = request.getPart("file");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            uploadDir = UPLOAD_DIR + fileName;
            filePart.write(uploadDir);
        } catch (IOException | ServletException e) {
            throw new RuntimeException("Ошибка при загрузке файла: " + e.getMessage(), e);
        }

        return uploadDir;
    }

}
