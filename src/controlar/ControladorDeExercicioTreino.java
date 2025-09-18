package controlar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.ExercicioTreino;

public class ControladorDeExercicioTreino {

    public List<ExercicioTreino> InserirExercicioTreino() {
        List<ExercicioTreino> exercicioTreinos = new ArrayList<>();

        String sql = "SELECT pkExercicioTreino, fkExercicio, carga, repeticoes, series, ordem FROM exerciciotreino";

        try (Connection conn = new GerenciadorConexao().getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Pega os valores da linha do banco
                int pkExercicioTreino = rs.getInt("pkInstrutor");
                int fkExercicio = rs.getInt("fkExercicio");
                int carga = rs.getInt("carga");
                int repeticoes = rs.getInt("repeticoes");
                int series = rs.getInt("series");
                int ordem = rs.getInt("ordem");

                // Instancia o objeto
                ExercicioTreino e = new ExercicioTreino(pkExercicioTreino, fkExercicio, carga, repeticoes, series, ordem);

                // Adiciona na lista
                exercicioTreinos.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exercicioTreinos;
    }
}
