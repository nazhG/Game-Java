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
    List<Hall> halls;

    public RamsMap(int roomsNumbers) {
        this.roomsNumbers = roomsNumbers;
        this.lay = new Lay(0, 0);
        this.drawLay = true;
        rooms = new ArrayList();
        halls = new ArrayList();
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
        int minNumHall = roomsNumbers - 1;
        int maxNumHall = 0;
        for (int i = 1; i < roomsNumbers; i++) {
            maxNumHall += roomsNumbers - i;
        }
        int numHalls = (int) (Math.random() * maxNumHall) + minNumHall;
        boolean isHallOk = false;
        for (int i = 0; i < numHalls; i++) {
            do {
                int inicioHall = (int) (Math.random() * roomsNumbers);
                int finHall = (int) (Math.random() * roomsNumbers);
                if (inicioHall != finHall && !thereIsHall(inicioHall, finHall)) {
                    isHallOk = true;
                    halls.add(new Hall(inicioHall, finHall));
                } else {
                    isHallOk = false;
                }
            } while (isHallOk);
        }
        System.out.println("#HALLS = " + numHalls);
        for (Hall hall : halls) {
            System.out.println(hall.toString());
        }
    }

    public void dibujar(Graphics g, int posicionX, int posicionY) {
        if (drawLay) {
            lay.dibujar(g, false);
        }
        for (Hall hall : halls) {
            Room startRoom = rooms.get(hall.inicio);
            Room endRoom = rooms.get(hall.fin);
            g.setColor(Color.red);
            g.setColor(Color.red);
            g.drawLine(startRoom.x, startRoom.y, endRoom.x, endRoom.y);
            g.setColor(Color.white);
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
        halls.clear();
        this.generarMapaAlt();
    }

    private boolean thereIsHall(int inicioHall, int finHall) {
        for (Hall hall : halls) {
            if ((hall.inicio == inicioHall && hall.fin == finHall) || (hall.inicio == finHall && hall.fin == inicioHall)) {
                return true;
            }
        }
        return false;
    }

}
