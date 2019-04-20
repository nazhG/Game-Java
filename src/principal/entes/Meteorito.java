package principal.entes;

import java.awt.Graphics;

public class Meteorito extends EnteFisico{
    
//        int[] polygon2Xs = {100 + 0, 100 + 32, 100 + 32, 100 + 0};
//        int[] polygon2Ys = {100 + 0, 100 + 0, 100 + 32, 100 + 32};
//        prueba = new Polygon(polygon2Xs, polygon2Ys, polygon2Xs.length);
    double velMovX = 0;
    double velMovY = 0;
    int width = 40;
    int height = 40;

    public Meteorito(double posX, double posY, int width, int height, int velMovX, int velMovY) {
        super(posX, posY);
        this.width = width;
        this.height = height;
        this.velMovX = velMovX;
        this.velMovY = velMovY;
    }

    @Override
    public void dibujar(Graphics g, boolean block) {
        g.drawOval((int)posX, (int)posY, width, height);
    }

    @Override
    public void actualizar() {
        this.posX=this.posX+velMovX;
        this.posY=this.posY+velMovY;
    }
    
}
