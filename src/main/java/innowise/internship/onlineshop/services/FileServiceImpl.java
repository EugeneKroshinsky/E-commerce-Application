package innowise.internship.onlineshop.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

public class FileServiceImpl implements FileService {
    private final static String UPLOAD_DIR = "uploads";

    @Override
    public String uploadFile(HttpServletRequest request) {
        try {
            if (request.getPart("file").getSubmittedFileName().isEmpty()) {
                return null;
            }
            String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            Part part = request.getPart("file");
            String fileName = part.getSubmittedFileName();
            String uploadFileName = uploadPath + File.separator + fileName;
            part.write(uploadFileName);
            return UPLOAD_DIR + File.separator + fileName;
        } catch (IOException e) {
            return null;
        } catch (ServletException e) {
            return null;
        }
    }

}
