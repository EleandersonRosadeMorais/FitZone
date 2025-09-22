package controlar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Exercicio;
import modelo.Treino;

public class ControladorDeExercicio {

    public List<Exercicio> consultar() {
        String sql = "SELECT * from exercicio";

        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;

        List<Exercicio> lista = new ArrayList<>();

        try {
            comando = gerenciador.prepararComando(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
                Exercicio exe = new Exercicio();
                exe.setPkExercicio(resultado.getInt("pkExercicio"));
                exe.setNome(resultado.getString("nome"));
                exe.setDescricao(resultado.getString("descricao"));
                exe.setTipo(resultado.getString("tipo"));
                exe.setGrupo_muscular(resultado.getString("grupo_muscular"));
                exe.setEquipamento(resultado.getString("equipamento"));
                exe.setNivel_dificuldade(resultado.getString("nivel_dificuldade"));
                lista.add(exe);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }
        return lista;
    }
}
