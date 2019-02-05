
package modeloqytetet;

import java.util.ArrayList;

/**
 *
 * @author anthonius
 */
public class Tablero {
    
   private ArrayList<Casilla> casillas ;
   private Casilla carcel;
//-------------------------------------------------------------------------------
    Tablero() {    
       this.Inicializar();
    }
//-------------------------------------------------------------------------------
    Casilla getCarcel() {
        return carcel;
    }
//-------------------------------------------------------------------------------    
    boolean esCasillaCarcel(int numCasilla){
         boolean es = false;
         
         if (((OtraCasilla)casillas.get(numCasilla)).getTipo() == TipoCasilla.CARCEL) {
             es = true;
         }
         return es;
    }
//-------------------------------------------------------------------------------    
    Casilla obtenerCasillaNumero(int numeroCasilla  ){
        
        return casillas.get(numeroCasilla);
    }
//-------------------------------------------------------------------------------    
    Casilla obtenerNuevaCasilla(Casilla casilla,int  desplazamiento) {
        
        return casillas.get((casilla.getNumeroCasilla()+desplazamiento)%19 ) ; 
    }
//-------------------------------------------------------------------------------    
     private void Inicializar()
    {
        casillas = new ArrayList(Qytetet.MAX_CASILLAS);
        
        casillas.add(new OtraCasilla(0,0,TipoCasilla.SALIDA));
        casillas.add(new OtraCasilla(1,0,TipoCasilla.SORPRESA));
        // BARRIO DE CLASE MEDIA
        casillas.add(new Calle(2,450,new TituloPropiedad("Calle del camarero",65,20,200,300)));
        casillas.add(new Calle(3,450,new TituloPropiedad("Avenida del obrero",65,20,200,300)));
        casillas.add(new Calle(4,450,new TituloPropiedad("Calle del electricista",65,20,200,300)));
        casillas.add(new OtraCasilla(5,0,TipoCasilla.PARKING));
        //BARRIO POBRE
        casillas.add(new Calle(6,375,new TituloPropiedad("Calle del pordiosero",50,10,150,250)));
        casillas.add(new Calle(7,375,new TituloPropiedad("Camino del ladron",50,10,150,250)));
        casillas.add(new OtraCasilla(8,0,TipoCasilla.CARCEL));
        carcel = casillas.get(8);
        casillas.add(new Calle(9,375,new TituloPropiedad("Calle del expresidiario",50,10,150,250)));
        //Barrio de clase alta
        casillas.add(new Calle(10,600,new TituloPropiedad("Avenida del presidente",75,12,400,500)));
        casillas.add(new Calle(11,600,new TituloPropiedad("Camino del doctor Ochoa",75,12,400,500)));
        casillas.add(new OtraCasilla(12,0,TipoCasilla.IMPUESTO));
        casillas.add(new Calle(13,600,new TituloPropiedad("Calle del duque",75,12,400,500)));
        casillas.add(new OtraCasilla(14,0,TipoCasilla.SORPRESA));
        //Barrio ricos
        casillas.add(new Calle(15,650,new TituloPropiedad("Via del Rey",100,10,700,750)));
        casillas.add(new OtraCasilla(16,0,TipoCasilla.JUEZ));
        casillas.add(new Calle(17,650,new TituloPropiedad("Avenida de los condeses",100,10,700,750)));
        casillas.add(new OtraCasilla(18,0,TipoCasilla.SORPRESA));
        casillas.add(new Calle(19,650,new TituloPropiedad("Calle de Don Roquefeller",100,10,700,750)));
        
        
    }
 //-------------------------------------------------------------------------------    
    @Override
    public String toString() {
        String variable= "" ;
        
        for (Casilla casilla : casillas) {
            
            variable += casilla.toString();
            
            
        }
      
      return variable;
       
    }
   
    
}
