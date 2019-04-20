package principal.mapas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import principal.Constantes;
import principal.herramientas.CargadorRecursos;
import principal.sprites.HojaSprite;
import principal.sprites.Sprite;

public class Mapa {

    private String nombre;
    private int ancho;
    private int alto;

    private ArrayList<Sprite> paleta;

    private int[] mapaSprites;
    private boolean[] mascaraColiciones;

    public Mapa(final String ruta) {

        String contenido = CargadorRecursos.leerArchivoTexto(ruta);
        String[] partes = contenido.split("\\*");//carapter especial en expreciones regulares

        nombre = partes[0];

        try {
            this.ancho = Integer.parseInt(partes[1]);
            this.alto = Integer.parseInt(partes[2]);
        } catch (Exception e) {//ERROR CLASS
        }

        String[] hojas = partes[3].split(",");
        HojaSprite[] hojaSprite = new HojaSprite[hojas.length];
        for (int i = 0; i < hojas.length; i++) {
            String[] parametros = hojas[i].split("-");
            hojaSprite[i] = new HojaSprite(parametros[0], Integer.parseInt(parametros[1]), Integer.parseInt(parametros[2]), Boolean.parseBoolean(parametros[3]));
        }

        String[] partesPaleta = partes[4].split("#");
        paleta = new ArrayList<Sprite>();
        for (int i = 0; i < partesPaleta.length; i++) {
            String[] parametros = partesPaleta[i].split("-");
            int referNumber = Integer.parseInt(parametros[0]);
            paleta.add(referNumber, hojaSprite[Integer.parseInt(parametros[1])].getSprites(Integer.parseInt(parametros[2])));
            paleta.get(referNumber).setReferencia(referNumber);
            paleta.get(referNumber).setNombreReferenia(parametros[3]);
        }

        String coliciones = partes[5];
        mascaraColiciones = new boolean[coliciones.length()];
        for (int i = 0; i < coliciones.length(); i++) {
            mascaraColiciones[i] = coliciones.charAt(i) == '1' ? true : false;
        }

        String[] spritesEnteros = partes[6].split("-");
        mapaSprites = new int[spritesEnteros.length];
        for (int i = 0; i < spritesEnteros.length; i++) {
            mapaSprites[i] = Integer.parseInt(spritesEnteros[i]);
        }

    }

    public void mostrarCarga(Graphics g) {
        int inicio = 10, x = inicio, y = inicio, aumento = 15, a = aumento;
        g.setColor(Color.white);
        String contenido;

        contenido = nombre + " {";
        g.drawString(contenido, x, y);
        y += a;

        contenido = "ancho=" + ancho + ", alto=" + alto;
        g.drawString(contenido, x, y);
        y += a;

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                char aux = ' ';
                if (mascaraColiciones[(i * ancho) + j]) {
                    aux = 'S';
                    g.setColor(Color.white);
                } else {
                    aux = ' ';
                    g.setColor(Color.GRAY);
                }
                contenido = (i * ancho) + j + " " + mapaSprites[(i * ancho) + j] + "-" + aux;
                g.drawString(contenido, x, y);
                x += aumento * 4;
            }
            x = inicio;
            y += a;
        }
        g.setColor(Color.white);
        for (Sprite temp : paleta) {
            BufferedImage img = temp.getImage();
            g.drawString(temp.getNombreReferenia() + "->" + String.valueOf(temp.getReferencia()), x, y);
            g.drawImage(img, x, y, null);
            x += a * 3;
            y += a * 1;
        }
        g.drawString("}", x, y);
    }

    public ArrayList mostarPaleta() {
        return paleta;
    }

    public void dibujar(Graphics g, int posicionX, int posicionY) {
        int anchoSprite = Constantes.LADO_SPRITE;
        int altoSprite = anchoSprite;
        for (int y = 0; y < this.alto; y++) {
            for (int x = 0; x < this.ancho; x++) {
                BufferedImage imagen = paleta.get(mapaSprites[x + y * ancho]).getImage();
                //DESPLASAMIENTO DE BIT <---
                g.drawImage(imagen, x * anchoSprite - posicionX , y * altoSprite - posicionY, null);
            }
        }

    }

}
