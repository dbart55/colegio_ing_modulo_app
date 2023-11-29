package consejodepartamental.entity;

/**
 *
 * @author Diego
 */
public class ConfiguracionGeneral {

    private int configId;
    private String rutaImagen;

    public ConfiguracionGeneral() {
        this.rutaImagen = "";
    }

    public ConfiguracionGeneral(int configId, String rutaImagen) {
        this.configId = configId;
        this.rutaImagen = rutaImagen;
    }

    public int getConfigId() {
        return configId;
    }

    public void setConfigId(int configId) {
        this.configId = configId;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public String toString() {
        return "ConfiguracionGeneral{" + "configId=" + configId + ", rutaImagen=" + rutaImagen + '}';
    }
}
