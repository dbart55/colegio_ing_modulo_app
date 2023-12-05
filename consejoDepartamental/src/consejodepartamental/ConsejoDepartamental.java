package consejodepartamental;

import consejodepartamental.entity.Sesion;
import consejodepartamental.entity.Usuario;
import consejodepartamental.logic.Controlador;
import consejodepartamental.ui.HomeFrame;
import consejodepartamental.ui.LoginForm;

/**
 *
 * @author Diego
 */
public class ConsejoDepartamental {

    public static void main(String[] args) {

        Controlador controlador = new Controlador();

        Sesion ultimaSesion = controlador.obtenerUltimaSesion();
        if (ultimaSesion == null) {
            LoginForm initialForm = new LoginForm(controlador);
            initialForm.setVisible(true);
            initialForm.setLocationRelativeTo(null);
        } else {
            Usuario user = controlador.obtenerUsuarioPorId(ultimaSesion.getUserId());
            if (user != null) {
                HomeFrame homeFrame = new HomeFrame(user, ultimaSesion, controlador);
                homeFrame.setVisible(true);
                homeFrame.setLocationRelativeTo(null);
            }

        }
    }

}
