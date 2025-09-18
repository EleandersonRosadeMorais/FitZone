package controlar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GerenciadorConexao {
// Configurações de conexão com o banco de dados MySQL

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/fitzone";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
// Objeto de conexão com o banco
    private Connection conexao;

    public Connection getConexao() {
        return conexao;
    }

    public GerenciadorConexao() {
        try {
            // Estabelece conexão com o banco de dados
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // Exibe erro em caso de falha na conexão
            JOptionPane.showMessageDialog(null, e.getMessage().toString());
        }
    }

// Cria um comando SQL seguro para usar com valores variáveis
    public PreparedStatement prepararComando(String sql) {
        PreparedStatement comando = null;

        try {
            // Prepara o comando SQL para receber os valores depois
            comando = conexao.prepareStatement(sql);
        } catch (SQLException erro) {
            // Mostra mensagem de erro se não conseguir criar o comando
            JOptionPane.showMessageDialog(null, "Erro ao preparar comando: " + erro);
        }
// Retorna o comando pronto para uso
        return comando;
    }

// Fecha apenas a conexão com o banco de dados
    public void fecharConexao() {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException erro) {
            // Registra o erro em arquivo de log em vez de mostrar na tela
            Logger.getLogger(GerenciadorConexao.class.getName())
                    .log(Level.SEVERE, null, erro);
        }
    }

// Fecha a conexão e também um comando SQL que foi usado
    public void fecharConexao(PreparedStatement comando) {
        fecharConexao();  // Primeiro fecha a conexão principal

        try {
            if (comando != null) {
                comando.close();  // Depois fecha o comando
            }
        } catch (SQLException erro) {
            Logger.getLogger(GerenciadorConexao.class.getName())
                    .log(Level.SEVERE, null, erro);
        }
    }

// Fecha a conexão, o comando e também os resultados de uma consulta
    public void fecharConexao(PreparedStatement comando, ResultSet resultado) {
        fecharConexao(comando);  // Fecha conexão e comando

        try {
            if (resultado != null) {
                resultado.close();  // Por último fecha os resultados
            }
        } catch (SQLException erro) {
            Logger.getLogger(GerenciadorConexao.class.getName())
                    .log(Level.SEVERE, null, erro);
        }

    }
}
