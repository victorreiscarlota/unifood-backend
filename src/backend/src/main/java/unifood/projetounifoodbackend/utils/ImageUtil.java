package unifood.projetounifoodbackend.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class ImageUtil {

    public static String encodedImageToBase64Binary(MultipartFile image) throws IOException {
        byte[] fileContent = image.getBytes();
        return Base64.getEncoder().encodeToString(fileContent);
    }
}
