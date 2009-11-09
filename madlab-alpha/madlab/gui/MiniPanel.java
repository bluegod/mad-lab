package madlab.gui;
import java.awt.*;
import java.awt.event.*;
/**
 * Class MiniPanel 
 * Created: Tue Nov  3 23:53:06 2009
 * GNU Emacs 22.3.1 (powerpc-apple-darwin8.11.0)
 *
 * @author James Lopez (bluegod@bluegod.net) 
 * @version 1.0
 */
public class MiniPanel extends Panel implements AdjustmentListener{
  protected static CheckboxGroup g=new CheckboxGroup();
  protected Checkbox c;
  protected TextField prop,form;
  protected Scrollbar sign;
  protected Label signl;
  protected GridBagConstraints cons;
  protected boolean isRemovable;
  /**
   * Creates a new <code>MiniPanel</code> instance.
   *
   */
  public MiniPanel(String props,String forms, int signi,boolean isr){
    isRemovable=isr;
    start();
    prop.setText(props);
    form.setText(forms);
    sign.setValue(signi);
    signl.setText(""+sign.getValue());
  }
  public MiniPanel(){
    isRemovable=true;
    start();
  }
  protected void start(){
    cons=new GridBagConstraints();
    setLayout(new GridBagLayout());
    cons.fill=GridBagConstraints.HORIZONTAL;
    setCons(0,0,1,1);    
    add(c=new Checkbox(),cons);
    if (!isRemovable)
      c.setEnabled(false);
    setCons(1,0,1,1);
    cons.weightx=1.0;
    add(prop=new TextField(15),cons);
    setCons(2,0,1,1);
    add(form=new TextField(15),cons);
    setCons(3,0,1,1);
    add(sign=new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,101),cons);
    setCons(4,0,1,1);
    add(signl=new Label("000"),cons);
    sign.addAdjustmentListener(this);
    if (!isRemovable)
      prop.setEditable(false);

    setVisible(true);
  }
  public String getProp(){
    return prop.getText();
  }
  public String getForm(){
    return form.getText();
  }
  public int getSign(){
    return sign.getValue();
  }
  
  protected void setCons(int x,int y, int w, int h){
    cons.gridx=x;
    cons.gridy=y;
    cons.gridwidth=w;
    cons.gridheight=h;
  }
  protected boolean isChecked(){
    return c.getState();
  }
  public final void adjustmentValueChanged(AdjustmentEvent e){
    if (e.getSource()==sign) {
      signl.setText(""+sign.getValue());
    }

  }
}
