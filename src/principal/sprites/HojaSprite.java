package principal.sprites;

import java.awt.image.BufferedImage;
import principal.herramientas.CargadorRecursos;

public class HojaSprite {

    final private int anchoEnPixeles;
    final private int altoEnPixeles;

    final private int anchoEnSprites;
    final private int altoEnSprites;

    final private int anchoXsprite;
    final private int altoXsprite;

    final private Sprite[] sprites;

    public HojaSprite(final String ruta, final int altoSprites, final int anchoSprites, final boolean opacidad) {
        final BufferedImage image;

        if (opacidad) {
            image = CargadorRecursos.cargarImagenCompatibleOpaca(ruta);
        } else {
            image = CargadorRecursos.cargarImagenCompatibleTranslucida(ruta);
        }

        anchoEnPixeles = image.getWidth();
        altoEnPixeles = image.getHeight();

        this.anchoEnSprites = anchoEnPixeles / altoSprites;
        this.altoEnSprites = altoEnPixeles / altoSprites;

        anchoXsprite = altoSprites;
        altoXsprite = altoSprites;

        sprites = new Sprite[anchoSprites * altoSprites];

        extraerSprites(image);
    }

    private void extraerSprites(final BufferedImage image) {
        for (int y = 0; y < altoEnSprites; y++) {
            for (int x = 0; x < anchoEnSprites; x++) {
                final int posicionX = x * anchoXsprite;
                final int posicionY = y * anchoXsprite;
                sprites[x + y * anchoEnSprites] = new Sprite(image.getSubimage(posicionX, posicionY, anchoXsprite, altoXsprite));
            }
        }
    }

    public Sprite getSprites(final int i) {
        return sprites[i];
    }

    public Sprite getSprites(final int x,final int y) {
        return sprites[x+y*anchoEnSprites];
    }
  

}
