package consejodepartamental.persistence;

import consejodepartamental.entity.ConfiguracionGeneral;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ConfigDao {

    private final String IMAGE_FOLDER = "consejo_departamental_images";

    public ConfigDao() {
    }

    public ConfiguracionGeneral obtenerConfiguracionGeneral() {
        String currentFolder = System.getProperty("user.dir");
        File folder = new File(currentFolder, IMAGE_FOLDER);

        if (!folder.exists()) {
            folder.mkdir();
        } else {
            System.out.println("El folder ya existe");
        }

        ConfiguracionGeneral config = new ConfiguracionGeneral();
        config.setRutaImagen(IMAGE_FOLDER);
        return config;
    }
}
