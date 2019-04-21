package principal.mapas;

import java.awt.Rectangle;

/**
 *
 * @author nazh_G
 */
public class Room extends Rectangle {
    
    String info;
    /* X Y ENTERO */
    public int posX;
    public int posY;

    Room(int x, int y, int spriteSize, String info) {
        super(x,y,spriteSize,spriteSize);
        this.posX = x / spriteSize;
        this.posY = y / spriteSize;
        this.info = info;
    }
    
}
