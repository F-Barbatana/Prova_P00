package MethodFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConectionFactory implements AutoCloseable {
    private Connection connection;
    private PreparedStatement statement;

    public Connection createConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:RpgDeMesaSistema.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public PreparedStatement createPreparedStatement(String sql) {
        try {
            statement = createConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public void close() throws Exception {// Método é invocado ao final do try-with-resources
        if (connection != null) {
            connection.close();
            if (statement != null)
                statement.close();
        }
    }
}