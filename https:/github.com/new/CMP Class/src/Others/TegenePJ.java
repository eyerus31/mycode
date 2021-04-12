package Others;
import java.io.*;

import java.util.*;
/*
 * Welcome to the final project for Design and Analysis of Algorithms class
 * This project aims to  
 * 1. Retrieve records by Order# and 
 * 2. Retrieve records by State
 * 
 * 
 * 
 */
public class TegenePJ{
	public static void main(String [] args){
		//Creating an instance of the project class
		
		TegenePJ t = new TegenePJ();
		//Calling the array list class used to read the data to an array list 
		ArrayList <pjdata> recs = new ArrayList <pjdata> ();
		pjdata  root=null;
		//Calling the hash table class used to read the data in to a hash table, using "key" and "value"   
		Hashtable<Integer, pjdata> hTable = new Hashtable<Integer, pjdata>();
		//To display the header for the data that will display
		//t.header();
		/*
		 * Here is the data used to estimate the Efficiency of the data structures used in this project 
		 * The estimation is done based on the CPU Time used to search for certain data and the memory used 
		 * eTime: 
		 * 			0 = Reading file using BinaryTree  
		 * 			1 = Reading file using ArrayList
		 * 			2 = Reading file using Hash Table
		 * 			3 = Searching for OrderNumber using BinaryTree
		 * 			4 = Searching for State using BinaryTree
		 * 			5 = Searching for OrderNumber using ArrayList
		 * 			6 = Searching for State using ArrayList
		 *  		7 = Searching for OrderNumber using HashTable
		 * 			8 = Searching for State using HashTable
		 * 			9 = Show the BinaryTree
		 * 			10 = Show the ArrayList
		 * 			11 = Show the HashTable
		 * eMemory
		 * 			0 = Memory used to Read File to BinaryTree 
		 * 			1 = Memory used to Read File to ArrayList 
		 * 			2 = Memory used to Read File to HashTable
		*/
		/*
		 *  Using an array storage with fixed length to store the values 
		 *  for each calculation of CPU time and Memory usage 
		 */
		long [] eTime = new long[12]; 
		long [] eMemory = new long[3];
		
		//CPU time and Memory used to Read the file into a BinaryTree 
		eTime[0] = System.currentTimeMillis();
		root = t.readFile(root);
		eMemory [0] = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); 
		eTime[0] = System.currentTimeMillis() - eTime[0];
		
		//CPU time and Memory used to Read the file into an ArrayList
		eTime[1] = System.currentTimeMillis();
		recs = t.readFile(recs);
		eMemory [1] = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); 
		eTime[1] = System.currentTimeMillis() - eTime[1];
		
		//CPU time and Memory used to Read the file into HashTable
		eTime[2] = System.currentTimeMillis();
		hTable = t.readFile(hTable);
		eMemory [2] = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); 
		eTime[2] = System.currentTimeMillis() - eTime[2];
		
		//Searching for OrderNumber using BinaryTree;
		root.count = 0;
		eTime[3] = System.currentTimeMillis();
		for (int i=0; i< 1000000; i++)
			root.search(root, 49975789);
		eTime[3] = System.currentTimeMillis() - eTime[3];
		//System.out.println(System.currentTimeMillis() +  " " + eTime[3]);
		
		//Searching for State using BinaryTree;
		root.count = 0;
		eTime[4] = System.currentTimeMillis();
		//for (int i=0; i< 10; i++)
		if (root.search(root, "VA")) 
		eTime[4] = System.currentTimeMillis() - eTime[4];
		
		//Searching for OrderNumber using ArrayList;
		eTime[5] = System.currentTimeMillis();
		for (int i=0; i< 1000000; i++)	
			t.search(recs, 49975789);
		eTime[5] = System.currentTimeMillis() - eTime[5];
		
		//Searching for State using ArrayList;
		eTime[6] = System.currentTimeMillis();
		//for (int i=0; i< 10; i++)
			t.search(recs, "VA");
		eTime[6] = System.currentTimeMillis() - eTime[6];
		
		//Searching for OrderNumber using HashTable;
		eTime[7] = System.currentTimeMillis();
		for (int i=0; i< 1000000; i++)
			hTable.get(49975789).toString();
		eTime[7] = System.currentTimeMillis() - eTime[7];
				
		//Searching for State using HashTable;
		eTime[8] = System.currentTimeMillis();
		//for (int i=0; i< 10; i++)
	    	t.search(hTable, "VA");
		eTime[8] = System.currentTimeMillis() - eTime[8];
		/*
		//Display Tree
		eTime[9] = System.currentTimeMillis();
		root.show(root);   // display the tree elements/nodes   
		eTime[9] = System.currentTimeMillis() - eTime[9];
		
		//Display ArrayList 
		eTime[10] = System.currentTimeMillis();
		t.display(recs);
		eTime[10] = System.currentTimeMillis() - eTime[10];
		
		//Display HashTable
		eTime[11] = System.currentTimeMillis();
		t.display(hTable);
		eTime[11] = System.currentTimeMillis() - eTime[11];
	*/
		
		//Display Report	
		System.out.println(
				            "+-----+---------+-------+-----+---------+-------+" + "\n" +
				            "|" +"Data\t\t Memory\t Read\t Search\t Search\t" + "|" + "\n" +
				            "|" +"Type\t\t Used\t File\t Order#\t State\t" + "|" + "\n" +
				            "+---------------+-------+-----+---------+-------+" + "\n" +
				            "|" + "\t\t (MB)\t (ms)\t (ms)\t(ms)\t" +  "|" + "\n" +
							  "+----------+----+---+---+---+---+---+---+---+---+" + "\n" +
							"|" +"BinaryTree|\t" + "|" +eMemory[0]/1024/1024 + "|" + "\t" + "|" + eTime[0] + "|" + "\t" + "|" + eTime[3] + "|" + "\t" + "|" + eTime[4] + "|"+ "\t"  + "|"+ "\n" +
							"|" +"Arraylist |\t" + "|" +eMemory[1]/1024/1024 + "|" + "\t" + "|" + eTime[1] + "|" + "\t" + "|" + eTime[5] + "|" + "\t" + "|" + eTime[6] + "|"+ "\t"  +  "|"+ "\n" +
							"|" +"HashTable |\t" + "|" +eMemory[2]/1024/1024 + "|" + "\t" + "|" + eTime[2] + "|" + "\t" + "|" + eTime[7] + "|" + "\t" + "|" + eTime[8] + "|" + "\t" +  "|"+ "\n" 
							+ "+----------+----+---+---+---+---+---+---+---+---+");

	}//main
	//A method to Read the file on to the BinaryTree 
	pjdata readFile(pjdata root) {
		 root=null;
		 pjdata temp;
		  String s;
		  StringTokenizer st;
		  try {
		   BufferedReader inFile = new BufferedReader(new FileReader("pjData.csv"));
		  while ((s = inFile.readLine()) != null)  	{
			st = new StringTokenizer(s, ",");
		    temp = new pjdata(
		    		Integer.parseInt(st.nextToken()),
		    		st.nextToken(),
		    		st.nextToken(),
		    		Integer.parseInt(st.nextToken()),
		    		Double.parseDouble(st.nextToken()),
		    		st.nextToken(),
		    		st.nextToken()
		    		);
		    root = temp.add(root, temp);   // add the current node/element to the tree
			} 
		    inFile.close();
		    } catch (Exception e) { System.err.println(e); }
		  return root;
		
	}
	//A method to Read the file into the ArrayList
	ArrayList readFile(ArrayList <pjdata> recs ) {
		pjdata temp;
		  String s;
		  StringTokenizer st;
		  try {
		   BufferedReader inFile = new BufferedReader(new FileReader("pjData.csv"));
		  while ((s = inFile.readLine()) != null)  	{
			st = new StringTokenizer(s, ",");
		    temp = new pjdata(
		    		Integer.parseInt(st.nextToken()),
		    		st.nextToken(),
		    		st.nextToken(),
		    		Integer.parseInt(st.nextToken()),
		    		Double.parseDouble(st.nextToken()),
		    		st.nextToken(),
		    		st.nextToken()
		    		);
		    recs.add(temp);
			} 
		    inFile.close();
		    } catch (Exception e) { System.err.println(e); }
		  return recs;	
	}
	//A method to Read the file into the HashTable
	Hashtable readFile(Hashtable<Integer, pjdata> h) {
		pjdata temp;
		  String s;
		  StringTokenizer st;
		  try {
		   BufferedReader inFile = new BufferedReader(new FileReader("pjData.csv"));
		  while ((s = inFile.readLine()) != null)  	{
			st = new StringTokenizer(s, ",");
		    temp = new pjdata(
		    		Integer.parseInt(st.nextToken()),
		    		st.nextToken(),
		    		st.nextToken(),
		    		Integer.parseInt(st.nextToken()),
		    		Double.parseDouble(st.nextToken()),
		    		st.nextToken(),
		    		st.nextToken()
		    		);
		    h.put(temp.Order,temp);
		} 
	    inFile.close();
	    } catch (Exception e) { System.err.println(e); }
		  return h;	
	}
	//A method used to search through the ArrayList using 
	void search(ArrayList <pjdata> a, int NO) {
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i).Order == NO)
				return;
		//System.out.println("Order Number " + NO + " found in the Array List at Position " + i);
		}
	}
	void search(ArrayList <pjdata> a, String st) {
		ArrayList <pjdata> r = new ArrayList<pjdata>();
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i).State.compareTo(st) == 0)
				r.add(a.get(i));
		}
		//System.out.println("State Search found " + r.size() + " states in the list of " + a.size() + " records in Array List.");
	}
	void search(Hashtable<Integer, pjdata> h, String st) {
		ArrayList <pjdata> r = new ArrayList<pjdata>();
		Iterator <Integer> i = h.keySet().iterator();
		while (i.hasNext())
			if(st.compareTo(h.get(i.next()).getState()) == 0)
				r.add(h.get(i.next()));
		//System.out.println("State Search found " + r.size() + " states in the list of " + h.size() + " records in HashTable.");
	}
	
	void header() {
		System.out.println(
							"Order#" + "\t\t" +
							"City" + "\t\t" +
							"State" + "\t\t" + 
							"ZipCode" + "\t\t" + 
							"Amount" + " \t\t" + 
							"Date" + " \t\t" + 
							"Email" + " \t"
							) ;
	}
	void report(long [] t, long [] m) {
		System.out.println(
				"CPU time for searching tree is :" + 
				"CPU time for tree read is :" +  
				"CPU time for arraylist read is :" +
				"CPU time for searching arraylist is :"
				);
	}
	//Method to display the data read to the ArrayList
	void display(ArrayList <pjdata> a){
		for(pjdata p:a) {
			System.out.println(p.toString());
		}
	}
	//Method to display the data read to the HashTable
	 void display(Hashtable<Integer, pjdata> hTable) {
		 //System.out.println(hTable.toString());
				
		}
}
//The Data class
	class pjdata {  
		int Order;
		String City;
		String  State;
		int ZipCode;
		double Amount;
		String  Date;
		String  Email ;
		pjdata left, right;
		static int count = 0;
		public pjdata() { left = right = null;}
		public pjdata(int o, String c, String s, int zc, double a, String d, String e) 
		{ Order =o; City=c; State = s; ZipCode=zc; Amount=a; Date =d; Email=e; }
		public int getOrder() {return Order;}
		public void setOrder(int order) {Order = order;}
		public String getCity() {return City;}
		public void setCity(String city) {City = city;	}
		public String getState() {return State;}
		public void setState(String state) {State = state;}
		public int getZipCode() {return ZipCode;}
		public void setZipCode(int zipCode) {ZipCode = zipCode;}
		public double getAmount() {return Amount;}
		public void setAmount(double amount) {Amount = amount;}
		public String getDate() {return Date;}
		public void setDate(String date) {Date = date;}
		public String getEmail() {return Email;}
		public void setEmail(String email) {Email = email;	}
		public pjdata getLeft() {return left;}
		public void setLeft(pjdata left) {this.left = left;}
		public pjdata getRight() {return right;}
		public void setRight(pjdata right) {this.right = right;}
		public String toString() {return Order + " \t" + City + " \t" + State + " \t\t " + ZipCode + " \t\t " + Amount + " \t" + Date + " \t" + Email +" \t";}
		public pjdata add(pjdata rt, pjdata  n) {
		  if (rt == null)   
		    return  n;
		  if (n.getOrder() < rt.getOrder())
		    rt.right = rt.add(rt.right, n);
		  else 
		    rt.left = rt.add(rt.left, n);
		  return  rt;
		  } 
		//searching and placing the values in their respective node
		public boolean search(pjdata r, String s) { 
			if(r != null) {
				if(r.left != null)
						r.search(r.left, s);
				if((s.compareTo(r.getState())) == 0) {
					//System.out.println(r.toString());
					count++;
				}
				if(r.right != null)
						r.search(r.right, s);
				}
			if(count > 0)
				return true;
			else
				return false;
		}
		//Method search to search through the data and place values in their respective node
		public boolean search(pjdata r, int n) { 
			if(r != null) {
				if(n < (r.getOrder()))
					r.search(r.right, n);
				if((r.getOrder()) == n) {
					//System.out.println(r.toString());
					count++;
				}
				if(n > (r.getOrder()))
					r.search(r.left, n);
				}
			if(count > 0)
				return true;
			else
				return false;
		}
		//Method to Show the data read to the Tree structure
		public void  show(pjdata  rt){ // To show the tree created above 
		  if (rt != null){
			show(rt.left);   
			//System.out.println(rt);   
			show(rt.right);   
			} 
		  } 
	}
