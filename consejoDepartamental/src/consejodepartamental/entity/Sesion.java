package consejodepartamental.entity;

/**
 *
 * @author Diego
 */
public class Sesion {

    private int sesionId;
    private int userId;
    private boolean recordarUsuario;

    public Sesion(int sesionId, int userId, boolean recordarUsuario) {
        this.sesionId = sesionId;
        this.userId = userId;
        this.recordarUsuario = recordarUsuario;
    }

    public Sesion(int userId, boolean recordarUsuario) {
        this.userId = userId;
        this.recordarUsuario = recordarUsuario;
    }

    public int getSesionId() {
        return sesionId;
    }

    public void setSesionId(int sesionId) {
        this.sesionId = sesionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isRecordarUsuario() {
        return recordarUsuario;
    }

    public void setRecordarUsuario(boolean recordarUsuario) {
        this.recordarUsuario = recordarUsuario;
    }

    @Override
    public String toString() {
        return "Sesion{" + "sesionId=" + sesionId + ", userId=" + userId + ", recordarUsuario=" + recordarUsuario + '}';
    }
}
