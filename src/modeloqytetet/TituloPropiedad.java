
package modeloqytetet;

/**
 *
 * @author anthonius
 */
public class TituloPropiedad {
    private String nombre;
    private boolean hipotecada=false;
    private int alquilerBase;
    private float factorRevalorizacion;
    private int hipotecaBase;
    private int precioEdificar;
    Jugador propietario;
    private Casilla micasilla;
//-------------------------------------------------------------------------------
    public TituloPropiedad(String nombre, int alquilerBase, float factorRevalorizacion, int hipotecaBase, int precioEdificar) {
        this.nombre = nombre;
        this.alquilerBase = alquilerBase;
        this.factorRevalorizacion = factorRevalorizacion;
        this.hipotecaBase = hipotecaBase;
        this.precioEdificar = precioEdificar;
        this.propietario = null;
        this.micasilla = null;
    }
//-------------------------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }
//-------------------------------------------------------------------------------    
    void cobrarAlquiler(int coste){
        this.propietario.modificarSaldo(coste);
    }
//-------------------------------------------------------------------------------    
    boolean isHipotecada() {
        return hipotecada;
    }
//-------------------------------------------------------------------------------   
    int getAlquilerBase() {
        return alquilerBase;
    }
//-------------------------------------------------------------------------------
    float getFactorRevalorizacion() {
        return factorRevalorizacion;
    }
//-------------------------------------------------------------------------------
    int getHipotecaBase() {
        return hipotecaBase;
    }
//-------------------------------------------------------------------------------
    int getPrecioEdificar() {
        return precioEdificar;
    }
//-------------------------------------------------------------------------------    
    void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
    }
//-------------------------------------------------------------------------------
    void setMicasilla(Casilla micasilla) {
        this.micasilla = micasilla;
       
    }
//-------------------------------------------------------------------------------    
    Casilla getCasilla(){
        return this.micasilla;
    }
//-------------------------------------------------------------------------------    
    void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }
//-------------------------------------------------------------------------------    
    boolean tengoPropietario(){
        boolean tengo = false ;
        if (this.propietario != null){
            tengo = true;
        }
        return tengo ;
    }
//-------------------------------------------------------------------------------    
    boolean propietarioEncarcelado(){
        boolean encarcelado = false;
        if (this.propietario.isEncarcelado()){
            encarcelado = true;
        }
        return encarcelado;
    }
 //-------------------------------------------------------------------------------   
    @Override
    public String toString() {
        return "TituloPropiedad{" + "nombre=" + nombre + ", hipotecada=" + hipotecada + ", alquilerBase=" + alquilerBase + ", factorRevalorizacion=" + factorRevalorizacion + ", hipotecaBase=" + hipotecaBase + ", precioEdificar=" + precioEdificar + '}';
    }
   
}
// crear metodo calcular valor
