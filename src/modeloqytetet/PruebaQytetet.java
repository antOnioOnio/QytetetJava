
package modeloqytetet;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author anthonius
 */
public class PruebaQytetet {
    

    /*private static ArrayList<Sorpresa> Sorpresasmayor0(){
        
        ArrayList<Sorpresa> nmazo = new ArrayList();
        
        for (Sorpresa s : mazo){
            if (s.getValor() > 0){
                nmazo.add(s);
            }
        }
        return nmazo;
    }
    private static ArrayList<Sorpresa> SorpresaIraCasilla(){
        
        ArrayList<Sorpresa> nmazo = new ArrayList();
        
        for (Sorpresa s : mazo){
            if (s.getTipo()==TipoSorpresa.IRACASILLA){
                nmazo.add(s);
            }
        }
        return nmazo;
    }
    
    private static ArrayList<Sorpresa> SorpresaEspecificado( TipoSorpresa Tip ){
        
       ArrayList<Sorpresa> nmazo = new ArrayList();
       
        for (Sorpresa s : mazo){
            if (s.getTipo()==Tip){
                nmazo.add(s);
            }
        }
        return nmazo;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
   Qytetet juego;
   Jugador jugador;
   Casilla casilla;
   
     juego = Qytetet.getInstance();
     
     ArrayList<String> nombres = new ArrayList();
     String j1 = " paco";
     String j2 = " jose " ;
     nombres.add(j2);
     nombres.add(j1);
     juego.inicializarJuego(nombres);

     jugador = juego.getJugadorActual();
     casilla = juego.getJugadorActual().getCasillaActual();
  
     //System.out.println(juego.toString());
     System.out.println("================\" + \"Jugador actual \" + \"================");
     System.out.println(jugador.toString());
   
     jugador = juego.getJugadorActual().convertirme(100);
     
     System.out.println(jugador.toString());
   
   
   
    }
    
}
