package controlar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Treino;

public class ControladorDeTreino {

    public List<Treino> InserirTreino() {
        List<Treino> Treinos = new ArrayList<>();

        String sql = "SELECT pkExercicioTreino, fkExercicio, carga, repeticoes, series, ordem FROM treino";

        try (Connection conn = new GerenciadorConexao().getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Pega os valores da linha do banco
                int pkTreino = rs.getInt("pkTreino");
                int fkUsuario = rs.getInt("fkUsuario");
                int fkInstrutor = rs.getInt("fkInstrutor");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                String objetivo = rs.getString("objetivo");
                int duracao_minutos = rs.getInt("duracao_minutos");
                int fkExercicioTreino = rs.getInt("fkExercicioTreino");
                // Instancia o objeto
                Treino e = new Treino(pkTreino, fkUsuario, fkInstrutor, nome, descricao, objetivo, duracao_minutos, fkExercicioTreino);

                // Adiciona na lista
                Treinos.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Treinos;
    }
}
