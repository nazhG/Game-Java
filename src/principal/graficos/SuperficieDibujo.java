package principal.graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import principal.controles.GestorControles;
import principal.controles.Raton;
import principal.controles.Teclado;
import principal.maquinaEstado.GestorEstados;

public class SuperficieDibujo extends Canvas {

    //serializar??
    private int ancho;
    private int alto;

    private Raton raton;

    public SuperficieDibujo(final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.raton = new Raton();
        
        setCursor(raton.getCursor());

        setIgnoreRepaint(true);//java previo al 7 u 8, previene repaint
        setPreferredSize(new Dimension(ancho, alto));
        addKeyListener(GestorControles.teclado);
        setFocusable(true);
        requestFocus();
    }

    public void dibujar(final GestorEstados ge) {
        BufferStrategy buffer = getBufferStrategy();

        if (buffer == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = buffer.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, ancho, alto);

        ge.dibujar(g);//unico objeto de dibujo de el juego

        Toolkit.getDefaultToolkit().sync();//dibujar de manera sincronizada con los hercios de la pantalla

        g.dispose();

        buffer.show();
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

}
