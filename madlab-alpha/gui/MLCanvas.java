package madlab.gui;
import java.awt.event.*;
import java.awt.*;

/**
 * Class MLCanvas 
 * Created: Mon Nov  2 12:28:13 2009
 * GNU Emacs 22.3.1 (powerpc-apple-darwin8.11.0)
 *
 * @author James Lopez (bluegod@bluegod.net) 
 * @version 1.0
 */
public class MLCanvas extends Canvas implements MouseListener, MLColors, Runnable {
  final static int numOvals=4;
  protected final MLOval [] ov;
  protected final String [] strOval={"Nuevo","Abrir","Guardar","Simular"};;
  protected int selected;
  protected MainGUI mg;
  /**
   * Creates a new <code>MLCanvas</code> instance.
   *
   */
  public MLCanvas(MainGUI mg) {
    this.mg=mg;
    ov= new MLOval[numOvals];
    setBackground(BGCOLOR2);
    for (int i=0;i<ov.length;i++)
      ov[i]=new MLOval(strOval[i]);
    addMouseListener(this);
  }
  @Override public Dimension getPreferredSize(){
    return new Dimension(640, 100);
  }
  public void paint(Graphics g){
    for (int i=0,j=0;i<ov.length;i++,j+=120)
      g.drawImage(ov[i].getImage(),j,10,null);
  }
  /**
   * <code>greaterButLess</code>
   * Returns true if num is between l & g.
   *
   * @param num an <code>int</code> value
   * @param l an <code>int</code> value
   * @param g an <code>int</code> value
   * @return a <code>boolean</code> value
   */
  public boolean greaterButLess(int num, int l, int g){
    return (num>l && num<g)?true:false;
  }
  public final void mouseClicked(final MouseEvent e) {
    int ex=e.getX(),ey=e.getY();
    if(greaterButLess(ex,5,110) && greaterButLess(ey,5,70))
      menu(1);
    else if(greaterButLess(ex,120,220) && greaterButLess(ey,5,70))
      menu(2);
    else if(greaterButLess(ex,230,330) && greaterButLess(ey,5,70))
      menu(3);
    else if(greaterButLess(ex,340,440) && greaterButLess(ey,5,70))
      menu(4);
  }
  public void menu(int sw){
    selected=sw-1;
    Thread th= new Thread(this);
    th.start();
    switch(sw){
    case 1:mg.newOne(true);break;
    case 2:mg.openOne();break;
    case 3:mg.saveOne();break;
    case 4:mg.simulateOne();break;
    }
  }
  @Override public void update(Graphics g){
    paint(g);
  }
  public void run(){
    try{
      ov[selected].blink();
      repaint();
      Thread.sleep(500);
      ov[selected].blink();
      repaint();
    }catch(InterruptedException e){
    }
  }
  //TODO: It would be nice if a TIP is displayed when mouseEntered.
  public final void mouseEntered(final MouseEvent e) {
  }
  public final void mouseExited(final MouseEvent e) {
  }
  public final void mousePressed(final MouseEvent e) {
  }
  public final void mouseReleased(final MouseEvent e) {
  }
}
