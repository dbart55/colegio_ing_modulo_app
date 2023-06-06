package consejodepartamental.persistence;

import consejodepartamental.entity.EventoModular;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Diego
 */
public class EventoModularDao {

    private Conexion conexion;
    private SimpleDateFormat formatDDMMYYY;
    private DateTimeFormatter formatHHmm;

    public EventoModularDao(Conexion conexion) {
        this.conexion = conexion;
        this.formatDDMMYYY = new SimpleDateFormat("dd/MM/yyyy");
        this.formatHHmm = DateTimeFormatter.ofPattern("HH:mm");
    }

    public List<EventoModular> obtenerEventosModulares(EventoModular filter) {
        List<EventoModular> eventos = new ArrayList<>();
        try {

            int codigo = filter.getCodigo();
            int cod_modalidad = filter.getCod_modalidad();
            int cod_tipo = filter.getCod_tipo();
            int cod_cap = filter.getCod_cap();
            String tema = filter.getTema();

            String sql = "SELECT em.codigo, em.cod_modalidad, m.modalidad, "
                    + "em.cod_tipo, t.tipo,  "
                    + "em.tema, em.cantidad, em.inicio, em.fin,  "
                    + "em.cod_cap, c.organizador AS 'capitulo', "
                    + "em.horas, em.lugar  "
                    + "FROM eventos_modulares em INNER JOIN evento_modalidad m ON m.cod_modalidad = em.cod_modalidad  "
                    + "INNER JOIN tipo_evento t ON t.cod_tipo  = em.cod_tipo "
                    + "INNER JOIN capitulo c ON c.cod_cap = em.cod_cap "
                    + "WHERE 1 ";

            if (codigo != 0) {
                sql += "AND em.codigo = '" + codigo + "' ";
            }
            if (cod_modalidad != 0) {
                sql += "AND em.cod_modalidad = '" + cod_modalidad + "' ";
            }

            if (cod_tipo != 0) {
                sql += "AND em.cod_tipo = '" + cod_tipo + "' ";
            }

            if (cod_cap != 0) {
                sql += "AND c.cod_cap = '" + cod_cap + "' ";
            }
            if (tema != null && tema.equals("")) {
                tema = tema.toLowerCase();
                sql += "AND LOWER(em.tema) LIKE '%" + tema + "%' ";
            }

            Statement st = this.conexion.getJdbcConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                EventoModular em = new EventoModular();
                em.setCodigo(rs.getInt("codigo"));
                em.setCod_modalidad(rs.getInt("cod_modalidad"));
                em.setModalidadNombre(rs.getString("modalidad"));
                em.setCod_tipo(rs.getInt("cod_tipo"));
                em.setTipoNombre(rs.getString("tipo"));
                em.setTema(rs.getString("tema"));
                em.setCantidad(rs.getInt("cantidad"));
                em.setLugar(rs.getString("lugar"));
                em.setCod_cap(rs.getInt("cod_cap"));
                em.setCapituloNombre(rs.getString("capitulo"));
       
                em.setInicio(this.formatDDMMYYY.format(rs.getDate("inicio")));
                em.setFin(this.formatDDMMYYY.format(rs.getDate("fin")));
              
                Time horas = rs.getTime("horas");
                LocalTime lt = horas.toLocalTime();
                em.setHoras(lt.format(this.formatHHmm));
                
                System.out.println(em);
                eventos.add(em);
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return eventos;
    }

}
