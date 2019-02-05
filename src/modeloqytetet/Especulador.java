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
public class Especulador extends Jugador {
    static int FactorEspeculador = 2;
    private int fianza ;
    
    protected Especulador(Jugador jugador, int fianza){
        super(jugador);
        this.fianza = fianza;
    }
    protected Especulador convertirme(int cant){
        return this;
    }
    protected void pagarImpuesto(int cant){ 
       int apagar = (int)(cant/FactorEspeculador);
       this.modificarSaldo(-apagar);
    }
    protected void irACarcel(Casilla carcel){
        boolean voy = this.pagarFianza(fianza);
        if (!voy){
            this.setEncarcelado(true);
            this.setCasillaActual(carcel);
        }
    }
    private boolean pagarFianza(int cantidad){
        boolean tengo = false;
        if (this.tengoSaldo(cantidad)){
            tengo = true;
            this.modificarSaldo(-cantidad);
        }
        return tengo;
    }
}
