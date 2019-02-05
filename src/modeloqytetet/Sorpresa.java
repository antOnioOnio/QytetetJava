
package modeloqytetet;

/**
 *
 * @author anthonius
 */
public class Sorpresa {
   private String texto ;
   private TipoSorpresa tipo;
   private int valor;
    

   Sorpresa(String text, int val, TipoSorpresa tip){
       this.texto = text;
       this.valor = val;
       this.tipo = tip;
   }

    String getTexto() {
        return texto;
    }

    TipoSorpresa getTipo() {
        return tipo;
    }

    int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        String s = "Sorpresa{"+ "Texto: " + texto+ ", tipo=" + tipo + ", valor=" + valor + '}';
       
        s += '\n';
        return s;
    }
   
   
}