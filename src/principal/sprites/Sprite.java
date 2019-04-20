package principal.sprites;

import java.awt.image.BufferedImage;

public class Sprite {

    private final BufferedImage image;

    private final int ancho;
    private final int alto;

    private int referencia;
    private String nombreReferenia;

    public Sprite(BufferedImage image) {
        this.image = image;

        ancho = image.getWidth();
        alto = image.getHeight();
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getReferencia() {
        return referencia;
    }

    public String getNombreReferenia() {
        return nombreReferenia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public void setNombreReferenia(String nombreReferenia) {
        this.nombreReferenia = nombreReferenia;
    }

}
