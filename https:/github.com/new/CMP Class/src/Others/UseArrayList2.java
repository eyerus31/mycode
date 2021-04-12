package Others;

// Another ArrayList example
import java.util.*;
public class UseArrayList2  {
  public static void main( String [] args )     {
   ArrayList <String> list = new ArrayList<String>();
   list.add("Hey");
   list.add("Hello");
   list.add("Howdy");
   list.add("Hi");
   for (String x : list)  
      System.out.println(x);
   ListIterator  i = list.listIterator(list.size());
   while (i.hasPrevious())  
        System.out.println( "   " + i.previous());
   list.clear();  // remove all elements from the list
   } // main
} // UseArrayList2
