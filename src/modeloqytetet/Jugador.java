/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;

/**
 *
 * @author anthonius
 */
public class Jugador {
    
    static int FactorEspeculador = 1 ;
    private boolean encarcelado = false ;
    private String nombre ;
    private int saldo = 7500 ;
    private ArrayList<TituloPropiedad> propiedades  = new ArrayList();
    private Sorpresa cartaLibertad = null;
    private Casilla casillaActual = null;
    
 
    Jugador(String nombre){
        this.nombre = nombre;
    }
    protected Jugador ( Jugador jugador){
       this.encarcelado = jugador.isEncarcelado();
       this.nombre = jugador.getNombre();
       this.saldo = jugador.saldo;
       this.propiedades = new ArrayList(jugador.propiedades);
       this.cartaLibertad = jugador.cartaLibertad;
       this.casillaActual = jugador.casillaActual;
    }
    protected void pagarImpuesto(int cant){ 
       int apagar = (int)(cant/FactorEspeculador);
       this.modificarSaldo(apagar);
    }
    
    protected Especulador convertirme(int cant){
        Especulador aux = new Especulador(this,cant);
        return aux;
    }
    
    public String getNombre(){
        return nombre;
    }
//-------------------------------------------------------------------------------  
    public boolean isEncarcelado() {
        return encarcelado;
    }
//-------------------------------------------------------------------------------
    public Casilla getCasillaActual() {
        return casillaActual;
    }
//-------------------------------------------------------------------------------   
    public boolean tengoPropiedades(){
       boolean tengo = false;
       if ( !this.propiedades.isEmpty()){
           tengo = true;
       }
       return tengo;
    }
//-------------------------------------------------------------------------------    
    protected boolean actualizarPosicion(Casilla casilla) {
          
       if  ( casilla.getNumeroCasilla() < this.casillaActual.getNumeroCasilla())
       {
          this.modificarSaldo(Qytetet.SALDO_SALIDA);
       }
       
       this.setCasillaActual(casilla);
       
       boolean tengoPropietario = false;
      
       if (casilla.soyEdificable())
       {
            tengoPropietario = ((Calle)this.casillaActual).tengoPropietario();
            
           
           if (tengoPropietario){
               
               boolean encarcelado = ((Calle)this.casillaActual).propietarioEncarcelado();
               
               if (!encarcelado){
                   
                   modificarSaldo(-((Calle)this.casillaActual).cobrarAlquiler());
               }
           }
       }
       else if ( ((OtraCasilla)casilla).getTipo() == TipoCasilla.IMPUESTO){
           int coste = ((OtraCasilla)this.casillaActual).getCoste();
           this.pagarImpuesto(coste);
            
       }
       
       return tengoPropietario;
     }
 //-------------------------------------------------------------------------------   
    boolean comprarTitulo(){
       boolean puedoComprar = false;
       TituloPropiedad titulo;
       
       if ( this.casillaActual.soyEdificable()){
           if (!((Calle)this.casillaActual).tengoPropietario()){
               if ( this.casillaActual.getCoste() <= this.saldo){
                   titulo = ((Calle)this.casillaActual).asignarPropietario(this);
                   puedoComprar = true;
                   this.propiedades.add(titulo);
                   this.modificarSaldo(-this.casillaActual.getCoste());
               }
           }
       }
       return puedoComprar;
    }
//-------------------------------------------------------------------------------   
    Sorpresa devolverCartaLibertad(){
       Sorpresa aux = this.cartaLibertad ;
       this.cartaLibertad = null;
       return aux;
    }
//-------------------------------------------------------------------------------    
    void irACarcel(Casilla carcel){
       setCasillaActual(carcel);
       setEncarcelado(true);
       
    }
//-------------------------------------------------------------------------------    
    void modificarSaldo(int cantidad ){
       this.saldo = this.saldo + cantidad;
    } 
//-------------------------------------------------------------------------------    
    int obtenerCapital() { 
        int capital = this.saldo;

        for (TituloPropiedad propiedade : propiedades) 
        {
            int valor_propiedad = 0;
            int numero_casas_hoteles = 0;
            
                numero_casas_hoteles = ((Calle)propiedade.getCasilla()).getNumCasas() + ((Calle)propiedade.getCasilla()).getNumHoteles();
                    
            if (!((Calle)propiedade.getCasilla()).estaHipotecada()){
                
                valor_propiedad = ((Calle)propiedade.getCasilla()).getCoste()+ numero_casas_hoteles * ((Calle)propiedade.getCasilla()).getPrecioEdificar() ;
                capital +=valor_propiedad;
            }
            else {
                capital = capital - propiedade.getHipotecaBase();
            }
            
        }
      
      return capital;
    }
//-------------------------------------------------------------------------------    
    public ArrayList<Casilla> obtenerPropiedadesHipotecadas(boolean hipotecada  ) {
      ArrayList<Casilla> aux= new ArrayList();
        if (hipotecada){
            for (TituloPropiedad propiedade : propiedades) {
                if( ((Calle)propiedade.getCasilla()).estaHipotecada()){
                    aux.add(propiedade.getCasilla());
                }
            }
        }
        else {
             for (TituloPropiedad propiedade : propiedades) {
                if(!((Calle)propiedade.getCasilla()).estaHipotecada()){
                    aux.add(propiedade.getCasilla());
                }
            }
        }
      return aux;
    }
//-------------------------------------------------------------------------------
   public ArrayList<String> obtenerNombrePropiedades(){
       ArrayList<String> pro = new ArrayList();
       
       for (TituloPropiedad propiedade : propiedades) {
              pro.add(propiedade.getNombre());
            }
       return pro;
   }
//-------------------------------------------------------------------------------    
    void pagarCobrarPorCasaYHotel(int cantidad){
        
       int numeroTotal = this.cuantasCasasHotelesTengo();
       this.modificarSaldo(numeroTotal*cantidad);
               
    }
//-------------------------------------------------------------------------------    
    boolean pagarLibertad(int  PrecioLibertad) {
      boolean tengoSaldo=false;

      if (this.tengoSaldo(PrecioLibertad)){
          tengoSaldo=true;
          this.modificarSaldo(PrecioLibertad);
      }
      
      return tengoSaldo;
    }
//-------------------------------------------------------------------------------    
    boolean puedoEdificarCasa(Casilla casilla) {
        
      boolean puedo = false;
      boolean esMia = this.esDeMipropiedad(casilla);
      int costeEdificarCasa = ((Calle)casilla).getPrecioEdificar();
      boolean tengoSaldo = this.tengoSaldo(costeEdificarCasa);
      
      if ( esMia && tengoSaldo){
          puedo = true;
      }
      return puedo;
    }
//-------------------------------------------------------------------------------   
    boolean puedoEdificarHotel(Casilla casilla) {
      boolean puedo = false;
      boolean esMia = this.esDeMipropiedad(casilla);
      int costeEdificarHotel = ((Calle)casilla).getPrecioEdificar();
      boolean tengoSaldo = this.tengoSaldo(costeEdificarHotel);
      
      if ( esMia && tengoSaldo){
          puedo = true;
      }
      return puedo;
    }
//-------------------------------------------------------------------------------    
    boolean puedoHipotecar(Casilla casilla) {
      boolean puedo = false ;
      
      if (this.esDeMipropiedad(casilla)){
          puedo = true;
      }
      
      return puedo;
    }
//-------------------------------------------------------------------------------    
    boolean puedoPagarHipotecar(Casilla casilla) {
      boolean puedoPagarHipotecar = false;
      int dinero;
      if (this.puedoHipotecar(casilla)){
          dinero = ((Calle)this.casillaActual).getCosteHipoteca();
          if (this.saldo > dinero){
              ((Calle)this.casillaActual).cancelarHipoteca();
              puedoPagarHipotecar = true;
              this.modificarSaldo(-dinero);
          }
      }
      return puedoPagarHipotecar;
    }
//-------------------------------------------------------------------------------    
    boolean puedovenderPropiedad(Casilla casilla) {
        boolean puedo = false;
      if (this.esDeMipropiedad(casilla) && !((Calle)casilla).estaHipotecada()){
          puedo = true;
      }
      return puedo;
    }
//-------------------------------------------------------------------------------    

    void setEncarcelado(boolean encarcelado) {
        this.encarcelado = encarcelado;
    }
//-------------------------------------------------------------------------------
    void setCartaLibertad(Sorpresa cartaLibertad) {
        this.cartaLibertad = cartaLibertad;
    }
//-------------------------------------------------------------------------------
    void setCasillaActual(Casilla casillaActual) {
        this.casillaActual = casillaActual;
    }
//-------------------------------------------------------------------------------    
    boolean  tengoCartaLibertad(){
        boolean tengo = false;
        if ( this.cartaLibertad != null){
            tengo = true;
        }
       return tengo;
    }
//-------------------------------------------------------------------------------    
    void venderPropiedad(Casilla casilla)  {
        int precioVenta = ((Calle)casilla).venderTitulo();
        this.modificarSaldo(precioVenta);
        eliminarDeMisPropiedades(casilla);
    }
//-------------------------------------------------------------------------------    
    int cuantasCasasHotelesTengo() {
        int numTotal = 0;
        for (TituloPropiedad propiedade : propiedades) {
            numTotal += ((Calle)propiedade.getCasilla()).getNumCasas();
            numTotal += ((Calle)propiedade.getCasilla()).getNumHoteles();
        }
        return numTotal;
    } 
//-------------------------------------------------------------------------------    
    void eliminarDeMisPropiedades(Casilla casilla) {
        
        if (this.esDeMipropiedad(casilla)){
           this.propiedades.remove(((Calle)casilla).getTitulo());
        }
        ((Calle)casilla).asignarPropietario(null);
        
    } 
//-------------------------------------------------------------------------------    
    boolean esDeMipropiedad(Casilla casilla){
       boolean es = false;
        for (TituloPropiedad propiedade : propiedades) {
            if (propiedade.getCasilla() == casilla){
                es = true;
            }
        }
        return es;
    }
//-------------------------------------------------------------------------------    
    public boolean tengoSaldo(int cantidad ){
        boolean tengo = false;
        if (this.saldo > cantidad){
            tengo = true;
        }
        return tengo;
    }
//-------------------------------------------------------------------------------
    @Override
    public String toString() {
        return  this.getClass().getSimpleName() + ": " + "nombre=" + nombre + ", saldo=" + saldo + ", casillaActual= " + casillaActual.getNumeroCasilla() + ", Encarcelado " + encarcelado ;
    }
 
}
