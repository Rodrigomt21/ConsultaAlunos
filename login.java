import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login {
    public static boolean login(String username, String password) {
        String query = "SELECT * FROM alunos WHERE username = ? AND password = ?";

        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Retorna true se encontrar um usuário correspondente
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int getAlunoId(String username) {
        String query = "SELECT id FROM alunos WHERE username = ?";
        int alunoId = -1;

        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                alunoId = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alunoId;
    }
}

