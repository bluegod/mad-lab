package madlab.gui;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import madlab.main.*;
/**
 * Class MainGUI 
 * Created: Mon Nov  2 11:20:50 2009
 * GNU Emacs 22.3.1 (powerpc-apple-darwin8.11.0)
 *
 * @author James Lopez (bluegod@bluegod.net) 
 * @version 1.0
 */
public class MainGUI extends Frame implements madlab.main.Version,MLColors,WindowListener {
  protected static final int siz_x=640,siz_y=480;
  protected final MLCanvas mlc;
  protected NewPanel np;
  protected ExpObject eo;
  protected SimulPanel sp;
  /**
   * Creates a new <code>MainGUI</code> instance.
   *
   * @param eo an <code>ExpObject</code> value
   */
  public MainGUI(ExpObject eo) {
    super(NAME+" "+VERSION);
    this.eo=eo;
    setLocationRelativeTo(null);
    mlc=new MLCanvas(this);
    setBackground(BGCOLOR);
    setLayout(new BorderLayout());
    pack();
    add(mlc, BorderLayout.NORTH);
    setSize(siz_x,siz_y);
    setResizable(false);
    addWindowListener(this);
    setLocation(200,50);
    setVisible(true);
  }
  /**
   * Describe <code>newOne</code> method here.
   *
   * @param isnew a <code>boolean</code> value
   */
  public void newOne(boolean isnew){
    if (np!=null)
      remove(np);
    np=null;
    if(sp!=null)
      remove(sp);
    sp=null;
    np=new NewPanel(this);
    if(isnew)eo= new ExpObject();
    np.openObject(eo);
    add(np,BorderLayout.CENTER);
    updateGUI();
  }
  /**
   * Describe <code>updateGUI</code> method here.
   *
   */
  public void updateGUI(){
    setVisible(true);    
    pack();
  }
  /**
   * Describe <code>openOne</code> method here.
   *
   */
  public void openOne(){
    MLOpenDialog mlod = new MLOpenDialog();
    MLOpener mloo= new MLOpener(mlod.gotURL());
    ExpObject o2open=mloo.getExpObject();
    this.eo=o2open;
    newOne(false);
  }
  /**
   * Describe <code>readOne</code> method here.
   *
   * @return an <code>ExpObject</code> value
   */
  public ExpObject readOne(){
    //TODO:Gestionar errores...
    if (np==null)return null;
    ExpObject o2save=new ExpObject();
    o2save.removeFirst();
    o2save.setTitle(np.getTitle());
    LinkedList<MiniPanel> lminis=np.getMiniObjects();
    Iterator iminis=lminis.iterator();
    try{
      while(iminis.hasNext()){
	MiniPanel minp=(MiniPanel)iminis.next();
	o2save.addProps(minp.getProp());
	o2save.addValor(minp.getForm());
	o2save.addSign(minp.getSign());
      }
    }catch(NullPointerException e){
      new MLDialog("Incompleto.",MLDialog.INFO);
    }
    return o2save;
  }
  /**
   * Describe <code>saveOne</code> method here.
   *
   */
  public void saveOne(){
    ExpObject o2save=readOne();
    FileDialog fd= new FileDialog(this,"Guardar fichero",FileDialog.SAVE);
    fd.setVisible(true);
    
    if(fd.getFile()!=null)
      new MLSaver(o2save,fd.getDirectory()+java.io.File.separator+fd.getFile());   
  }
  /**
   * Describe <code>simulateOne</code> method here.
   *
   */
  public void simulateOne(){
    try{
    MLSimul mls=new MLSimul(readOne());
    if(np!=null)
      remove(np);
    np=null;
    add(sp=new SimulPanel(this,mls.getDATA()),BorderLayout.CENTER);
    updateGUI();
    sp.doLayout();
    }catch(NullPointerException e){
      new MLDialog("Sin datos.",MLDialog.INFO);
    }
  }
  @Override /**
	     * Describe <code>update</code> method here.
	     *
	     * @param g a <code>Graphics</code> value
	     */
    public void update(Graphics g){
    
  }
  /**
   * <code>getVersion</code> method returns current Version.
   *
   * @return a <code>String</code> value
   */
  public String getVersion() {
    return NAME+" "+VERSION;
  }
  public final void windowActivated(final WindowEvent e) {
  }
  public final void windowClosed(final WindowEvent e) {
  }
  public final void windowClosing(final WindowEvent e) {
    System.exit(0);
  }
  public final void windowDeactivated(final WindowEvent e) {
  }
  public final void windowDeiconified(final WindowEvent e) {
  }
  public final void windowIconified(final WindowEvent e) {
  }
  public final void windowOpened(final WindowEvent e) {
  }
}
