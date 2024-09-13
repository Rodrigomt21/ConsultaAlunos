import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class consulta {
    public static void getNotasEFaltas(int alunoId) {
        String query = "SELECT m.materia, c.notas, c.faltas FROM consulta c " +
                       "JOIN materias m ON c.materia_id = m.id " +
                       "WHERE c.id_aluno = ?";

        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, alunoId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String materia = rs.getString("materia");
                double nota = rs.getDouble("notas");
                int faltas = rs.getInt("faltas");
                
                System.out.println("Matéria: " + materia + ", Nota: " + nota + ", Faltas: " + faltas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

