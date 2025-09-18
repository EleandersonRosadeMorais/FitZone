package controlar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Exercicio;

public class ControladorDeExercicio {

    public List<Exercicio> InserirExercicio() {
        List<Exercicio> exercicios = new ArrayList<>();

        String sql = "SELECT pkExercicio, nome, descricao, tipo, grupo_muscular, equipamento, nivel_dificuldade FROM exercicio";

        try (Connection conn = new GerenciadorConexao().getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Pega os valores da linha do banco
                int pkExercicio = rs.getInt("pkInstrutor");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                String tipo = rs.getString("tipo");
                String grupo_muscular = rs.getString("grupo_muscular");
                String equipamento = rs.getString("equipamento");
                String nivel_dificuldade = rs.getString("nivel_dificuldade");

                // Instancia o objeto
                Exercicio e = new Exercicio(pkExercicio, nome, descricao, tipo, grupo_muscular, equipamento, nivel_dificuldade);

                // Adiciona na lista
                exercicios.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exercicios;
    }
}
