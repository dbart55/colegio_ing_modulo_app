package consejodepartamental.persistence;

import consejodepartamental.entity.EventoModular;
import consejodepartamental.entity.Organizador;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class EventoModularDao {

    private Conexion conexion;

    public EventoModularDao(Conexion conexion) {
        this.conexion = conexion;
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
            if (tema != null && !tema.equals("")) {
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

                em.setInicio(new java.util.Date(rs.getDate("inicio").getTime()));
                em.setFin(new java.util.Date(rs.getDate("fin").getTime()));

                em.setHoras(rs.getString("horas"));

                eventos.add(em);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventoModularDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return eventos;
    }

    public int crearEventoModular(EventoModular em) {
        int newId = 0;
        try {
            int cod_cap = em.getCod_cap();
            int cod_modalidad = em.getCod_modalidad();
            int cod_tipo = em.getCod_tipo();
            int id_ambiente = em.getId_ambiente();
            String tema = em.getTema();
            int cantidad = em.getCantidad();
            int diaMax = em.getDiaMax();
            int horasTotales = em.getHorasTotales();
            String temario = em.getTemario();
            List<Organizador> organizadores = em.getOrganizadores();

            String sql = "INSERT INTO eventos_modulares(cod_modalidad, cod_tipo, id_ambiente, cod_cap, tema, temario, cantidad, inicio, fin, dia_max, horas_totales) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.conexion.getJdbcConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cod_modalidad);
            ps.setInt(2, cod_tipo);
            ps.setInt(3, id_ambiente);
            ps.setInt(4, cod_cap);
            ps.setString(5, tema);
            ps.setString(6, temario);
            ps.setInt(7, cantidad);
            ps.setDate(8, new Date(em.getInicio().getTime()));
            ps.setDate(9, new Date(em.getFin().getTime()));
            ps.setInt(10, diaMax);
            ps.setInt(11, horasTotales);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                newId = rs.getInt(1);
                System.out.println("newId: " + newId);
                crearOrganizadoresPorEventoModular(newId, organizadores);
            } else {
                throw new Exception("ID no generado");
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventoModularDao.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception ex) {
            Logger.getLogger(EventoModularDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return newId;
    }

    private void crearOrganizadoresPorEventoModular(int id, List<Organizador> organizadores) throws SQLException {
        String sql = "INSERT INTO organizador_por_evento_modular(organizador_id, evento_modular_id) VALUES (?,?)";

        for (Organizador org : organizadores) {
            int cip = org.getCip();
            if (cip != 0) {
                PreparedStatement ps = this.conexion.getJdbcConnection().prepareStatement(sql);
                ps.setInt(1, cip);
                ps.setInt(2, id);

                ps.executeUpdate();
            }
        }
    }

    public EventoModular obtenerEventoModuarByCodigo(int eventoCodigo) {
        try {
            String sql = "SELECT em.codigo, em.cod_modalidad, em.cod_tipo, em.id_ambiente, em.tema, em.temario, em.cantidad, em.inicio, em.fin,"
                    + "em.dia_max, em.cod_cap, em.horas_totales,"
                    + "org.CIP, org.DNI, org.organizador, org.celular, org.correo "
                    + "FROM eventos_modulares em "
                    + "LEFT JOIN organizador_por_evento_modular oem ON oem.evento_modular_id = em.codigo "
                    + "LEFT JOIN organizadores org ON oem.organizador_id = org.CIP "
                    + "WHERE em.codigo = ?;";

            PreparedStatement ps = this.conexion.getJdbcConnection().prepareStatement(sql);
            ps.setInt(1, eventoCodigo);

            ResultSet rs = ps.executeQuery();

            EventoModular em = null;
            List<Organizador> organizadores = new ArrayList<>();
            while (rs.next()) {
                //Valores de los organizadores
                Organizador org = new Organizador();
                int cip = rs.getInt("CIP");
                if (cip != 0) {
                    org.setCip(rs.getInt("CIP"));
                    org.setDni(rs.getString("DNI"));
                    org.setOrganizador(rs.getString("organizador"));
                    org.setCelular(rs.getString("celular"));
                    org.setCorreo(rs.getString("correo"));
                    organizadores.add(org);
                }

                if (em == null) {
                    em = new EventoModular();
                    em.setCodigo(rs.getInt("codigo"));
                    em.setCod_modalidad(rs.getInt("cod_modalidad"));
                    em.setCod_tipo(rs.getInt("cod_tipo"));
                    em.setId_ambiente(rs.getInt("id_ambiente"));
                    em.setCod_cap(rs.getInt("cod_cap"));
                    em.setTema(rs.getString("tema"));
                    em.setTemario(rs.getString("temario"));
                    em.setCantidad(rs.getInt("cantidad"));
                    em.setInicio(new java.util.Date(rs.getDate("inicio").getTime()));
                    em.setFin(new java.util.Date(rs.getDate("fin").getTime()));
                    em.setDiaMax(rs.getInt("dia_max"));
                    em.setHorasTotales(rs.getInt("horas_totales"));
                }
            }

            if (em != null) {
                em.setOrganizadores(organizadores);
                return em;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventoModularDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int actualizarEventoModular(EventoModular em) {
        int id = 0;
        try {

            if (em.getCodigo() != 0) {
                int cod_cap = em.getCod_cap();
                int cod_modalidad = em.getCod_modalidad();
                int cod_tipo = em.getCod_tipo();
                int id_ambiente = em.getId_ambiente();
                String tema = em.getTema();
                int cantidad = em.getCantidad();
                int diaMax = em.getDiaMax();
                int horasTotales = em.getHorasTotales();
                String temario = em.getTemario();
                List<Organizador> organizadores = em.getOrganizadores();

                String sql = "UPDATE eventos_modulares SET cod_modalidad=?, cod_tipo=?, id_ambiente=?, cod_cap=?, tema=?, temario=?, "
                        + "cantidad=?, inicio=?, fin=?, dia_max=?, horas_totales=? WHERE codigo=?";
                PreparedStatement ps = this.conexion.getJdbcConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, cod_modalidad);
                ps.setInt(2, cod_tipo);
                ps.setInt(3, id_ambiente);
                ps.setInt(4, cod_cap);
                ps.setString(5, tema);
                ps.setString(6, temario);
                ps.setInt(7, cantidad);
                ps.setDate(8, new Date(em.getInicio().getTime()));
                ps.setDate(9, new Date(em.getFin().getTime()));
                ps.setInt(10, diaMax);
                ps.setInt(11, horasTotales);
                ps.setInt(12, em.getCodigo());

                ps.executeUpdate();

                eliminarOrganizadoresPorEventoModular(em.getCodigo());
                crearOrganizadoresPorEventoModular(em.getCodigo(), organizadores);
                return em.getCodigo();
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventoModularDao.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception ex) {
            Logger.getLogger(EventoModularDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    private void eliminarOrganizadoresPorEventoModular(int eventoCodigo) {
        try {
            String sql = "DELETE FROM organizador_por_evento_modular WHERE evento_modular_id = ?";
            PreparedStatement ps = this.conexion.getJdbcConnection().prepareStatement(sql);
            ps.setInt(1, eventoCodigo);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EventoModularDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
