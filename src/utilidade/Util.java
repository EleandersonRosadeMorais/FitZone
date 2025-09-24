package utilidade;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Util {

    public static Image getIcone() {
        URL localImagem = Util.class.getResource("/imagens/logo.png");

        ImageIcon logo = new ImageIcon(localImagem);

        return logo.getImage();
    }

    public static String calcularHash(String senha) {
        String hashSHA1 = "";
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA1");

            sha1.update(senha.getBytes());

            byte[] digest = sha1.digest();

            for (byte b : digest) {
                hashSHA1 = hashSHA1 + String.format("%02x", b);
            }

        } catch (NoSuchAlgorithmException e) {
            System.err.println("O SHA1 não encontrado");
        }

        return hashSHA1;
    }

    public static byte[] converterIconToBytes(Icon icon) {
        BufferedImage image = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        icon.paintIcon(null, g2d, 0, 0);
        g2d.dispose();

        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", byteArray);
        } catch (IOException erro) {
            Logger.getLogger(Util.class.getName()).log(
                    Level.SEVERE, null, erro);
        }
        return byteArray.toByteArray();
    }

    public static Date converterStringToDate(String texto) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        Date data = null;

        try {
            data = formato.parse(texto);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao converter a data");
        }
        return data;
    }

    public static File escolherImagem() {
        File arquivo = null;

        JFileChooser exploradorArquivos = new JFileChooser();

        exploradorArquivos.setDialogTitle("Escolha um arquivo");

        FileNameExtensionFilter filtro = new FileNameExtensionFilter(
                "Imagens", "jpg", "jpeg", "png");
        exploradorArquivos.setFileFilter(filtro);

        exploradorArquivos.setMultiSelectionEnabled(false);

        int resultado = exploradorArquivos.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            arquivo = exploradorArquivos.getSelectedFile();
        }

        return arquivo;
    }

    public static Icon converterFileToIcon(File arquivo) {
        ImageIcon icon = new ImageIcon(arquivo.getAbsolutePath());
        return icon;
    }

    public static ImageIcon redimensionarImagem(Icon icone,
            int largura, int altura) {

        Image imagemOriginal = ((ImageIcon) icone).getImage();

        Image novaImagem = imagemOriginal.getScaledInstance(
                largura, altura, Image.SCALE_SMOOTH);

        return new ImageIcon(novaImagem);

    }

    public static String converterDateToString(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }

    public static boolean validarCref(String cref) {
        String regex = "^[0-9]{6}-[A-Z]/[A-Z]{2}$";
        return cref.matches(regex);
    }

    public static String removerCpf(String cpf) {
        return cpf = cpf.replaceAll("[^0-9]", "");
    }

    public static  boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) {
            return false;
        }
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        int soma = 0;
        int peso = 10;
        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * peso--;
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 >= 10) {
            digito1 = 0;
        }
        soma = 0;
        peso = 11;
        for (int i = 0; i < 10; i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * peso--;
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 >= 10) {
            digito2 = 0;
        }
        return cpf.charAt(9) == (digito1 + '0') && cpf.charAt(10) == (digito2 + '0');
    }
}
