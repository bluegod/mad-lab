package madlab.gui;

import java.awt.*;
import java.awt.event.*;
/**
 * Class MLDialog 
 * Created: Tue Nov  3 15:38:43 2009
 * GNU Emacs 22.3.1 (powerpc-apple-darwin8.11.0)
 *
 * @author James Lopez (bluegod@bluegod.net) 
 * @version 1.0
 */
public class MLDialog extends Dialog implements MLColors, ActionListener, WindowListener {

  protected Button b;
  protected TextField t;
  protected CheckboxGroup g;
  protected Checkbox si,no;
  protected int w;
  public static final int INFO=0;
  public static final int ASKSTRING=1;
  public static final int SELECTTWO=2;
  protected Object unk;
  /**
   * Creates a new <code>MLDialog</code> instance.
   *
   */
  public MLDialog(String s,int t) {
    super(new Frame(),s,true);
    this.w=t;
    //center on screen
    setLocationRelativeTo(null);
    b=new Button("OK");
    b.addActionListener(this);
    addWindowListener(this);
    setForeground(FGCOLOR2);
    setBackground(BGCOLOR);
    switch(t){
    case INFO:infoDialog(s); break;
    case ASKSTRING:askStringDialog(s); break;
    case SELECTTWO:selectTwoDialog(s); break;
    }
  }
  protected void infoDialog(String s){
    setLayout(new GridLayout(2,1));
    setResizable(false);
    add(new Label(s));
    add(b);
    pack();
    setVisible(true);
    b.addActionListener(this);
    addWindowListener(this);
  }
  protected void askStringDialog(String s){
    setLayout(new GridLayout(2,1));
    setResizable(false);
    add(t=new TextField(20));
    add(b);
    pack();
    setVisible(true);
    b.addActionListener(this);
    addWindowListener(this);
  }
  protected void selectTwoDialog(String s){
    setLayout(new GridLayout(3,1));
    setResizable(false);
    Panel p=new Panel();
    g=new CheckboxGroup(); 
    add(new Label(s));
    p.add(si=new Checkbox("si",g,true));
    p.add(no=new Checkbox("no",g,false));
    add(p);
    add(b);
    pack();
    setVisible(true);

  }
  public Dimension getPreferredSize(){
    return new Dimension(300,100);
  }
  public Object getAny(){
    return unk;
  }
  public final void actionPerformed(final ActionEvent e) {
    if(e.getSource()==b){
      if (w==2) {
	if( g.getSelectedCheckbox()==si)
	  unk=new Boolean(true);
	else
	  unk=new Boolean(false);
      }
      else if(w==1){
	unk=new String(t.getText());
      }

      this.setVisible(false);
      this.dispose();
    }
  }
  public final void windowActivated(final WindowEvent e) {
  }
  public final void windowClosed(final WindowEvent e) {
  }
  public final void windowClosing(final WindowEvent e) {

    this.setVisible(false);
    this.dispose();
  }
  public final void windowDeactivated(final WindowEvent e) {
  }
  public final void windowDeiconified(final WindowEvent e) {
  }
  public final void windowIconified(final WindowEvent e) {
  }
  public final void windowOpened(final WindowEvent e) {
  }
  public final void itemStateChanged(ItemEvent e) {

  }
}
