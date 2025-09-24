package controlar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidade.DialogManager;

public class GerenciadorConexao {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/fitzone";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private Connection conexao;

    public Connection getConexao() {
        return conexao;
    }

    public GerenciadorConexao() {
        try {
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            DialogManager.showErrorDialog(null, "Erro de conexão: " + e.getMessage());
        }
    }

    public PreparedStatement prepararComando(String sql) {
        PreparedStatement comando = null;

        try {
            comando = conexao.prepareStatement(sql);
        } catch (SQLException erro) {
            DialogManager.showErrorDialog(null, "Erro ao preparar comando: " + erro.getMessage());
        }
        return comando;
    }

    public void fecharConexao() {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException erro) {
            Logger.getLogger(GerenciadorConexao.class.getName())
                    .log(Level.SEVERE, null, erro);
        }
    }

    public void fecharConexao(PreparedStatement comando) {
        fecharConexao(); 

        try {
            if (comando != null) {
                comando.close();
            }
        } catch (SQLException erro) {
            Logger.getLogger(GerenciadorConexao.class.getName())
                    .log(Level.SEVERE, null, erro);
        }
    }

    public void fecharConexao(PreparedStatement comando, ResultSet resultado) {
        fecharConexao(comando); 

        try {
            if (resultado != null) {
                resultado.close();
            }
        } catch (SQLException erro) {
            Logger.getLogger(GerenciadorConexao.class.getName())
                    .log(Level.SEVERE, null, erro);
        }
    }
}