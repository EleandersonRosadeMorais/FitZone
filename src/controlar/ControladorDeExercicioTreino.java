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

    public List<ExercicioTreino> consultarPorTreino(int fkTreino) {
        String sql = "SELECT * "
                + "FROM exercicio_treino et "
                + "INNER JOIN exercicio e "
                + "ON e.pkExercicio = et.fkExercicio "
                + "WHERE et.fkTreino = ?"; 

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<ExercicioTreino> lista = new ArrayList<>();

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setInt(1, fkTreino);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                ExercicioTreino exeTre = new ExercicioTreino();
                exeTre.setPkExercicioTreino(resultado.getInt("pkExercicioTreino"));
                exeTre.setFkExercicio(resultado.getInt("fkExercicio"));
                exeTre.setCarga(resultado.getInt("carga"));
                exeTre.setRepeticoes(resultado.getInt("repeticoes"));
                exeTre.setSeries(resultado.getInt("series"));
                exeTre.setOrdem(resultado.getInt("ordem"));
                exeTre.setFkTreino(fkTreino);

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
            JOptionPane.showMessageDialog(null, "Erro ao consultar exercícios do treino: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }
        return lista;
    }

    public boolean criar(ExercicioTreino exercicio) {
        String sql = "INSERT INTO EXERCICIO_TREINO (fkTreino, fkExercicio, carga, repeticoes, series, ordem) VALUES (?,?,?,?,?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, exercicio.getFkTreino());
            comando.setInt(2, exercicio.getFkExercicio());
            comando.setInt(3, exercicio.getCarga());
            comando.setInt(4, exercicio.getRepeticoes());
            comando.setInt(5, exercicio.getSeries());
            comando.setInt(6, exercicio.getOrdem());
            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar exercício no treino: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            gerenciador.fecharConexao(comando);
        }
        return false;
    }
}