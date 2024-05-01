package Firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author USUARIO
 */
public class ConexionFirebase {


    public static void Conectar() throws FileNotFoundException, IOException {
        FileInputStream serviceAccount = new FileInputStream("ipcii-final-project-firebase-adminsdk-ttrqr-9efcd10531.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setStorageBucket("ipcii-final-project.appspot.com")
                .build();
        FirebaseApp.initializeApp(options);

        com.google.cloud.storage.Bucket bucket = StorageClient.getInstance().bucket(); 
    }

}
