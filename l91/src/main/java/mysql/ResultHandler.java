package mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by artur on 11/05/17.
 */
public interface ResultHandler {
    void handle(ResultSet result) throws SQLException;
}
