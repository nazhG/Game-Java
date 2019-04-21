package principal.mapas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import principal.controles.GestorControles;
import principal.entes.Lay;

public class RamsMap {

    int roomsNumbers;
    Lay lay;
    boolean drawLay;
    List<Room> rooms;

    public RamsMap(int roomsNumbers) {
        this.roomsNumbers = roomsNumbers;
        this.lay = new Lay(0, 0);
        this.drawLay = true;
        rooms = new ArrayList();
        generarMapaAlt();
    }

    public void generarMapaAlt() {
        for (int i = 0; i < roomsNumbers; i++) {
            int x;
            int y;
            do {
                x = (int) (Math.random() * lay.loopXlay);
                y = (int) (Math.random() * lay.loopYlay);
            } while (this.thereIsRoomIn(x, y));
            String infoRoom = (x) + ", " + (y);
            //System.out.println(infoRoom);
            x *= lay.spriteSize;
            y *= lay.spriteSize;
            rooms.add(new Room(x, y, lay.spriteSize, infoRoom));
        }
    }

    public void dibujar(Graphics g, int posicionX, int posicionY) {
        if (drawLay) {
            lay.dibujar(g, false);
        }
        for (Room room : rooms) {
            g.fillRect(room.x, room.y, room.width, room.height);
            g.setColor(Color.black);
            g.drawString(room.info, room.x, room.y + 10);
            g.setColor(Color.white);
        }
    }

    private boolean thereIsRoomIn(int x, int y) {
        for (Room room : rooms) {
            if (room.posX == x && room.posY == y) {
                return true;
            }
        }
        return false;
    }

    public void reGenerarMapaAlt() {
        rooms.clear();
        this.generarMapaAlt();
    }

}
