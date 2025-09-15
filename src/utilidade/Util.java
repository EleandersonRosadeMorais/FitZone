package utilidade;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Util {

    public static Image getIcone() {
        URL localImagem = Util.class.getResource("/imagens/logo.png");

        ImageIcon logo = new ImageIcon(localImagem);

        return logo.getImage();
    }
}
