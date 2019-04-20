package principal.entes;

import java.awt.Color;
import java.awt.Graphics;
import principal.Constantes;

public class Lay extends EnteFisico{
    
    int anchoPantalla = Constantes.ANCHO_PANTALLA;
    int altoPantalla = Constantes.ALTO_PANTALLA;
    public int spriteSize = Constantes.LADO_SPRITE;
    
    public int loopXlay;
    public int loopYlay;
    
    Color gridColor;

    public Lay(double posX, double posY) {
        super(posX, posY);
        gridColor = Color.white;
      
        loopXlay = (int)(anchoPantalla/spriteSize);
        loopYlay = (int)(altoPantalla/spriteSize);
    }

    @Override
    public void dibujar(Graphics g, boolean block) {
        
        g.setColor(gridColor);
        
        for (int j = 0; j < loopYlay; j++) {
            g.drawLine(0, j*spriteSize, anchoPantalla, j*spriteSize);
        }
        for (int i = 0; i < loopXlay; i++) {
            g.drawLine(i*spriteSize, 0, i*spriteSize, altoPantalla);
        }
    }

    @Override
    public void actualizar() {
        
    }
    
}
