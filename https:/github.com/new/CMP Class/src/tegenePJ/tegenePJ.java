package tegenePJ;
//Using the Switch case to choose between which Data structures to perform the operations 

import java.io.*;
import java.util.*;

public class tegenePJ{
	public static void main(String [] args){
		//Data Types
		tegenePJ t = new tegenePJ();
		ArrayList <pjdata> recs = new ArrayList <pjdata> ();
		pjdata  root=null;
		Hashtable<Integer, pjdata> hTable = new Hashtable<Integer, pjdata>();
		/*
		 * Efficiency data
		 * eTime: 
		 * 			0 = Read file for BinaryTree time 
		 * 			1 = Read file for ArrayList
		 * 			2 = Read file for Hash Table
		 * 			3 = Search for Order Number BinaryTree
		 * 			4 = Search for State for BinaryTree
		 * 			5 = Search for Order Number ArrayList
		 * 			6 = Search for for ArrayList
		 *  		7 = Search for Order Number HashTable
		 * 			8 = Search for for HashTable
		 * 			9 = Show BinaryTree
		 * 			10 = Show ArrayList
		 * 			11 = Show HashTable
		 * eMemory
		 * 			0 = Read File for Tree Memory
		 * 			1 = Read File for ArrayList Memory
		 * 			2 = Read File for HashTable
		*/
		long [] eTime = new long[12];// 0 = 
		long [] eMemory = new long[3];
		
		//Read file for Tree
		eTime[0] = System.currentTimeMillis();
		root = t.readFile(root);
		eMemory [0] = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); 
		eTime[0] = System.currentTimeMillis() - eTime[0];
		
		//Read file to ArrayList
		eTime[1] = System.currentTimeMillis();
		recs = t.readFile(recs);
		eMemory [1] = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); 
		eTime[1] = System.currentTimeMillis() - eTime[1];
		
		//Read file to HashTable
		eTime[2] = System.currentTimeMillis();
		hTable = t.readFile(hTable);
		eMemory [2] = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); 
		eTime[2] = System.currentTimeMillis() - eTime[2];
		
		//Search tree for order number;
		root.count = 0;
		eTime[3] = System.currentTimeMillis();
		//System.out.println(System.currentTimeMillis() +  " " + eTime[3]);
		//for(int i = 0; i < 100; i++)
			if (root.search(root, 96458129)) //System.out.println("Found Order Number");
		eTime[3] = System.currentTimeMillis() - eTime[3];
		System.out.println(System.currentTimeMillis() +  " " + eTime[3]);
		
		//Search tree for state
		root.count = 0;
		eTime[4] = System.currentTimeMillis();
		if (root.search(root, "VA")) //System.out.println("Found States");
		eTime[4] = System.currentTimeMillis() - eTime[4];
		
		//Search ArraList for Order Number
		eTime[5] = System.currentTimeMillis();
		t.search(recs, 96458129);
		eTime[5] = System.currentTimeMillis() - eTime[5];
		
		//Search ArraList for state
		eTime[6] = System.currentTimeMillis();
		for(int i = 0; i < 100; i++)
			t.search(recs, "VA");
		eTime[6] = System.currentTimeMillis() - eTime[6];
		
		//Search HashTable for Order Number
		eTime[7] = System.currentTimeMillis();
		//System.out.println("Found for Hash Table by Order Number \n"+
		for(int i = 0; i < 100; i++)
			hTable.get(96458129).toString();
		//);
		eTime[7] = System.currentTimeMillis() - eTime[7];
				
		//Search HashTable for state
		eTime[8] = System.currentTimeMillis();
		t.search(hTable, "VA");
		eTime[8] = System.currentTimeMillis() - eTime[8];
		/*
		//Display Tree
		eTime[9] = System.currentTimeMillis();
		t.header();
		root.show(root);   // display the tree elements/nodes   
		eTime[9] = System.currentTimeMillis() - eTime[9];
		
		//Display ArrayList 
		eTime[10] = System.currentTimeMillis();
		t.header();
		t.display(recs);
		eTime[10] = System.currentTimeMillis() - eTime[10];
		*/
		//Display Report
		System.out.println(
							"Data\t\t Memory\t Read\t Search\t Search\t\n" +
							"Type\t\t Used\t File\t Order#\t State\t\n" +
							"\t\t (MB)\t (ms)\t(ms)\t(ms)\t \n" +
							"BinaryTree\t" + eMemory[0]/1024/1024 + "\t" + eTime[0] + "\t" + eTime[3] + "\t" + eTime[4] + "\t" + "\n" + 
							"Arraylist\t" + eMemory[1]/1024/1024 + "\t" + eTime[1] + "\t" + eTime[5] + "\t" + eTime[6] + "\t" +  "\n" +
							"HashTable\t" + eMemory[2]/1024/1024 + "\t" + eTime[2] + "\t" + eTime[7] + "\t" + eTime[8] + "\t" 
				);

	}//main
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
	void search(ArrayList <pjdata> a, int oN) {
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i).Order == oN)
				return;
				//System.out.println("Order Number " + oN + " found in the Array List at Position " + i);
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
	void display(ArrayList <pjdata> a){
		for(pjdata p:a) {
			System.out.println(p.toString());
		}
	}
}
	class pjdata { //binary search tree class created from the hw5Data.csv
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
		public String toString() {return Order + " \t" + City + " \t" + State + " \t" + ZipCode + " \t" + Amount + " \t" + Date + " \t" + Email +" \t";}
		public pjdata add(pjdata rt, pjdata  n) {
		  if (rt == null)   
		    return  n;
		  if (n.getOrder() < rt.getOrder())
		    rt.right = rt.add(rt.right, n);
		  else 
		    rt.left = rt.add(rt.left, n);
		  return  rt;
		  } 
		public boolean search(pjdata r, String s) { //searching and placing the values in their respective node
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
		public boolean search(pjdata r, int n) { //searching and placing the values in their respective node
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
		public void  show(pjdata  rt){ // To show the tree created above 
		  if (rt != null){
			show(rt.left);   
			System.out.println(rt);   
			show(rt.right);   
			} 
		  } 
	}
