package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author parainformaticos.com
 */
public class ConectaDb  {

    public Connection getConnection() throws SQLException {
        Connection cn = null;

        try {
            Class.forName(driver).newInstance();
            cn = DriverManager.getConnection(url, user, password);

        } catch (Exception ex) {
            throw new SQLException(ex.getMessage());
        }

        return cn;
    }

    public ConectaDb() {
    }
    
    private final String url = "jdbc:mysql://localhost:3306/clima";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String user = "root";
    private final String password = "root";
}

