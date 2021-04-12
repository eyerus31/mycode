package hw5;

// The driver class for the CustomerTree (Binary tree) class
import java.io.*;
import java.util.*;
public class  RunCustomerTree2   {
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
} // RunCustomerTree2


// A binary search tree node: sorted by customer names.
/*class CustomerTree {
int     ID;
String  name;
CustomerTree   left;
CustomerTree   right;  
public CustomerTree()  { left = right = null; }
public CustomerTree(int i, String s)  
{ ID = i; name = s;  left=right=null;  }
public int getID() { return  ID; }
public String getName() { return  name; }
public void setID(int i) { ID = i; }
public void setName(String s) { name = s; }
public String toString() { return ID + "  " + name; }

// Recursively look for the place to add the new element/node
public CustomerTree  add(CustomerTree rt, CustomerTree  n)
  {
  if (rt == null)   
    return  n;  // add the current node/element here
  if (n.getName().compareTo(rt.getName()) > 0)
// add the current node/element to the right branch
    rt.right = rt.add(rt.right, n);
  else  // add the current node/element to the left branch
    rt.left = rt.add(rt.left, n);
  return  rt;
  } // add

// Recursively display elements/node from the binary tree.
// Inorder   Left->Self->Right
public void  show(CustomerTree  rt)  
{
  if (rt != null)
	{
	show(rt.left);   // display the left branch first
	System.out.println(rt);   // display itself
	show(rt.right);   // display the right branch
	} 
  } // show
} // CustomerTree
*/
