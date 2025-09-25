package controlar;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Usuario;
import utilidade.Util;

public class ControladorDeUsuario {

    public Usuario autenticar(String email, String senha) {
        String sql = "SELECT * FROM USUARIO WHERE email = ? AND senha = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Usuario usu = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setString(1, email.trim());
            comando.setString(2, senha.trim());

            resultado = comando.executeQuery();
            
            if (resultado.next()) {
                usu = new Usuario();
                usu.setPkUsuario(resultado.getInt("pkUsuario"));
                usu.setNome(resultado.getString("nome"));
                usu.setEmail(resultado.getString("email"));
                usu.setSenha(resultado.getString("senha"));
                usu.setTelefone(resultado.getString("telefone"));
                usu.setDataNascimento(resultado.getDate("data_nascimento"));
                usu.setObjetivo(resultado.getString("objetivo"));
                usu.setCpf(resultado.getString("cpf"));
                usu.setSexo(resultado.getString("sexo"));

                byte[] imagemBytes = resultado.getBytes("imagem");
                if (imagemBytes != null && imagemBytes.length > 0) {
                    ImageIcon icon = new ImageIcon(imagemBytes);
                    Icon iconRed = Util.redimensionarImagem(icon, 96, 129);
                    usu.setImagem(iconRed);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na autenticação: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        return usu;
    }

    public boolean inserir(Usuario cliente) {
        String sql = "INSERT INTO USUARIO (nome, email, senha, telefone, data_nascimento, objetivo, imagem, cpf, sexo) VALUES (?,?,?,?,?,?,?,?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setString(3, cliente.getSenha());
            comando.setString(4, cliente.getTelefone());
            comando.setDate(5, new java.sql.Date(cliente.getDataNascimento().getTime()));
            comando.setString(6, cliente.getObjetivo());
            comando.setBytes(7, Util.converterIconToBytes(cliente.getImagem()));
            comando.setString(8, cliente.getCpf());
            comando.setString(9, cliente.getSexo());

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir usuário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public boolean alterar(Usuario usuario) {
        String sql = "UPDATE USUARIO SET nome = ?, email = ?, senha = ?, telefone = ?, data_nascimento = ?, objetivo = ?, imagem = ?, cpf = ?"
                + " WHERE pkUsuario = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getEmail());
            comando.setString(3, usuario.getSenha());
            comando.setString(4, usuario.getTelefone());
            comando.setDate(5, new java.sql.Date(usuario.getDataNascimento().getTime()));
            comando.setString(6, usuario.getObjetivo());
            comando.setBytes(7, Util.converterIconToBytes(usuario.getImagem()));
            comando.setString(8, usuario.getCpf());
            comando.setInt(9, usuario.getPkUsuario());

            int linhas = comando.executeUpdate();
            return linhas > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            gerenciador.fecharConexao(comando);
        }

        return false;
    }

    public List<Usuario> consultar(int opcaoFiltro, String opcao) {
        String sql = "SELECT * from USUARIO";

        switch (opcaoFiltro) {
            case 0:
                break;
            case 1:
                sql += " Where nome like '%" + opcao + "%'";
                break;
            case 2:
                sql += " Where data_nascimento like '%" + opcao + "%'";
                break;
        }

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Usuario> lista = new ArrayList<>();

        try {
            comando = gerenciador.prepararComando(sql);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Usuario usu = new Usuario();

                usu.setPkUsuario(resultado.getInt("pkUsuario"));
                usu.setNome(resultado.getString("nome"));
                usu.setEmail(resultado.getString("email"));
                usu.setSenha(resultado.getString("senha"));
                usu.setDataNascimento(resultado.getDate("data_nascimento"));
                usu.setObjetivo(resultado.getString("objetivo"));
                byte[] bytes = resultado.getBytes("imagem");

                if (bytes != null) {
                    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                    BufferedImage imagem = ImageIO.read(bis);
                    usu.setImagem(new ImageIcon(imagem));
                }
                usu.setDataCadastro(resultado.getDate("data_cadastro"));
                usu.setCpf(resultado.getString("cpf"));

                lista.add(usu);
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "Erro na consulta: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }
        return lista;
    }
}