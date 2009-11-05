package madlab.gui;

import java.awt.*;
import java.awt.image.*;
/**
 * Class MLOval 
 * Created: Mon Nov  2 12:52:07 2009
 * GNU Emacs 22.3.1 (powerpc-apple-darwin8.11.0)
 *
 * @author James Lopez (bluegod@bluegod.net) 
 * @version 1.0
 */
public class MLOval extends Component implements MLColors{

  /**
   * Creates a new <code>MLOval</code> instance.
   *
   */
  protected Graphics g;
  protected BufferedImage bim;
  protected String name;
  protected boolean blinking;
  public MLOval(String name) {
    this.name=name;
    bim= new BufferedImage(120,100,BufferedImage.TYPE_INT_RGB);
    paint(g);
  }
  @Override public void paint(Graphics g){
    g=bim.getGraphics();
    g.setColor(BGCOLOR2);
    g.fillRect(0,0,120,100);
    g.setColor(blinking?BGCOLOR2:new Color(60,69,41));
    g.fillOval(5,5,105,70);
    g.setColor(Color.YELLOW);
    g.setFont(new Font("Helvetica",Font.BOLD,13));
    g.drawString(name, 45-(name.length()*2), 45);
  }
  protected void blink(){
    blinking=!blinking;
    update(g);
  }
  @Override public void update(Graphics g){
    paint(g);
  }
  protected BufferedImage getImage(){
    return bim;
  }
}
