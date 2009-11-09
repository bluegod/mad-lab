package madlab.gui;
import java.awt.event.*;
import java.awt.*;

/**
 * Class SimulPanel 
 * Created: Thu Nov  5 18:00:43 2009
 * GNU Emacs 22.3.1 (powerpc-apple-darwin8.11.0)
 *
 * @author James Lopez (bluegod@bluegod.net) 
 * @version 1.0
 */
public class SimulPanel extends ScrollPane implements ActionListener, MLColors{
  protected double[] DATA;
  protected MainGUI mg;
  protected Panel fpan;
  public SimulPanel(MainGUI mg, double[] DATA){
    this.DATA=DATA;
    this.mg=mg;
    Panel datapan=new Panel();
    datapan.setLayout(new GridLayout(DATA.length,1)); 
    fpan=new Panel();
    fpan.setLayout(new BorderLayout());
    fpan.setBackground(BGCOLOR);
    datapan.setBackground(BGCOLOR2);
    datapan.setForeground(FGCOLOR);
    datapan.add(new Label("Valor maximo: "+DATA[0]+"\nValor minimo: "+DATA[1]+""));
    for(int i=2;i<DATA.length;i++)
      datapan.add(new Label(""+DATA[i]));
    fpan.add(datapan);
    add(fpan,BorderLayout.CENTER);
    datapan.setVisible(true);
    fpan.setVisible(true);
    setVisible(true);
    datapan.setSize(400,480);
    this.setSize(640,480);
    this.doLayout();
  }
  public final void actionPerformed(final ActionEvent e) {
  }
}
