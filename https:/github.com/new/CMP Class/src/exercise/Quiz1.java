package exercise;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Quiz1 {
	
	private static int KB = 1024;
	
	 public static void main (String args []) {
		 
		 String line;
		  ArrayList  <HWData> recs = new ArrayList <HWData> ();
		  long startTime = System.currentTimeMillis();
		  
		  long initialMemory = getUsedMemory();
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

		  System.out.println(System.currentTimeMillis() - startTime + " ms");
		  System.out.println("The Total Memory used is " + (getUsedMemory() - initialMemory + " KB"));
		  } // main

	private static long getUsedMemory() {
		Runtime runtime = Runtime.getRuntime();
		return (runtime.totalMemory()- runtime.freeMemory() / KB);
	}
		} // ReadHWData2



		// Data class
		// For demonstration purposes, this class is included here.
		class HWData
		{
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
		public String getPropertyID() { return propertyID; }
		public void setPrice(double d) { price = d; }
		public void setCounty(String c) { county = c; }
		public void setSold(boolean s) { sold = s; }
		public boolean isSold() { return sold; }
		public String toString() 
		  { return propertyID + "  " + county + "  " + price; }
}
