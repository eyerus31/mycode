package midtrial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

import hw4.TegeneHW4;
import hw4.TegeneHW4.Book;

//import hw4.TegeneHW4.Book;


public class mid1 {
	
	//static String FileName = "midData.csv"; 
	void readFile(LinkedList<Data> l) {
		String line;
		long startTime = System.currentTimeMillis();
		try {
			  BufferedReader inFile = new BufferedReader(new FileReader("midData.csv")); 
		      while ((line = inFile.readLine()) != null)
		      {
		    	  StringTokenizer st = new StringTokenizer(line, ",");
		    	  if(st.countTokens() == 3) // ignore dirty data, if the data doesn't contain three fields it will be considered dirty
		    		  l.add(new Data(st));
		            }
		      inFile.close();
		      
		      }
		  catch(IOException ioe) {  System.err.print(ioe); }
		System.out.println("CPU Time Used for Linked list: " + (System.currentTimeMillis() - startTime) + " ms");
	}// Reading the file in to the linkedlist 
	
	void search(LinkedList <Data> l, int age ) {
		long startTime2 = System.currentTimeMillis();//get the start time before search 
		int count =0;
		LinkedList <Data> r = new LinkedList();
		for(int i = 0; i < l.size(); i++)
			if(l.get(i).getAge() > 55)
				count ++;
		System.out.println();
				r.add(l.get(age));
		print(r);
		System.out.println("CPU Time Used for Linked list: " + (System.currentTimeMillis() - startTime2) + " ms");	//get the cpu time used to search through the data
	}// Searching through the linkedlist for a specific book 
	void print(LinkedList <Data> l) {
		System.out.println("ID\tAge\tStateCode");// Header for the printed data 
		for(int i = 0; i < l.size(); i++)
			System.out.println(l.get(i).toString()); 	
	}//Print all the books in the data set 
	
	static void arraylist () {
		 
		  Runtime r = Runtime.getRuntime();
		  String line;
		  ArrayList  <Data> records = new ArrayList <Data> ();
		  long startTime1 = System.currentTimeMillis();
		
		  try 
		    {
		    BufferedReader inFile = new BufferedReader(new FileReader("midData.csv"));
		    while ((line = inFile.readLine()) != null)
		         // {
		        //  StringTokenizer st = new StringTokenizer(line, ",");
		       //   if (st.countTokens() == 3) // ignore dirty data record
		        //     records.add(new Data(st));
		     //     }// Using StringTokenizer to split data line into fields.
		    inFile.close();
		    }
		  catch (IOException e) { System.err.println(e); System.exit(1); }

		  System.out.println("CPU Time Used for Arraylist: " + (System.currentTimeMillis() - startTime1) + " ms");
		  
		  }// Reading the file using arraylist 
	void search(ArrayList <Data> l, int age ) {
		long startTime2 = System.currentTimeMillis();// get the start time before search 
		int count =0;
		ArrayList <Data> r = new ArrayList();
		for(int i = 0; i < l.size(); i++)
			if(l.get(i).getAge() > 55)
				count ++;
		System.out.println();
				r.add(l.get(age));
		print(r);
		System.out.println("CPU Time Used for Linked list: " + (System.currentTimeMillis() - startTime2) + " ms");	//get the cpu time used to saerch through the data 
	}// Searching through the linkedlist for a specific book 
	void print(ArrayList <Data> l) {
		System.out.println("ID\tAge\tStateCode");// Header for the printed data 
		for(int i = 0; i < l.size(); i++)
			System.out.println(l.get(i).toString()); 	
	}//Print all the books in the data set 
	
	public static void main(String []args)    {
		//LinkedList <Data> l = new LinkedList();
		linkedlist();
	   // ArrayList <Data>  records = new ArrayList();
		
				arraylist();
	}// The main method     
	
	private static void linkedlist() {
		// TODO Auto-generated method stub
		
	}

	public class Data // The data class 
	{
		int ID;  int Age; String StateCode;
	public Data() { }
	public Data(int i, String sc, int a) 
	{ID = i; StateCode = sc ; Age = a;}
	public Data(StringTokenizer st) 
	{ID = Integer.parseInt(st.nextToken()); StateCode = st.nextToken(); Age = Integer.parseInt(st.nextToken());}
	public int getID() { 
		return ID; }
	public String getStateCode() { 
		return StateCode; }
	public int getAge() { 
		return Age;}
	public void setStateCode(String sc) { StateCode = sc; }
	public void setAge(int a) { Age = a; }
	public String toString() { 
		return ID + "\t" + Age + "\t"+ StateCode;
		}
	} // Data

}
