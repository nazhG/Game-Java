package principal.entes;

import java.awt.Graphics;

public abstract class EnteFisico implements Ente{

    protected double posX;
    protected double posY;
    protected double velDes;
    protected double rotation;
    /**
     * 1 = NORTE / ARRIBA ;
     * 2 = ESTE / DERECHA ;
     * 3 = SUR / ABAJO ;
     * 4 = OESTE / IZQUIERDA ;
     */
    protected int direccion = 1;

    public EnteFisico(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public EnteFisico(double posX, double posY, double velDes, double rotation) {
        this(posX,posY);
        this.velDes = velDes;
        this.rotation = rotation;
    }

}
