// Using the Switch case to choose between which Data structures to perform the operations 
// 
package project_1;

import java.io.BufferedReader;



import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ProjectT {
	public static void main(String [] args){
		ArrayList <pjdata> recs = new ArrayList <pjdata> ();
		ProjectT t = new ProjectT();
		long  time = System.currentTimeMillis();
		 pjdata  root=null;
		 pjdata arr=null;
		 System.out.println("Order#" + " \t" + " \t" + "City" + " \t"+ " \t" + "State" + " \t" +" \t" + "ZipCode" + " \t" + " \t"+ 
				 "Amount" + " \t" + " \t" + "Date" + " \t" + " \t" + "Email" + " \t") ;
		   root = t.readFile(root);
		   // root.show(root);   // display the tree elements/nodes   
		   System.out.println("CPU time for tree read is :" + (System.currentTimeMillis() - time)); 
		   long  time2 = System.currentTimeMillis();
		   recs = t.readFile(recs);
		   // arr.show2(arr);
		System.out.println("CPU time for arraylist read is :" + (System.currentTimeMillis() - time2));
		long  timesetr = System.currentTimeMillis();
		root.searchtree(root, null );
		System.out.println("CPU time for searching tree is :" + (System.currentTimeMillis() - timesetr));
		long  timesear = System.currentTimeMillis();
		arr.searcharry(arr, 0);
		System.out.println("CPU time for searching arraylist is :" + (System.currentTimeMillis() - timesear));
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
	ArrayList readFile(ArrayList <pjdata> arr) {
		
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
		    	arr.add(temp);   // add the current node/element to the tree
			} 
		    inFile.close();
		    } catch (Exception e) { System.err.println(e); }
		  return arr;	
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
		public pjdata  add(pjdata rt, pjdata  n) {
		  if (rt == null)   
		    return  n;
		  if (n.getState().compareTo(rt.getState()) > 0)
		    rt.right = rt.add(rt.right, n);
		  else 
		    rt.left = rt.add(rt.left, n);
		  return  rt;
		  } 
		
		
		public boolean searchtree(pjdata r, String s) { //searching and placing the values in their respective node
			long  time = System.currentTimeMillis();
			if(r != null) {
				if((s.compareTo(r.getState())) < 0)
						r.searchtree(r.left, s);
				if((s.compareTo(r.getState())) == 0)
					return true;
				if((s.compareTo(r.getState())) > 0)
						r.searchtree(r.right, s);
				}
			System.out.println("CPU time used for tree search by State is :" + (System.currentTimeMillis() - time));
			return false;
		}
		
		public boolean searcharry(pjdata r, int n) { //searching and placing the values in their respective node
			long  time3 = System.currentTimeMillis();
			if(r != null) {
				if((n < (r.getOrder())))
						r.searcharry(r.left, n);
				if((n == (r.getOrder())))
					return true;
				if((n > (r.getOrder())))
						r.searcharry(r.right, n);
				}
			System.out.println("CPU time used for tree search by Order is :" + (System.currentTimeMillis() - time3));
			return false;
		}
		public void  show(pjdata  rt){ // To show the tree created above 
		  if (rt != null){
			show(rt.left);   
			System.out.println(rt);   
			show(rt.right);   
			} 
		  } 
		public void  show2(pjdata  ar){ // To show the tree created above 
			  if (ar != null){	 
				System.out.println(ar);    
				} 
			  } 
	}
	class arrpjdata{
		int OrderNum;
		String City;
		String  State;
		int ZipCode;
		double Amount;
		String  Date;
		String  Email ;
	
		public arrpjdata() {}
		
		public arrpjdata(int o, String c, String s, int zc, double a, String d, String e) 
		{ OrderNum =o; City=c; State = s; ZipCode=zc; Amount=a; Date =d; Email=e; }
		public int getOrderNum() {return OrderNum;}
		public void setOrder(int ordernum) {OrderNum = ordernum;}
		public String getCity() {return City;}
		public void setCity(String city) {City = city;}
		public String getState() {return State;}
		public void setState(String state) {State = state;}
		public int getZipCode() {return ZipCode;}
		public void setZipCode(int zipCode) {	ZipCode = zipCode;}
		public double getAmount() {return Amount;}
		public void setAmount(double amount) {Amount = amount;}
		public String getDate() {return Date;}
		public void setDate(String date) {Date = date;}
		public String getEmail() {return Email;}
		public void setEmail(String email) {Email = email;}

		@Override
		public String toString() 
			{
			return OrderNum + "  " + City + " " + State + " " + ZipCode + " " + Amount + " " + Date + " " + Email +" ";}
		
							
	}

