package controlar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Exercicio;
import modelo.ExercicioTreino;

public class ControladorDeExercicioTreino {

    public List<ExercicioTreino> consultar(String id) {
        String sql = "SELECT * "
                   + "FROM exercicio_Treino et "
                   + "INNER JOIN exercicio e ON e.pkExercicio = et.fkExercicio "
                   + "WHERE e.pkExercicio = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;

        List<ExercicioTreino> lista = new ArrayList<>();

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setInt(1, Integer.parseInt(id));
            resultado = comando.executeQuery();

            while (resultado.next()) {
                ExercicioTreino exeTre = new ExercicioTreino();
                exeTre.setPkExercicioTreino(resultado.getInt("pkExercicioTreino"));
                exeTre.setFkExercicio(resultado.getInt("fkExercicio"));
                exeTre.setCarga(resultado.getInt("carga"));
                exeTre.setRepeticoes(resultado.getInt("repeticoes"));
                exeTre.setSeries(resultado.getInt("series"));
                exeTre.setOrdem(resultado.getInt("ordem"));

                Exercicio exe = new Exercicio();
                exe.setPkExercicio(resultado.getInt("pkExercicio"));
                exe.setNome(resultado.getString("nome"));
                exe.setDescricao(resultado.getString("descricao"));
                exe.setTipo(resultado.getString("tipo"));
                exe.setGrupo_muscular(resultado.getString("grupo_muscular"));
                exe.setEquipamento(resultado.getString("equipamento"));
                exe.setNivel_dificuldade(resultado.getString("nivel_dificuldade"));

                exeTre.setExercicio(exe);
                lista.add(exeTre);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar ExercicioTreino: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido informado: " + id);
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        return lista;
    }
}
