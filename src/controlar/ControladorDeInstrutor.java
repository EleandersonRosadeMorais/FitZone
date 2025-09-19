package controlar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Instrutor;

public class ControladorDeInstrutor {

    public List<Instrutor> consultar(String id) {
        String sql = "SELECT * from Instrutor WHERE pkInstrutor = " + id;

        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;

        List<Instrutor> lista = new ArrayList<>();

        try {
            comando = gerenciador.prepararComando(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
                Instrutor ins = new Instrutor();
                ins.setPkInstrutor(resultado.getInt("pkInstrutor"));
                ins.setNome(resultado.getString("nome"));
                ins.setEspecialidade(resultado.getString("especialidade"));
                ins.setCreft(resultado.getString("cref"));
                ins.setTelefone(resultado.getString(("telefone")));
                ins.setEmail(resultado.getString("email"));
                
                lista.add(ins);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }
        return lista;
    }
}
