import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_notas_alunos";
    private static final String USER = "root";  // Altere para seu usuário
    private static final String PASSWORD = "9534";  // Altere para sua senha

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
