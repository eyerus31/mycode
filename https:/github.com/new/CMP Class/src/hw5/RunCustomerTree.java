package hw5;

// The driver class for the CustomerTree (Binary tree) class
import java.io.*;
import java.util.*;
public class  RunCustomerTree   {
public static void main(String []args)  
  {  // root points to the beginning of the binary tree data structure
  CustomerTree  root=null, temp;
  String s;
  int i;
  StringTokenizer st;
  try {
   BufferedReader inFile = new BufferedReader(new FileReader("customers.txt"));
  while ((s = inFile.readLine()) != null)  	{
	st = new StringTokenizer(s);
    temp = new CustomerTree(Integer.valueOf(st.nextToken()), st.nextToken());
    root = temp.add(root, temp);   // add the current node/element to the tree
	} // while not EOF
    inFile.close();
    } catch (Exception e) { System.err.println(e); }
   root.show(root);   // display the tree elements/nodes
   } // main  
} // RunCustomerTree