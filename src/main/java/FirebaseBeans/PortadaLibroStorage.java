package FirebaseBeans;

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import jakarta.enterprise.context.RequestScoped;
import java.io.IOException;
import java.io.InputStream;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author USUARIO
 */
@RequestScoped
public class PortadaLibroStorage {
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void uploadFile() {
        try {
            if (file != null) {
                InputStream inputStream = file.getInputStream();
                Storage storage = StorageOptions.getDefaultInstance().getService();
                Bucket bucket = storage.get("gs://ipcii-final-project.appspot.com");
                bucket.create("/frontPage/Libros/" + file.getFileName(), inputStream, file.getContentType());
                System.out.println("Archivo subido correctamente.");
            } else {
                System.out.println("No se ha seleccionado ningún archivo.");
            }
        } catch (IOException e) {
            System.err.println("Error al subir el archivo: " + e.getMessage());
        }
    }
}
