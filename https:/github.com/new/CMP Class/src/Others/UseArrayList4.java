package Others;

/**
Using java.util.ArrayList to implement an insertion sort.
This program generates 10 UNIQUE random integers 
between 1 and 100 and sorts them in an ascending order.
*/
import java.util.*;
public class UseArrayList4   {
public static void main(String []args)    {
  ArrayList <Integer> numberList = new ArrayList<Integer>();
  Random  r = new Random();
  Integer n;
  int index = 0;
  System.out.println("Original numbers: ");
  for (int k=1; numberList.size() < 10; ++k)  
     {
     n = new Integer(r.nextInt(100)+1);
     System.out.println(n);
     if (numberList.size() < 1)   // an empty list
       {
       numberList.add(n);
       continue;
       } // The first number 
     if (numberList.contains(n))  
      { 
      System.out.println("Duplicated: " + n); 
      continue; 
      } // a duplicated number
     index = 0;
     for (Integer j : numberList)  
       {
       if (j.intValue() > n.intValue()) 
        { // The new number is smaller
        numberList.add(index, n);
        break;
        }
      ++index;
      } // for  j
     if (index >= numberList.size())  // The current largest number
       numberList.add(n);   // append to the end of the list
   } // for k
 System.out.println("In ascending order:");
 for (Integer k : numberList)  
    System.out.println(k);  
} // main
} // UseArrayList4
