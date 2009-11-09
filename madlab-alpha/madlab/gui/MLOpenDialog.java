package madlab.gui;
import java.awt.*;
import java.net.*;

/**
 * Class MLOpenDialog 
 * Created: Tue Nov  3 15:21:51 2009
 * GNU Emacs 22.3.1 (powerpc-apple-darwin8.11.0)
 *
 * @author James Lopez (bluegod@bluegod.net) 
 * @version 1.0
 */
public class MLOpenDialog {

  /**
   * Creates a new <code>MLOpenDialog</code> instance.
   * Opens a FileDialog if false, an URL if true.
   *
   */
  protected MLDialog mld;
  protected URL url;
  public MLOpenDialog() {
    FileDialog fd;
    MLDialog je=new MLDialog("Abrir desde URL?",MLDialog.SELECTTWO);
    try {
      if(je!=null && je.getAny()!=null){
	if(((Boolean) je.getAny()).booleanValue()){
	  mld= new MLDialog("Abrir desde URL", MLDialog.ASKSTRING);
	  url=new URL((String)mld.getAny());
	}
	else{
	  fd= new FileDialog(new Frame(),"Abrir fichero",FileDialog.LOAD);
	  fd.setVisible(true);
	  url=new URL("file://"+fd.getDirectory()+java.io.File.separator+fd.getFile());
	}
      }
    }catch (Exception e) {
      new MLDialog("Error abriendo fichero.",MLDialog.INFO);
    }

  }
  public URL gotURL(){
    return url;
  }
}
