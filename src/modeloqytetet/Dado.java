
package modeloqytetet;

/**
 *
 * @author anthonius
 */
import java.util.Random;
public class Dado {
    
   
    
    private Dado() {
    }
    
    public static Dado getInstance() {
        return DadoHolder.INSTANCE;
    }
    
    private static class DadoHolder {

        private static final Dado INSTANCE = new Dado();
    }
    int tirar() {
     Random ran = new Random();
     
     return ran.nextInt(6)+1;
       
   } 
}
