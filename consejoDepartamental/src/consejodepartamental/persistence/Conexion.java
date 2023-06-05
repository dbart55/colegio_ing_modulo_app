package consejodepartamental.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Diego
 */
public class Conexion {
    private String url = "jdbc:mysql://localhost:3306/";
    private String db = "colegio_ingenieros";
    private String user = "user";
    private String password = "123";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private Connection jdbcConnection;
    public Conexion(){
        try {
            Class.forName(driver);
            this.jdbcConnection = DriverManager.getConnection(url + db , user, password);
            System.out.println("Conexion iniciada.");
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void desconectar(){
        try {
            this.jdbcConnection.close();
            System.out.println("Conexion terminada.");
        } catch (SQLException ex) {
          System.err.println(ex);
        }
    }

    public Connection getJdbcConnection() {
        return this.jdbcConnection;
    }
}
