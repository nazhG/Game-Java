package principal.entes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import javafx.scene.shape.Circle;
import principal.Constantes;
import principal.controles.GestorControles;
import principal.sprites.HojaSprite;
import principal.sprites.Sprite;

public class Jugador extends EnteFisico {

    private HojaSprite hs;
    private BufferedImage imagenActual;
    private Rectangle hitBox;

    public Jugador(double posX, double posY) {
        super(posX, posY);
        this.velDes = 1;
        hs = new HojaSprite(Constantes.PERSONAJE_PRUEBA_RUTA, 32, 32, false);
        imagenActual = hs.getSprites(0).getImage();
        hitBox = new Rectangle((int) posX, (int) posY, 32, 32);

    }

    public void actualizar() {
        //coliciona?
        determinarDireccion();//mover

    }

    private void determinarDireccion() {
        final int velocidadX = evaluarVelocidadX();
        final int velocidadY = evaluarVelocidadY();

        if (velocidadX == 0 && velocidadY == 0) {
            return;
        }
        if (velocidadX != 0 || velocidadY != 0) {
            mover(velocidadX, velocidadY);
        }
    }

    private void mover(int velocidadX, int velocidadY) {
        cambiarDirreccion(velocidadX, velocidadY);
        posX += velocidadX * velDes;
        posY += velocidadY * velDes;
        hitBox.translate((int) (velocidadX * velDes), (int) (velocidadY * velDes));
    }

    private void cambiarDirreccion(int velocidadX, int velocidadY) {

        if (velocidadX == 1) {
            direccion = 3;
        } else if (velocidadY == 1) {
            direccion = 2;
        }
        if (velocidadY == -1) {
            direccion = 1;
        } else if (velocidadY == 1) {
            direccion = 0;
        }
    }

    private int evaluarVelocidadX() {
        int velocidadX = 0;
        if (GestorControles.teclado.izquierda.isPulsada()) {
            velocidadX = -1;
        }
        if (GestorControles.teclado.derecha.isPulsada()) {
            velocidadX = 1;
        }
        return velocidadX;
    }

    private int evaluarVelocidadY() {
        int velocidadY = 0;
        if (GestorControles.teclado.abajo.isPulsada()) {
            velocidadY = -1;
        }
        if (GestorControles.teclado.arriba.isPulsada()) {
            velocidadY = 1;
        }
        return velocidadY;
    }

    public void dibujar(Graphics g, boolean block) {
        //corregir
        final int centroX = Constantes.ANCHO_PANTALLA / 2 - Constantes.LADO_SPRITE / 2;
        final int centroY = Constantes.ALTO_PANTALLA / 2 - Constantes.LADO_SPRITE / 2;
        int auxX = 0;
        int auxY = 0;
        if (!block) {
            auxX = (int) posX;
            auxY = (int) posY;
        }

        g.setColor(Color.green);
        g.drawImage(imagenActual, auxX, auxY, null);
        g.drawRect(centroX, centroY, imagenActual.getWidth(), imagenActual.getHeight());
        g.drawRect((int) posX, (int) posY, 32, 32);
    }

    public void setPosicionX(double posicionX) {
        this.posX = posicionX;
    }

    public void setPosicionY(double posicionY) {
        this.posY = posicionY;
    }

    public void setDesplazamiento(double desplazamiento) {
        this.velDes = desplazamiento;
    }

    public double getPosicionX() {
        return posX;
    }

    public double getPosicionY() {
        return posY;
    }

    public double getDesplazamiento() {
        return velDes;
    }

}
