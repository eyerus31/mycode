package Others;

// Replacing java.util.Vector by java.util.ArrayList
import java.util.*;
import javax.swing.*;
public class UseArrayList  {
public static void main(String []x)    {
//   Vector <Object> v = new Vector<Object>();
 ArrayList <Object> v = new ArrayList<Object>();
 v.add("Hello");
 v.add(new JButton("Hi"));
 v.add(new int[2]);
// Converting to an Object array
 Object [] myArray = v.toArray();
 for (int k=0; k < myArray.length; ++k)
    System.out.println(myArray[k].getClass().getName());
 System.out.println(myArray.length);		
 } // main
} // UseArrayList
