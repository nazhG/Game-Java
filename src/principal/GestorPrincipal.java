package principal;

import principal.graficos.SuperficieDibujo;
import principal.graficos.Ventana;
import principal.maquinaEstado.GestorEstados;

/**
*
* @author AgroByte_Games
* @version 0.0.3
* 
**/

public class GestorPrincipal {

    private boolean enFuncionamiento = false;
    private String titulo;
    private int ancho;
    private int alto;

    private SuperficieDibujo sd;
    private Ventana ventana;
    private GestorEstados ge;

    private GestorPrincipal(String titulo, int ancho, int alto) {
        this.titulo = titulo;
        this.ancho = ancho;
        this.alto = alto;
    }

    public static void main(String[] args) {
        
        GestorPrincipal gp = new GestorPrincipal("Primal Spirit", Constantes.ANCHO_PANTALLA, Constantes.ALTO_PANTALLA);

        gp.iniciarJuego();
        gp.iniciarBucle();
    }

    private void iniciarJuego() {
        enFuncionamiento = true;
        inicializar();
    }

    private void inicializar() {
        sd = new SuperficieDibujo(ancho, alto);
        ventana = new Ventana(titulo, sd);
        ge = new GestorEstados();

    }

    private void iniciarBucle() {
        int aps = 0;
        int fps = 0;

        final int NS_POR_SEGUNDO = 1000000000;
        final byte APS_OBJETIVO = 60;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();

        double tiempoTranscurrido;
        double delta = 0;//cantidad de tiempo por actualizacion

        while (enFuncionamiento) {
            final long inicioBucle = System.nanoTime();

            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;

            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

            while (delta >= 1) {
                actualizar();
                aps++;
                Constantes.APS = aps;
                delta--;
            }

            dibujar();
            fps++;

            if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {//esto occure cada segundo
//                ventana.setTitle(NOMBRE + " || APS: " + aps + " || FPS: " + fps);
//                APS = "aps: " + aps;
//                FPS = "fps: " + fps;
//                System.out.println("aps: " + aps + " fps: " + fps);
                aps = 0;
                fps = 0;
                referenciaContador = System.nanoTime();
            }
        }
    }

    private void actualizar() {
        ge.actualizar();
    }

    private void dibujar() {
        sd.dibujar(ge);
    }

}
