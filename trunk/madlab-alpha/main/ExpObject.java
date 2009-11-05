package madlab.main;
import java.util.*;
/**
 * Class ExpObject 
 * Created: Thu Nov  5 10:22:59 2009
 * GNU Emacs 22.3.1 (powerpc-apple-darwin8.11.0)
 *
 * @author James Lopez (bluegod@bluegod.net) 
 * @version 1.0
 */
public class ExpObject implements java.io.Serializable{

  /**
   * Creates a new <code>ExpObject</code> instance.
   *
   */
  protected LinkedList<String> myvalor;
  protected LinkedList<String> myprops;
  protected LinkedList<Integer> mysigns;
  protected String mytitle;
  public ExpObject() {
    //adding default values:
    myvalor=new LinkedList<String>();
    myprops=new LinkedList<String>();
    mysigns=new LinkedList<Integer>();
    addValor("10");
    addProps("Media:");
    addSign(100);
    setTitle(" ");
  }
  public void removeFirst(){
    if (myvalor.size()>0 && myprops.size()>0 && mysigns.size()>0) {
      myvalor.removeFirst();
      myprops.removeFirst();
      mysigns.removeFirst();
    }
  }
  public LinkedList<String> getValores(){
    return myvalor;
  }
  public LinkedList<String> getProps(){
    return myprops;
  }
  public LinkedList<Integer> getSigns(){
    return mysigns;
  }
  public String getTitle(){
    return mytitle;
  }
  public void addValor(String s){
    if (!s.equals(""))
      myvalor.add(s);
  }
  public void addProps(String s){
    if (!s.equals(""))
      myprops.add(s);
  }
  public void addSign(int i){
      mysigns.add(i);
  }
  public void setTitle(String s){
    this.mytitle=s;
  }
}
