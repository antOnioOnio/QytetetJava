/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author anthonius
 */
public class Qytetet {
    
    private static Qytetet INSTANCE = new Qytetet();
    static final public int MAX_JUGADORES = 4;
    static final int MAX_CARTAS = 10;
    static final int MAX_CASILLAS = 20;
    static final int PRECIO_LIBERTAD = 200;
    static final int SALDO_SALIDA = 1000;

    private MetodoSalirCarcel metodo;
    private Sorpresa cartaActual = null;
    private ArrayList<Sorpresa> mazo;
    private Jugador jugadorActual;
    private ArrayList<Jugador> jugadores = new ArrayList();
    private Tablero tablero;
    //private Dado dado = Dado.getInstance();

    //metodos
//-------------------------------------------------------------------------------            
    public boolean aplicarSorpresa() {
        boolean tienePropietario = false;

        if (this.cartaActual.getTipo() == TipoSorpresa.PAGARCOBRAR) {
            this.jugadorActual.modificarSaldo(this.cartaActual.getValor());
        } else if (this.cartaActual.getTipo() == TipoSorpresa.IRACASILLA) {
            if (this.tablero.esCasillaCarcel(this.cartaActual.getValor())) {
                this.encarcelarJugador();
            } else {
                Casilla nuevaCasilla;
                nuevaCasilla = this.tablero.obtenerCasillaNumero(this.cartaActual.getValor());
                tienePropietario = this.jugadorActual.actualizarPosicion(nuevaCasilla);
            }
        } else if (this.cartaActual.getTipo() == TipoSorpresa.PORCASAHOTEL) {
            this.jugadorActual.pagarCobrarPorCasaYHotel(this.cartaActual.getValor());
        } else if (this.cartaActual.getTipo() == TipoSorpresa.PORJUGADOR) {
            for (Jugador jug : jugadores) {
                if (jug != this.jugadorActual) {
                    if (this.cartaActual.getValor() > 0) {
                        this.jugadorActual.modificarSaldo(this.cartaActual.getValor());
                        jug.modificarSaldo(-this.cartaActual.getValor());
                    } else {
                        this.jugadorActual.modificarSaldo(-this.cartaActual.getValor());
                        jug.modificarSaldo(this.cartaActual.getValor());
                    }
                }
            }
        } else if (this.cartaActual.getTipo() == TipoSorpresa.SALIRCARCEL) {
            this.jugadorActual.setCartaLibertad(cartaActual);
            this.mazo.add(cartaActual);
            
        }else if ( this.cartaActual.getTipo()== TipoSorpresa.CONVERTIRME){
            int pos =  jugadores.indexOf(this.jugadorActual);
            this.jugadorActual = this.jugadorActual.convertirme(this.cartaActual.getValor())  ;
            this.jugadores.set(pos,jugadorActual);
            // sino va hacerle cast
        }
        return tienePropietario;
    }
//-------------------------------------------------------------------------------        

    public boolean cancelarHipoteca(Casilla casilla) {
         return this.jugadorActual.puedoPagarHipotecar(casilla);

    }
//-------------------------------------------------------------------------------        

    public boolean comprarTituloPropiedad() {
        return this.jugadorActual.comprarTitulo();
    }
//-------------------------------------------------------------------------------        

    public boolean edificarCasa(Casilla casilla) {

        boolean puedoEdificar = false;

        if (casilla.soyEdificable()) {
            if (((Calle)casilla).sePuedeEdificarCasa()) {

                puedoEdificar = this.jugadorActual.puedoEdificarCasa(casilla);

                if (puedoEdificar) {
                    int costeEdificarCasa = ((Calle)casilla).edificarCasa();
                    this.jugadorActual.modificarSaldo(-costeEdificarCasa);
                }
            }
        }

        return puedoEdificar;
    }
//-------------------------------------------------------------------------------        

    public boolean edificarHotel(Casilla casilla) {
       boolean puedoEdificar = false;
         if (casilla.soyEdificable()) {
            if (((Calle)casilla).sePuedeEdificarHotel()) {

                puedoEdificar = this.jugadorActual.puedoEdificarHotel(casilla);

                if (puedoEdificar) {
                    int costeEdificarHotel = ((Calle)casilla).edificarHotel();
                    this.jugadorActual.modificarSaldo(-costeEdificarHotel);
                }
            }
        }
       
       return puedoEdificar;
    }
//-------------------------------------------------------------------------------    

    public Jugador getJugadorActual() {
        return jugadorActual;
    }
//-------------------------------------------------------------------------------    

    public Sorpresa getCartaActual() {
        return cartaActual;
    }
//-------------------------------------------------------------------------------        

    public boolean hipotecarPropiedad(Casilla casilla) {
        boolean puedoHipotecar = false;

        if (casilla.soyEdificable()) {

            boolean sePuedeHipotecar = !((Calle)casilla).estaHipotecada();

            if (sePuedeHipotecar) {

                puedoHipotecar = this.jugadorActual.puedoHipotecar(casilla);

                if (puedoHipotecar) {

                    int cantidadRecibida = ((Calle)casilla).hipotecar();

                }

            }
        }
        return puedoHipotecar;
    }
//-------------------------------------------------------------------------------        

    public  void inicializarJuego(ArrayList<String> nombres) {
        this.inicializarJugadores(nombres);
    //    this.inicializarCartasSorpresa();
    //    this.inicializarTablero();
        this.salidaJugadores();
    }
//-------------------------------------------------------------------------------        

    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo) {

        boolean libre = false;

        if (metodo == MetodoSalirCarcel.TIRANDODADO) {
            int valorDado = GUIQytetet.Dado.getInstance().nextNumber();
            if (valorDado > 5) {
                libre = true;
            }

        } else if (metodo == MetodoSalirCarcel.PAGANDOLIBERTAD) {
            
            int cantidad = -Qytetet.PRECIO_LIBERTAD;
            boolean tengoSaldo = this.jugadorActual.pagarLibertad(cantidad);
            libre = tengoSaldo;
        }
        if (libre) {
            this.jugadorActual.setEncarcelado(false);
        }
        return libre;
    }
//-------------------------------------------------------------------------------        

    public boolean Jugar() {
        boolean tienePropietario = false;
        int valorDado = GUIQytetet.Dado.getInstance().nextNumber();
        
        System.out.println("Valor De la tirada de " + this.jugadorActual.getNombre() + ": " + valorDado);
       
        Casilla casillaPosicion = this.jugadorActual.getCasillaActual();
        
        Casilla nuevaCasilla = this.tablero.obtenerNuevaCasilla(casillaPosicion, valorDado);
        System.out.println("Ha caido en la casilla numero: " + nuevaCasilla.getNumeroCasilla());
        tienePropietario = this.jugadorActual.actualizarPosicion(nuevaCasilla);

        if (!nuevaCasilla.soyEdificable()) {
            if (((OtraCasilla)nuevaCasilla).getTipo() == TipoCasilla.JUEZ) {
                this.encarcelarJugador();
            } else if (((OtraCasilla)nuevaCasilla).getTipo() == TipoCasilla.SORPRESA) {
                this.cartaActual = mazo.get(0);
                mazo.remove(0);
                mazo.add(cartaActual);
                
            }
        }

        return tienePropietario;
    }
//-------------------------------------------------------------------------------         

    public ArrayList<String> obtenerRanking() {
        ArrayList<String>ranking = new ArrayList();
        
        for (Jugador jug : this.jugadores) {
            ranking.add( jug.getNombre() + jug.obtenerCapital());
        }
   
        return ranking;
    }
//-------------------------------------------------------------------------------        

    public ArrayList<Casilla> propiedadesHipotecadasJugador(boolean hipotecadas) {

        return this.jugadorActual.obtenerPropiedadesHipotecadas(hipotecadas);

    }
//-------------------------------------------------------------------------------        

    public Jugador siguienteJugador() {
     
        int pos ;
       
        pos = ((jugadores.indexOf(this.jugadorActual))+1)%(jugadores.size() - 1);
        this.jugadorActual =  jugadores.get(pos);
    
        return this.jugadorActual;
        
    }
//-------------------------------------------------------------------------------        

    public boolean venderPropiedad(Casilla casilla) {
        boolean puedoVender = false;

        puedoVender = this.jugadorActual.puedovenderPropiedad(casilla);

        if (casilla.soyEdificable() && puedoVender) {
            this.jugadorActual.venderPropiedad(casilla);
        }

        return puedoVender;
    }
//-------------------------------------------------------------------------------        

    private void encarcelarJugador() {
        Casilla casillaCarcel = null;
        if (!this.jugadorActual.tengoCartaLibertad()) {
            casillaCarcel = this.tablero.getCarcel();
            this.jugadorActual.irACarcel(casillaCarcel);
        } else {
            Sorpresa carta = this.jugadorActual.devolverCartaLibertad();
            this.mazo.add(carta);
        }
    }
//-------------------------------------------------------------------------------        

    private void inicializarCartasSorpresa() {
        mazo = new ArrayList(MAX_CARTAS);

        mazo.add(new Sorpresa("Lastima, tus acciones acaban de caer y pierdes 200 euros", -200, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Hoy es tu dia de suerte, ha llegado el sobre de tu abuela con 200 euros", 200, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Te hemos pillado evadiendo impuestos, ¡debes ir a la carcel!", tablero.getCarcel().getNumeroCasilla(), TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Ve al parking a meditar sobre la vida", 6, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Subete a mi coche que te voy a dejar 5 casillas mas adelante", +5, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Ha llegado la declaracion de la renta y te sale a devolver por cada propiedad 100 euros", +100, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("Hacienda ha llamado, tienes que pagar por tus propiedades 100 euros", -100, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("Todos los jugadores tienen que pagarte 100 euros ! ", 100, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Ups, mala suerte, pagas 50 euros a todos los concursantes", -50, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Un fan anónimo ha pagado tu fianza. Sales de la cárcel", 0, TipoSorpresa.SALIRCARCEL));
        mazo.add(new Sorpresa("Te convierts en especulador amigo ",3000,TipoSorpresa.CONVERTIRME));
        mazo.add(new Sorpresa("Te convierts en especulador amigo ",5000,TipoSorpresa.CONVERTIRME));
        Collections.shuffle(mazo);

    }
//-------------------------------------------------------------------------------        

    private void inicializarJugadores(ArrayList<String> nombres) {

            for (String nombre : nombres) {
                jugadores.add(new Jugador(nombre));
            }
    }
//-------------------------------------------------------------------------------        

    private void inicializarTablero() {
        tablero = new Tablero();
    }
//-------------------------------------------------------------------------------        

    public ArrayList<Jugador> getJugadores() {
        return this.jugadores;
    }
//-------------------------------------------------------------------------------                

    private void salidaJugadores() {

        for (Jugador act : jugadores) {
            act.setCasillaActual(this.tablero.obtenerCasillaNumero(0));
        }
        Random ran = new Random();
        int i = ran.nextInt(jugadores.size());
        this.jugadorActual = jugadores.get(i);
    }

//-------------------------------------------------------------------------------       
    private Qytetet() {
        inicializarTablero();
//        System.out.println(tablero.toString());
        inicializarCartasSorpresa();
      
    }
    
    @Override
    public String toString() {
        
        String s = "MAZO\n";
        
        for (Sorpresa sorpresa : mazo) {
            s+=sorpresa.toString();
        }
      
        s+= "Tablero\n"+ tablero + "\n";
        
        return s;
                
        
    }
    
//-------------------------------------------------------------------------------        

    public static Qytetet getInstance() {
        return Qytetet.INSTANCE;
    }
//-------------------------------------------------------------------------------        

    //private static class QytetetHolder {

    //}

}
