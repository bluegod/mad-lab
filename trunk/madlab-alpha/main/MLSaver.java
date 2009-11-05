package madlab.main;
import java.io.*;
/**
 * Class MLSaver 
 * Created: Thu Nov  5 12:49:33 2009
 * GNU Emacs 22.3.1 (powerpc-apple-darwin8.11.0)
 *
 * @author James Lopez (bluegod@bluegod.net) 
 * @version 1.0
 */
public class MLSaver {

  /**
   * Creates a new <code>MLSaver</code> instance.
   *
   */
  protected String fname;
  protected ExpObject e;
  public MLSaver(ExpObject e, String file) {
    this.e=e;
    this.fname=file;
    saveExpObject();
  }
  protected void saveExpObject(){
    try {
    FileOutputStream f_out = new FileOutputStream(fname);
    ObjectOutputStream obj_out = new ObjectOutputStream (f_out);
    obj_out.writeObject(e);
    obj_out.flush();
    obj_out.close();
    f_out.close();
    }catch (IOException e) {
      new madlab.gui.MLDialog("Error escribiendo el fichero.",
			      madlab.gui.MLDialog.INFO);
      return;
    }
    new madlab.gui.MLDialog("Fichero "+fname+" escrito.",
			    madlab.gui.MLDialog.INFO);
  }
}
