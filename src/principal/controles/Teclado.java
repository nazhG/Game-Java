package principal.controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

    public Tecla arriba = new Tecla();
    public Tecla abajo = new Tecla();
    public Tecla derecha = new Tecla();
    public Tecla izquierda = new Tecla();
    public Tecla espacio = new Tecla();

    public void keyPressed(KeyEvent e) {
        int pressedKey = e.getKeyCode();
        if (pressedKey == KeyEvent.VK_W) {
            abajo.teclaPulsada();
        } else if (pressedKey == KeyEvent.VK_S) {
            arriba.teclaPulsada();
        }
        if (pressedKey == KeyEvent.VK_D) {
            derecha.teclaPulsada();
        } else if (pressedKey == KeyEvent.VK_A) {
            izquierda.teclaPulsada();
        }
        if (pressedKey == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        if (pressedKey == KeyEvent.VK_SPACE) {
            espacio.teclaPulsada();
        }
    }

    public void keyReleased(KeyEvent e) {
        int releasedKey = e.getKeyCode();
        if (releasedKey == KeyEvent.VK_W) {
            abajo.teclaLiberada();
        } else if (releasedKey == KeyEvent.VK_S) {
            arriba.teclaLiberada();
        }
        if (releasedKey == KeyEvent.VK_D) {
            derecha.teclaLiberada();
        } else if (releasedKey == KeyEvent.VK_A) {
            izquierda.teclaLiberada();
        }
        if (releasedKey == KeyEvent.VK_SPACE) {
            espacio.teclaLiberada();
        }
    }

    public void keyTyped(KeyEvent e) {

    }

}
