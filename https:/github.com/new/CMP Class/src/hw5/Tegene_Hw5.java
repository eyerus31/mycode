package hw5;
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

public class Tegene_Hw5 {
		
public static void main(String [] args){
	  // root points to the beginning of the binary tree data structure
	hwtree  root=null, temp;
	ArrayList <String> p = new <String> ArrayList();
	  String s;
	  StringTokenizer st;
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
	 long  time = System.currentTimeMillis();
	  arraylist(p); //calling the array list method that reds files from passwordInput.txt
	  
	  for(int i = 0 ; i < 4000; i++) //repeat the search 4000 times 
		  for(int k = 0 ; k < p.size(); k++) // searching against the hw5Data.csv using p as a key
			  root.search(root, p.get(k));
	  
	  System.out.println("CPU time is :" + (System.currentTimeMillis() - time)); 
	  //calculate the time used by the CPU to read the passwordInput.txt and search against hw5Data.csv
	  
}//main
static void arraylist (ArrayList <String> pwd) {
	String line;
	try {
		BufferedReader inFile = new BufferedReader(new FileReader("passwordInput.txt"));
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