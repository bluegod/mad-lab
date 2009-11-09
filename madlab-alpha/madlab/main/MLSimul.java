package madlab.main;
import java.util.*;
/**
 * Class MLSimul 
 * Created: Thu Nov  5 17:07:48 2009
 * GNU Emacs 22.3.1 (powerpc-apple-darwin8.11.0)
 *
 * @author James Lopez (bluegod@bluegod.net) 
 * @version 1.0
 */
public class MLSimul {
  protected double [] DATA;
  protected static final int MAX_GENS=30;
  /* TODO: Se deberian dar las opciones en el panel
   * por ej. la cantidad de numeros a generar.
   */
  public MLSimul(ExpObject e) {
    randomGenerator(e);
  }
  
  /**
   * Describe <code>randomGenerator</code> method here.
   *
   * @param eo an <code>ExpObject</code> value
   * Genera hasta MAX_GENS valores aleatorios entre el
   * intervalo abierto:
   * (media-desviaciones , media+desviaciones)
   */
  protected void randomGenerator(ExpObject eo){
    DATA=new double[MAX_GENS];
    Random rnd=new Random();
    Iterator ivalor = eo.getValores().iterator();
    Iterator isign = eo.getSigns().iterator();
    int howmany=0;
    double media=0;
    double desvs=0;
    while (ivalor.hasNext() && isign.hasNext()) {
      if(howmany==0)
	media=(Double.parseDouble((String)ivalor.next())*0.01*((Integer)isign.next()).intValue());
      else
	desvs+=(Double.parseDouble((String)ivalor.next())*0.01*((Integer)isign.next()).intValue());
      howmany++;
    }    
    //nota: esta bounded, es decir es un conjunto abierto

    //Primeros datos del Array maximo e infimo:
    DATA[0]=(media+desvs);
    DATA[1]=(media-desvs);
    for (int i=2;i<MAX_GENS;i++) {
      double r=rnd.nextDouble();
      DATA[i]=((r*(media+desvs))+((1-r)*(media-desvs)));
    }
  }
  public double[] getDATA(){
    return DATA;
  }
}
