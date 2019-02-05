/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazTextualQytetet;
import java.util.Scanner;
import java.util.ArrayList;
import modeloqytetet.*;

public class ControladorQytetet {
    private Qytetet juego;
    private Jugador jugador;
    private Casilla casilla;
    private VistaTextualQytetet vista;
    
    ControladorQytetet(){
     
        vista = new VistaTextualQytetet();
    }
  
 void desarrollarJuego(){
     boolean bancarrota = false;
     int metodo ;
     boolean libre = !jugador.isEncarcelado();
     boolean noTienePropietario;
     int opcion = -1;
     ArrayList<String> propiedades = new ArrayList();
     Casilla casillaJugador ;
     
   
     do {
        
        if(!libre){
            
            metodo = vista.menuSalirCarcel();
            if (metodo == 0){
                libre = juego.intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO);
            }
            else if (metodo == 1){
                libre = juego.intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD);
            }
        } 
        
        if (libre){
            
            noTienePropietario = juego.Jugar();
            bancarrota = !jugador.tengoSaldo(0);
            
            if (!bancarrota && !jugador.isEncarcelado()){
              
                if(jugador.getCasillaActual().getTipo()==TipoCasilla.SORPRESA){
                    noTienePropietario = juego.aplicarSorpresa();
                    if (!jugador.isEncarcelado() ){
                        bancarrota = !jugador.tengoSaldo(0);
                        if ( !bancarrota && jugador.getCasillaActual().getTipo()== TipoCasilla.CALLE){
                            if ( !((Calle)this.jugador.getCasillaActual()).tengoPropietario()){
                                if (vista.elegirQuieroComprar()){
                                    juego.comprarTituloPropiedad();
                                }
                            }
                        }
                    }
                }
                else if (jugador.getCasillaActual().getTipo()==TipoCasilla.CALLE){
                    if ( !((Calle)this.jugador.getCasillaActual()).tengoPropietario()){
                        if (vista.elegirQuieroComprar()){
                            juego.comprarTituloPropiedad();
                        }
                    }
                }
            
            bancarrota = !jugador.tengoSaldo(0);
            if ( !jugador.isEncarcelado() && !bancarrota && jugador.tengoPropiedades())
            {
                do{
                opcion = vista.menuGestionInmobiliaria();
                
                if (opcion == 5 ){
                    casillaJugador = this.elegirPropiedad(jugador.obtenerPropiedadesHipotecadas(true));
                    juego.cancelarHipoteca(casillaJugador);
                }
                else if (opcion !=0 ) {
                    casillaJugador = this.elegirPropiedad(jugador.obtenerPropiedadesHipotecadas(false));
                    if (opcion == 4){
                        juego.hipotecarPropiedad(casillaJugador);
                    }
                    else if (opcion == 3){
                        juego.venderPropiedad(casillaJugador);
                    }
                    else if (opcion == 2){
                        juego.edificarHotel(casillaJugador);
                    }
                    else if (opcion == 1){
                        juego.edificarCasa(casillaJugador);
                    }
                }
                }while(opcion==0 || !jugador.tengoPropiedades());
            }
            }
        }
        bancarrota = !jugador.tengoSaldo(0);
   
        if (!bancarrota){
             System.out.println("================\" + \"Jugador actual \" + \"================");
             System.out.println("================" + jugador.toString() + "================");
    

            jugador = juego.siguienteJugador();
        }
      
     }
     while(!bancarrota);
     
    juego.obtenerRanking();
 }   
 void inicializacionJuego(){
//     Scanner in = new Scanner(System.in);
     juego = Qytetet.getInstance();
     
     ArrayList<String> nombres = vista.obtenerNombreJugadores();
     
     juego.inicializarJuego(nombres);

     jugador = juego.getJugadorActual();
     casilla = juego.getJugadorActual().getCasillaActual();
  
     System.out.println(juego.toString());
     System.out.println("================\" + \"Jugador actual \" + \"================");
     System.out.println("================" + jugador.toString() + "================");
    
//     System.out.println("Pulse tecla para comenzar juego");
//     in.nextLine();
 }
  public Casilla elegirPropiedad(ArrayList<Casilla> propiedades){ 
 //este metodo toma una lista de propiedades y genera una lista de strings, con el numero y nombre de las propiedades
 //luego llama a la vista para que el usuario pueda elegir.
        vista.mostrar("\tCasilla\tTitulo");
        int seleccion;
        ArrayList<String> listaPropiedades= new ArrayList();
        for ( Casilla casilla: propiedades ) {
                listaPropiedades.add( "\t"+casilla.getNumeroCasilla()+"\t"+((Calle)casilla).getTitulo().getNombre() ) ; 
        }
        seleccion=vista.menuElegirPropiedad(listaPropiedades);  
        return propiedades.get(seleccion);
 }
  
 public static void main(String[] args){
   
     ControladorQytetet controlador = new ControladorQytetet();
     controlador.inicializacionJuego();
     controlador.desarrollarJuego();
     
 }
 
}