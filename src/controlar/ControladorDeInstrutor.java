package controlar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Instrutor;

public class ControladorDeInstrutor {

    public List<Instrutor> InserirInstrutor() {
        List<Instrutor> instrutores = new ArrayList<>();

        String sql = "SELECT pkInstrutor, nome, especialidade, cref, telefone, email FROM instrutor";

        try (Connection conn = new GerenciadorConexao().getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Pega os valores da linha do banco
                int pkInstrutor = rs.getInt("pkInstrutor");
                String nome = rs.getString("nome");
                String especialidade = rs.getString("especialidade");
                String cref = rs.getString("cref");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");

                // Instancia o objeto
                Instrutor i = new Instrutor(pkInstrutor, nome, especialidade, cref, telefone, email);

                // Adiciona na lista
                instrutores.add(i);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return instrutores;
    }
}
