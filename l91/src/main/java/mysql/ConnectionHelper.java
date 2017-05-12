package mysql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by artur on 11/05/17.
 */
public class ConnectionHelper {

    public static Connection getConnection(String database, String user, String password) {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            String url =
                    "jdbc:mysql://" +            //db type
                            "localhost:" +               //host name
                            "3306/" +                    //port
                            database + "?" +              //db name
                            "user=" + user + "&" +              //login
                            "password=" + password;            //password

            return DriverManager.getConnection(url);
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
