package principal.mapas;

import java.awt.Rectangle;
import principal.sprites.Sprite;

public class Tile {//compartir sprites para desocupar memoria
    
    private final Sprite sprite;
    private final int id;
    private boolean solido;

    public Tile(Sprite sprite, int id) {
        this.sprite = sprite;
        this.id = id;
        this.solido = false;
    }

    public Tile(Sprite sprite, int id, boolean solido) {
        this(sprite, id);
        this.solido = solido;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getId() {
        return id;
    }

    public boolean isSolido() {
        return solido;
    }

    public void setSolido(final boolean solido) {
        this.solido = solido;
    }
    
    public Rectangle obRectangle(final int x,final int y) {
     return new Rectangle(x, y, sprite.getAncho(), sprite.getAlto());
    }
    
}
