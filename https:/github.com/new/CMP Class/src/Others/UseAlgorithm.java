package Others;

/**
java.util.Collections methods that work on the List objects:
   sort, shuffle, reverse, binarySearch, min, max
*/
import java.util.*;
public class UseAlgorithm   
{
public static void main(String []args)     
  { 
  ArrayList<Integer> a = new ArrayList<Integer>();  
//  LinkedList<Integer> a = new LinkedList<Integer>();  
//  Stack<Integer> a = new Stack<Integer>();  
//  Vector<Integer> a = new Vector<Integer>();  
  Random r = new Random();
  for (int k=1; k<=7; ++k)   
     a.add(new Integer(r.nextInt(50)));
  Collections.sort(a);
  System.out.println("Ascending order...");
  for (Integer x : a)  
     System.out.println(x);
  Collections.shuffle(a);
  System.out.println("=Shuffled=");
  for (Integer x : a)  
     System.out.println(x);
  Collections.reverse(a);
  System.out.println("Reverse order...");
  for (Integer x : a)  
     System.out.println(x);
  System.out.println("Looking for 48...");
  if (Collections.binarySearch(a, new Integer(48)) >= 0)
     System.out.println("Found a match");
  else  
     System.out.println("No match");
  System.out.println("Min: " + Collections.min(a));
  System.out.println("Max: " + Collections.max(a));
  } // main
} // UseAlgorithm
