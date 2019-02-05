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
public class OtraCasilla extends Casilla{
   private TipoCasilla tipo;
   
   OtraCasilla(int numCasilla, int coste, TipoCasilla tip){
       super(numCasilla, coste);
       tipo = tip;
   }
   //-------------------------------------------------------------------------------
    public TipoCasilla getTipo() {
        return tipo;
    }
    //-------------------------------------------------------------------------------    
    boolean soyEdificable(){
      return false;
    }

    @Override
    public String toString() {
        String s = super.toString() + "OtraCasilla{" + "tipo=" + tipo + '}';
   
        return s;
    }
    
}
