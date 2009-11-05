package madlab.gui;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import madlab.main.*;
/**
 * Class NewPanel 
 * Created: Tue Nov  3 12:49:12 2009
 * GNU Emacs 22.3.1 (powerpc-apple-darwin8.11.0)
 *
 * @author James Lopez (bluegod@bluegod.net) 
 * @version 1.0
 */
public class NewPanel extends ScrollPane implements MLColors, ActionListener {

  /**
   * Creates a new <code>NewPanel</code> instance.
   *
   */
  protected Panel fpan;
  protected Label la,lb,lc,ld;
  protected TextField ta;
  protected LinkedList<MiniPanel> minis;
  protected GridBagConstraints cons;
  protected Button remb,addb;
  protected static int maxmps;
  protected MainGUI mg;
  protected boolean updating;
  public NewPanel(MainGUI mg) {
    super(ScrollPane.SCROLLBARS_AS_NEEDED);
    updating=false;
    minis=null;
    maxmps=3;
    /*if(minis!=numinis.size()!=0){
      minis.clear();
      System.out.println(minis.size());
  }*/
      this.mg=mg;
    //start();
  }
  public void start(){
    cons = new GridBagConstraints();
    fpan=new Panel();
    fpan.setLayout(new GridBagLayout());
    if(!updating){
      if(ta==null)
	ta=new TextField(15);
      la=new Label("Nombre del experimento");
      //TODO: Alinear correctamente estas labels, seguramente
      //con un nuevo panel y setLayout(null).
      
      lb=new Label("Propiedad");
      lc=new Label("Valor");
      ld=new Label("Significacion");
    }
    cons.fill=GridBagConstraints.HORIZONTAL;
    cons.weightx=1.0;
    setCons(0,0,1,1);
    fpan.add(la,cons);
    setCons(1,0,1,1);
    fpan.add(ta,cons);
    setCons(0,1,1,1);
    fpan.add(lb,cons);
    setCons(1,1,1,1);
    fpan.add(lc,cons);
    setCons(2,1,1,1);
    fpan.add(ld,cons);
    Iterator iminis = minis.iterator(); 
    int j=2;
    while (iminis.hasNext()){
      setCons(0,j++,3,1);
      fpan.add((MiniPanel)iminis.next(),cons);
    }
    cons.anchor=GridBagConstraints.WEST;
    cons.fill=GridBagConstraints.NONE;
    cons.weightx=0.0;
    setCons(0,j,1,1);
    fpan.add(addb=new Button("Nueva propiedad"),cons);
    setCons(1,j,1,1);
    fpan.add(remb=new Button("Borrar propiedad"),cons);
    addb.addActionListener(this);
    remb.addActionListener(this);
    fpan.setBackground(BGCOLOR);
    add(fpan);
    fpan.setVisible(true);
    this.doLayout();
  }
  /*  @Override public Dimension getPreferredSize(){
     return new Dimension(640,300);
     }*/
  protected void setCons(int x,int y, int w, int h){
    cons.gridx=x;
    cons.gridy=y;
    cons.gridwidth=w;
    cons.gridheight=h;
  }
  //probablemente mejor protected/private
  
  public void setTitle(String t){
    ta.setText(t);
  }
  public String getTitle(){
    return ta.getText();
  }
  public LinkedList<MiniPanel> getMiniObjects(){
    if(minis==null)return null;
    else return minis;
  }
  public void openObject(ExpObject eo){
    minis=new LinkedList<MiniPanel>();
    Iterator iminis = minis.iterator(); 
    Iterator iprops = eo.getProps().iterator();
    Iterator ivalor = eo.getValores().iterator();
    Iterator isigns = eo.getSigns().iterator();
    if(ta==null)ta=new TextField(15);
    setTitle(eo.getTitle());
    for (int i=0,j=0;i<maxmps;i++){
      boolean isr;
      while(iprops.hasNext() && ivalor.hasNext() && isigns.hasNext())
	{
	  if(j++==0)isr=false;
	  else isr=true;
	  minis.add(new MiniPanel((String)iprops.next(),(String)ivalor.next(),
				  ((Integer)isigns.next()).intValue(),isr));
	}
      minis.add(new MiniPanel());
    }
    start();
  }
  public final void actionPerformed(final ActionEvent e){
    if(e.getSource()==remb){
      Iterator iminis = minis.iterator(); 
      updating=true;
      while (iminis.hasNext()){
	MiniPanel mi=(MiniPanel)iminis.next();
	if(mi.isChecked()){
	  iminis.remove();
	  maxmps--;
	}
      }
      remove(fpan);
      fpan=null;
      start();
      mg.updateGUI();
    }
    else if(e.getSource()==addb){
      updating=true;
      maxmps++;
      minis.add(new MiniPanel());
      remove(fpan);
      fpan=null;
      start();
      mg.updateGUI();
    }
  }
  public void update(Graphics g){
  }
}
