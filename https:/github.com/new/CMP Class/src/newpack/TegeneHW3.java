package newpack;
import java.io.*;
import java.util.*;
/*
 * This program is designed to sort the arrays descending based on the Price. 
 * And to calculate the CPU time used to read and sort the Hw2Data.csv data using a object and Arraylist.
 * 
 * 
 */

public class TegeneHW3 {
public static void main (String args []) {
		  String line;
		  int cnt = 0;
		  HWData [] recs = new HWData[19000];
		  long startTime = System.currentTimeMillis();
		  try {
			  BufferedReader inFile = new BufferedReader(new FileReader("hw2Data.csv")); 
		      while ((line = inFile.readLine()) != null){
		    	  StringTokenizer st = new StringTokenizer(line, ",");
		            recs[cnt] = new HWData(st);
		            ++cnt;
		            }
		      sortRecs(recs,recs.length);
		      inFile.close();
		      }
		  catch(IOException ioe) {  System.err.print(ioe); }
		  System.out.println("CPU Time Used for Array: " + (System.currentTimeMillis() - startTime) + " ms");
		  arraylist();
		 
} // main

static void arraylist () {
	 
	  Runtime r = Runtime.getRuntime();
	  String line;
	  ArrayList  <HWData> recs = new ArrayList <HWData> ();
	  long startTime1 = System.currentTimeMillis();
	 // long initialMemory = r.totalMemory () - r.freeMemory ();
	  try 
	    {
	    BufferedReader inFile = new BufferedReader(new FileReader("hw2Data.csv"));
	    while ((line = inFile.readLine()) != null)
	          {
	// Using StringTokenizer to split data line into fields.
	          StringTokenizer st = new StringTokenizer(line, ",");
	          if (st.countTokens() == 3) // ignore dirty data record
	             recs.add(new HWData(st));
	       
	          }
	    inFile.close();
	    }
	  catch (IOException e) { System.err.println(e); System.exit(1); }

	  System.out.println("CPU Time Used for Arraylist: " + (System.currentTimeMillis() - startTime1) + " ms");
	  
	  } 

static void sortRecs(HWData []rec, int n)
//static void sortRecs(DataRec []rec, int n)
{
//Implements the selection sort algorithm.
//Find the current smallest and then swaps at the end of each loop.
HWData temp;
int  index;  // points to the index of the current smallest element
for (int i=0; i < n; ++i)
	{
	index = i;
	for (int k = i + 1; k < n; ++k)
	    if (rec[index].getPrice() < rec[k].getPrice())
		index = k;
      temp = rec[i];
	rec[i] = rec[index];
	rec[index] = temp;
	//System.out.println(rec[i]+ " " + rec[index]);
	}
} // sortRecs
// array list

} // sortRecs
class HWData {
	// attributes
String  propertyID;
String  county;
double  price;
boolean sold;
public HWData() {}
public HWData(String s)
{ // Using StringTokenizer to split data line into fields.
	StringTokenizer st = new StringTokenizer(s, ",");
	propertyID = st.nextToken(",");
	county = st.nextToken(",");
	// Using the wrapper class to convert from string to double.
	price = Double.valueOf(st.nextToken(","));
} // constructor

public HWData(StringTokenizer st)
{
	propertyID = st.nextToken(",");
	county = st.nextToken(",");
	// Using the wrapper class to convert from string to double.
	price = Double.valueOf(st.nextToken(","));
}

// constructor
public String getPropertyID() { 
	return propertyID;
	}
public double getPrice() { 
	return price; 
	}
public void setPrice(double d) { price = d; }
public void setCounty(String c) { county = c; }
//public void setSold(boolean s) { sold = s; }
//public boolean isSold() { return sold; }
public String toString() 
{ return propertyID + "  " + county + "  " + price; }
}

		
