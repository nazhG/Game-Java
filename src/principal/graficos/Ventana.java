package principal.graficos;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import principal.herramientas.CargadorRecursos;

public class Ventana extends JFrame {

    // serial UID ????
    private String titulo;
    private final ImageIcon icono;

    public Ventana(final String titulo, final SuperficieDibujo sd) {
        this.titulo = titulo;
        BufferedImage imagen = CargadorRecursos.cargarImagenCompatibleTranslucida("/iconos/fireball.png");
        this.icono = new ImageIcon(imagen);
        
        configurarVenatna(sd);
    }

    private void configurarVenatna(final SuperficieDibujo sd) {
        setTitle(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(icono.getImage());
        setLayout(new BorderLayout());
        add(sd, BorderLayout.CENTER);
//        setUndecorated(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
