package controlar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Treino;

public class ControladorDeTreino {

   public List<Treino> consultar(int id) {
    String sql = "SELECT * from treino WHERE fkUsuario = " + id;

    GerenciadorConexao gerenciador = new GerenciadorConexao();
    PreparedStatement comando = null;
    ResultSet resultado = null;
    List<Treino> lista = new ArrayList<>();

    try {
        comando = gerenciador.prepararComando(sql);
        resultado = comando.executeQuery();

        while (resultado.next()) {
            Treino tre = new Treino();

            tre.setPkTreino(resultado.getInt("pkTreino"));
            tre.setFkUsuario(resultado.getInt("fkUsuario"));
            tre.setFkInstrutor(resultado.getInt("fkInstrutor"));
            tre.setNome(resultado.getString("nome"));
            tre.setDescricao(resultado.getString("descricao"));
            tre.setObjetivo(resultado.getString("objetivo"));
            tre.setDuracao_minutos(resultado.getInt("duracao_minutos"));
            tre.setConcluido(resultado.getBoolean("concluido"));

            lista.add(tre);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    } finally {
        gerenciador.fecharConexao(comando, resultado);
    }

    return lista;
}

}
