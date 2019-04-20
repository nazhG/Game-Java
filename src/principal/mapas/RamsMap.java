package principal.mapas;

import java.awt.Graphics;
import java.awt.Rectangle;
import principal.controles.GestorControles;
import principal.entes.Lay;

public class RamsMap {

    int roomsNumbers;
    Lay lay;
    boolean drawLay;
    Rectangle rooms[];

    public RamsMap(int roomsNumbers) {
        this.roomsNumbers = roomsNumbers;
        this.lay = new Lay(0, 0);
        this.drawLay = true;
        rooms = new Rectangle[roomsNumbers];
        for (int i = 0; i < roomsNumbers; i++) {
            int x = ((int) (Math.random() * (lay.loopXlay-1)) + 1) * lay.spriteSize;
            int y = ((int) (Math.random() * (lay.loopYlay-1)) + 1) * lay.spriteSize;
            rooms[i] = new Rectangle(x, y, lay.spriteSize, lay.spriteSize);
        }
    }
    
    public void reGenerar() {
        if (GestorControles.teclado.espacio.isPulsada()) {
            for (int i = 0; i < roomsNumbers; i++) {
                int x = ((int) (Math.random() * (lay.loopXlay - 1)) + 1) * lay.spriteSize;
                int y = ((int) (Math.random() * (lay.loopYlay - 1)) + 1) * lay.spriteSize;
                System.out.println(x/32 + " - " + y/32);
                rooms[i] = new Rectangle(x, y, lay.spriteSize, lay.spriteSize);
            }
        }
    }

    public void dibujar(Graphics g, int posicionX, int posicionY) {
        if (drawLay) {
            lay.dibujar(g, false);
        }
        for (int i = 0; i < roomsNumbers; i++) {
            g.fillRect(rooms[i].x, rooms[i].y, rooms[i].width, rooms[i].height);
        }
    }

}
