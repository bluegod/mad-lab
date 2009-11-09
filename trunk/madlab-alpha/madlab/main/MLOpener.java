package madlab.main;
import java.net.*;
import java.io.*;
/**
 * Class MLOpener 
 * Created: Thu Nov  5 13:20:10 2009
 * GNU Emacs 22.3.1 (powerpc-apple-darwin8.11.0)
 *
 * @author James Lopez (bluegod@bluegod.net) 
 * @version 1.0
 */
public class MLOpener {

  /**
   * Creates a new <code>MLOpener</code> instance.
   *
   */
  protected URL url;
  public MLOpener(URL url) {
    this.url=url;
  }
  public ExpObject getExpObject(){
    ExpObject e=null;
    try {
    ObjectInputStream obj_in = new ObjectInputStream (url.openStream());
    e=(ExpObject)obj_in.readObject();
    }catch (Exception io) {
      new madlab.gui.MLDialog("Error leyendo el fichero.",
			      madlab.gui.MLDialog.INFO);
    }

    return e;
  }

}
