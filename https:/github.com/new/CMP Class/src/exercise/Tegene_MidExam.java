package exercise;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Tegene_MidExam {
	void readFile(LinkedList<Data> l) {
		String line;
		try {
			  BufferedReader inFile = new BufferedReader(new FileReader("midData.csv")); 
		      while ((line = inFile.readLine()) != null){
		    	  StringTokenizer st = new StringTokenizer(line, ",");
		    	  if(st.countTokens() == 3) // ignore dirty data, if the data doesn't contain three fields it will be considered dirty
		    		  l.add(new Data(st));
		            }
		      inFile.close();
		      }
		  catch(IOException ioe) {  System.err.print(ioe); }
	}// Reading the file in to the linkedlist 
	void readFile(ArrayList<Data> a) {
		String line;
		try {
			  BufferedReader inFile = new BufferedReader(new FileReader("midData.csv")); 
		      while ((line = inFile.readLine()) != null){
		    	  StringTokenizer st = new StringTokenizer(line, ",");
		    	  if(st.countTokens() == 3) // ignore dirty data, if the data doesn't contain three fields it will be considered dirty
		    		  a.add(new Data(st));
		            }
		      inFile.close();
		      }
		  catch(IOException ioe) {  System.err.print(ioe); }
	}// Reading the file in to the linkedlist 
	void search(LinkedList <Data> l, int age ) {
		int count =0;
		LinkedList <Data> r = new LinkedList();
		for(int i = 0; i < l.size(); i++)
			if(l.get(i).getAge() > age) {
				count ++;
				r.add(l.get(age));
			}
		//print(r);
	}// Searching through the linkedlist for a specific book 
	void print(LinkedList <Data> l) {
		System.out.println("ID\tAge\tStateCode");// Header for the printed data 
		for(int i = 0; i < l.size(); i++)
			System.out.println(l.get(i).toString()); 	
	}//Print all the books in the data set 
	void search(ArrayList <Data> a, int age ) {
		int count =0;
		ArrayList <Data> r = new ArrayList();
		for(int i = 0; i < a.size(); i++)
			if(a.get(i).getAge() > 55) {
				count ++;
				r.add(a.get(age));
			}
	}// Searching through the linkedlist for a specific book 
	void print(ArrayList <Data> a) {
		System.out.println("ID\tAge\tStateCode");// Header for the printed data 
		for(int i = 0; i < a.size(); i++)
			System.out.println(a.get(i).toString()); 	
	}//Print all the books in the data set 
	public static void main(String []args){
		
		Long rtl,rta;
		Tegene_MidExam m = new Tegene_MidExam();
		LinkedList <Data> l = new LinkedList();
		m.readFile(l);
		rtl = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1024;
		ArrayList <Data>  a = new ArrayList();
		rta = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1024;
		m.readFile(a);
		System.out.println("Memory Used:\nFor LinkedList is " + rtl + " kb" + "\nFor ArrayList is " + rta + " kb\n" );
		long startLL = System.currentTimeMillis();// get the start time before search 
		m.search(l, 55);
		System.out.println("CPU Time Used for Linked list: " + (System.currentTimeMillis() - startLL) + " ms");	//get the cpu time used to search through the data
		long startAL = System.currentTimeMillis();//get the start time before search 
		m.search(a, 55);
		System.out.println("CPU Time Used for Array list: " + (System.currentTimeMillis() - startAL) + " ms");	//get the cpu time used to saerch through the data 
	}// The main method     
	
}
class Data // The data class 
{
	int ID;  int Age; String StateCode;
	public Data() { }
	public Data(int i, String sc, int a) 
	{ID = i; StateCode = sc ; Age = a;}
	public Data(StringTokenizer st) 
	{ID = Integer.parseInt(st.nextToken()); Age = Integer.parseInt(st.nextToken()); StateCode = st.nextToken();}
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
