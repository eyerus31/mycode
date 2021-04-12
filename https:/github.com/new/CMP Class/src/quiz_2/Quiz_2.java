package quiz_2;
/*
 * This program implements BST, arraylist, recursive search algorithm:
  1. Read records from hw5Data.csv file into a binary search tree data structure
  2. Read lines from passwordInput.txt and search them against the binary search tree build in Step 1. Repeat this search operation 4,000 times. 
  3. Show the CPU time used in Step 2.
  
  *The program has satisfied the requirements in an effective way as possible to my knowledge, 
  *I did get some help from Cengiz who is also my classmate for this class 
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Quiz_2 {
	private static int KB = 1024;
public static void main(String [] args){
	  // root points to the beginning of the binary tree data structure
	hwtree  root=null, temp;
	 long initialMemory1 = getUsedMemory();
	ArrayList <String> p = new <String> ArrayList();
	  String s;
	  StringTokenizer st;
	  long  time1 = System.currentTimeMillis();
	  try {
	   BufferedReader inFile = new BufferedReader(new FileReader("hw5Data.csv"));
	  while ((s = inFile.readLine()) != null)  	{
		st = new StringTokenizer(s, ",");
	    temp = new hwtree(st.nextToken(), st.nextToken());
	    root = temp.add(root, temp);   // add the current node/element to the tree
		} 
	    inFile.close();
	    } catch (Exception e) { System.err.println(e); }
	   //root.show(root);   // display the tree elements/nodes
	  
	   System.out.println("The Total Memory used by BinaryTree is " + (getUsedMemory() - initialMemory1 + " KB"));
	   System.out.println("CPU time used by BinaryTree is :" + (System.currentTimeMillis() - time1));
	   long  time = System.currentTimeMillis();
	   long initialMemory = getUsedMemory();
	  arraylist(p); //calling the array list method that reds files from passwordInput.txt
	  System.out.println("The Total Memory used by arraylist is " + (getUsedMemory() - initialMemory + " KB"));
	  System.out.println("CPU time used by arraylist is :" + (System.currentTimeMillis() - time)); 
	  //calculate the time used by the CPU to read the hw5Data.csv and search against hw5Data.csv
	 // System.out.println("The Total Memory used by BinaryTree is " + (getUsedMemory() - initialMemory + " KB"));
}//main
private static long getUsedMemory() {
	Runtime runtime = Runtime.getRuntime();
	return (runtime.totalMemory()- runtime.freeMemory() / KB);		
}
static void arraylist (ArrayList <String> pwd) {
	String line;
	try {
		BufferedReader inFile = new BufferedReader(new FileReader("hw5Data.csv"));
	    while ((line = inFile.readLine()) != null)
	    	pwd.add(line); 
	    	inFile.close();}
	catch (Exception e){System.err.print(e);}
}
}
class hwtree{ //binary search tree class created from the hw5Data.csv
	String  userName;
	String  password;
	hwtree left, right;
	public hwtree() { left = right = null;}
	public hwtree(String u, String p) { userName = u; password = p; left = right = null; }
	public String getUserName() { return userName; }
	public String toString() { return userName + " " + password; }
	public hwtree  add(hwtree rt, hwtree  n) {
	  if (rt == null)   
	    return  n;
	  if (n.getUserName().compareTo(rt.getUserName()) > 0)
	    rt.right = rt.add(rt.right, n);
	  else 
	    rt.left = rt.add(rt.left, n);
	  return  rt;
	  } 
	public boolean search(hwtree r, String s) { //searching and placing the values in their respective node
		if(r != null) {
			if((s.compareTo(r.getUserName())) < 0)
					r.search(r.left, s);
			if((s.compareTo(r.getUserName())) > 0)
					r.search(r.right, s);
			if((s.compareTo(r.getUserName())) == 0)
					return true;
			}
		return false;
	}
	public void  show(hwtree  rt){ // To show the tree created above 
	  if (rt != null){
		show(rt.left);   
		System.out.println(rt);   
		show(rt.right);   
		} 
	  } 
}