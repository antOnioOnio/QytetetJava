/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author anthonius
 */
public class Calle extends Casilla{
    private int numHoteles;
    private int numCasas;
    private TituloPropiedad titulo;
    
    Calle(int numCasilla, int coste, TituloPropiedad ti ){
        super(numCasilla,coste);
        numHoteles = 0;
        numCasas = 0 ;
        //titulo = ti;
        this.asignarTituloPropiedad(ti);
        
    }
    //-------------------------------------------------------------------------------
    void setNumHoteles(int numHoteles) 
    {
        this.numHoteles = numHoteles;
    }
    //-------------------------------------------------------------------------------
    void setNumCasas(int numCasas)
    {
        this.numCasas = numCasas;
    }
    //-------------------------------------------------------------------------------
    private void setTitulo(TituloPropiedad titulo) 
    {
        this.titulo = titulo;
    }
    //-------------------------------------------------------------------------------
    int getNumHoteles() {
        return numHoteles;
    }
//-------------------------------------------------------------------------------
    int getNumCasas() {
        return numCasas;
    }
    //-------------------------------------------------------------------------------
    public TituloPropiedad getTitulo() {
        return titulo;
    }
    //-------------------------------------------------------------------------------   
    TituloPropiedad asignarPropietario(Jugador jugador){
        this.titulo.setPropietario(jugador);
        return this.titulo;

    }
     //-------------------------------------------------------------------------------   
    int calcularValorHipoteca(){
        int valor = 0;
        int hBase = this.titulo.getHipotecaBase();
        
        valor = hBase + (int)(this.numCasas*0.5*hBase+this.numHoteles*hBase );
         
        return valor;
    }
 //-------------------------------------------------------------------------------
    void  cancelarHipoteca(){
        
        this.titulo.setHipotecada(false);
        
    }
     //-------------------------------------------------------------------------------
    int cobrarAlquiler(){
       int costeAlquilerBase = this.titulo.getAlquilerBase();
       
       int costeAlquiler = costeAlquilerBase + (int)(this.getNumCasas()*0.5 +this.getNumHoteles()*2);
       
       
       this.titulo.cobrarAlquiler(costeAlquiler);
       
       return costeAlquiler;
     
    }
//-------------------------------------------------------------------------------      
    int edificarCasa(){
        this.setNumCasas(numCasas+1);
        int costeEdificarCasa = this.titulo.getPrecioEdificar();
        return costeEdificarCasa;
    }
 //-------------------------------------------------------------------------------
    int edificarHotel(){
        this.setNumHoteles(numHoteles+1);
        this.setNumCasas(numCasas-4);
        int costeEdificarHotel = this.titulo.getPrecioEdificar();
        return costeEdificarHotel;
    }
//-------------------------------------------------------------------------------    
    boolean estaHipotecada(){
        boolean esta = false;
        if ( this.titulo.isHipotecada()== true){
            esta = true;
        }
        return esta;
    }
//-------------------------------------------------------------------------------   
    int getCosteHipoteca(){
        return this.calcularValorHipoteca();
    }
    //-------------------------------------------------------------------------------    
     int getPrecioEdificar(){
        return this.titulo.getPrecioEdificar();
    }
//-------------------------------------------------------------------------------    
    int hipotecar(){
        
        this.titulo.setHipotecada(true);
        int cantidadRecibida = this.calcularValorHipoteca();
        
        return cantidadRecibida;
        
    }
//-------------------------------------------------------------------------------    
    int precioTotalComprar(){
       int precio = 0;
       precio = this.getCoste() + (this.numCasas + this.numHoteles)*this.titulo.getPrecioEdificar();
       return precio;
    }
    //-------------------------------------------------------------------------------    
    boolean propietarioEncarcelado(){

        return this.titulo.propietario.isEncarcelado();
    }
//-------------------------------------------------------------------------------    
    boolean sePuedeEdificarHotel(){
        boolean sepuede = false;
        
        if ( this.titulo.propietario.getClass() == modeloqytetet.Especulador.class){
           if((this.numCasas == 4 ) && this.numHoteles < 2){
               sepuede = true;
           }
        }
        else if (this.numCasas==4 && this.numHoteles == 0){
            sepuede = true;
        }
         return sepuede;
    }
//-------------------------------------------------------------------------------   
    boolean sePuedeEdificarCasa(){
        boolean sepuede = false;
        
        if ( this.titulo.propietario.getClass() == modeloqytetet.Especulador.class){
           if(this.numCasas < 8){
               sepuede = true;
           }
        }
        else if (this.numCasas < 4){
            sepuede = true;
        }
         return sepuede;
    }
    //-------------------------------------------------------------------------------    
    public boolean tengoPropietario(){
        boolean tengo = false;
        if (this.titulo.propietario != null){
            tengo = true;
        }          
        return tengo;     
    }
//--------------------------------------------------------------subio-----------------    
    int venderTitulo(){
       
        int precioCompra =(int)( this.getCoste() +(this.numCasas+ this.numHoteles) * this.titulo.getPrecioEdificar());
        int precioVenta = (int)(precioCompra + this.titulo.getFactorRevalorizacion()*precioCompra);
        
        
        this.titulo.setPropietario(null);
        this.setNumCasas(0);
        this.setNumHoteles(0);
       
       return precioVenta;
    }
//-------------------------------------------------------------------------------   
    private void asignarTituloPropiedad(TituloPropiedad titulo){
        this.setTitulo(titulo);
        this.titulo.setMicasilla(this);
    }
//-------------------------------------------------------------------------------    
    boolean soyEdificable(){   
        return true;
    }
    public TipoCasilla getTipo() {
        return TipoCasilla.CALLE;
    }

    @Override
    public String toString() {
        String s = super.toString() + "Calle{" + "numHoteles=" + numHoteles + ", numCasas=" + numCasas + ", titulo=" + titulo + '}';
        return s;
    }
      

    
}
