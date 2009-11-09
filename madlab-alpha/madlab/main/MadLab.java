package madlab.main;
import madlab.gui.*;
/**
 * Class MadLab 
 * Created: Thu Nov  5 10:49:09 2009
 * GNU Emacs 22.3.1 (powerpc-apple-darwin8.11.0)
 *
 * @author James Lopez (bluegod@bluegod.net) 
 * @version 1.0
 */
public class MadLab {
  /**
   * Creates a new <code>MadLab</code> instance.
   *
   */
  public MadLab() {

  }

  /**
   * Describe <code>main</code> method here.
   *
   * @param args a <code>String</code> value
   */
  public static final void main(final String[] args) {
    ExpObject first=new ExpObject();
    //creates a new GUI and send a default ExpObject
    new MainGUI(first);
  }
}
