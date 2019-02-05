
package modeloqytetet;

/**
 *
 * @author anthonius
 */
public abstract class Casilla {
    
    private int numeroCasilla;
    private int coste;
    
    
   
    
//-------------------------------------------------------------------------------
    Casilla(int numeroCasilla,int coste) 
    { // no tienen titulo de propiedad
        this.numeroCasilla = numeroCasilla;
        this.coste=coste;
    
    }

//-------------------------------------------------------------------------------
    public int getNumeroCasilla() {
        return numeroCasilla;
    }
//-------------------------------------------------------------------------------
    int getCoste() {
        return coste;
    }

//-------------------------------------------------------------------------------    
    abstract boolean soyEdificable();
    abstract public TipoCasilla getTipo();
    
//-------------------------------------------------------------------------------   
    @Override
    public String toString() 
    {
         String s = "Casilla{" + "numeroCasilla=" + numeroCasilla + ", coste=" + coste + '}';
           
            return s; 
    }

   
        
 }
    
    
    
    
    
    

