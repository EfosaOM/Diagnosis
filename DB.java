import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static Connection connect_DB_MY_SQL() throws SQLException, ClassCastException {
        try {
            Connection con = null;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://MYSQL8001.site4now.net/db_a8ed0e_jvaproj", "a8ed0e_jvaproj", "3YsYzFiH3qC@ve3");
            return con;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);}
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);}
    }

}
