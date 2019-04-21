package principal.maquinaEstado.estados.juego;

import java.awt.Color;
import java.awt.Graphics;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import principal.controles.GestorControles;
import principal.entes.Ente;
import principal.entes.Jugador;
import principal.entes.Lay;
import principal.entes.Meteorito;
import principal.mapas.Mapa;
import principal.mapas.RamsMap;
import principal.maquinaEstado.EstadoJuego;
import principal.sprites.HojaSprite;

public class GestorJuego implements EstadoJuego {

    HojaSprite hs = new HojaSprite("/texturas/hojaSprite.png", 32, 32, true);

    //Mapa mapa = new Mapa("/texto/prueba");
    RamsMap mapa = new RamsMap(5);
    private long coolDown = 0;
    private long coolDownSpaceBar = 500_000_000L;

    ArrayList<Ente> entes = new ArrayList();
    int jugador;
    boolean isCameraBloked = false;

    public void cargarEntes() {
        final long inicoCarga = System.nanoTime();
        System.out.print("cargando ... ");
        entes.add(jugador = 0, new Jugador(0, 0));
        //entes.add(new Meteorito(40, 40, 40, 40,1,1));
        //entes.add(new Meteorito(100, 100, 40, 40,-1,-1));
        long tiempoCarga = System.nanoTime() - inicoCarga;
        System.out.println(String.format("%.5fs", Double.valueOf(tiempoCarga)*0.000000001));
    }

    @Override
    public void actualizar() {
        //gestor de cooldown
        if (GestorControles.teclado.espacio.isPulsada() && (coolDown < System.nanoTime())) {
            coolDown = System.nanoTime() + coolDownSpaceBar;
            mapa.reGenerarMapaAlt();
        }
        for (Ente ente : entes) {
            ente.actualizar();
        }
    }

    @Override
    public void dibujar(Graphics g) {
        mapa.dibujar(g, 0, 0);
        for (Ente ente : entes) {
            ente.dibujar(g, isCameraBloked);
        }

        g.setColor(Color.red);

        g.drawString("X : " + ((Jugador) entes.get(jugador)).getPosicionX(), 20, 20);
        g.drawString("Y : " + ((Jugador) entes.get(jugador)).getPosicionY(), 20, 30);
    }

}
