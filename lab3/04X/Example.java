import java.lang.Math;
import java.lang.Integer;


public class Example{


  static public class Item{
    public boolean b;
    public double digit;
    Item()
    {
      b = false;
      digit = 0.0;
    }

    Item(Item to_add)
    {
      b = to_add.b;
      digit = to_add.digit;
    }
  }

  static public class Link{
    public Item itm;
    public Link next;

    Link(){
      itm = null;
      next = null;
    }
    public Link addLink(Item to_add, Link formerHead){
      itm = new Item(to_add);
      next = formerHead;
      return this;
    }
  }


  static private double f(Link head)
  {
    Link node = head;
    double sum = 0;
    while(node != null)
    {
      sum += node.itm.b ? node.itm.digit : 0.0;
      node = node.next;
    }
    return sum;
  }

  static public void main (String argv[])
  {
    int n = Integer.parseInt(argv[0]);
    Link list = null;
    Item itm = new Item();
    for(int i = 1; i <= n; i++)
    {
      itm.b = !(i%2 == 0);
      itm.digit = Math.sqrt(i);

      Link to_add = new Link();
      list = to_add.addLink(itm, list);
    }
    double s = f(list);
    System.out.println("sum = " + s );
  }

}
