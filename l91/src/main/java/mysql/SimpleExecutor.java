package mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by artur on 11/05/17.
 */
public class SimpleExecutor {
    private final Connection connection;

    public SimpleExecutor(Connection connection) {
        this.connection = connection;
    }

    public void execQuery(String query, ResultHandler handler) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(query);
            ResultSet result = stmt.getResultSet();
            handler.handle(result);
        }
    }

    public int execUpdate(String update) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(update);
            return stmt.getUpdateCount();
        }
    }

    protected Connection getConnection() {
        return connection;
    }
}