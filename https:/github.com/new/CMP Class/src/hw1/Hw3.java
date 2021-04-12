package hw1;


import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.JButton;


public class Hw3 {

	public class MyRecord {	
		/**
		This program Designs and develop a data class for the input data record. 
		and name the data class as MyRecord. 
		Developed a Java program to read the data records from hw2Data.csv file into an 
		object array of Myrecord. Then show the CPU time used to read the file.
		**/
		public  void main(String []args)
		  {
		  String line;
		  ArrayList  <HWData> recs = new ArrayList <HWData> ();
		  long startTime = System.currentTimeMillis();
		  try 
		    {
		    BufferedReader inFile = new BufferedReader(new FileReader("sortData.csv"));
		    while ((line = inFile.readLine()) != null)
		          {
		// Using StringTokenizer to split data line into fields.
		          StringTokenizer st = new StringTokenizer(line, ",");
		          if (st.countTokens() == 3) // ignore dirty data record
		             recs.add(new HWData());
		          }
		    inFile.close();
		    }
		  catch (IOException e) { System.err.println(e); System.exit(1); }
		  System.out.print("The cpu time used is: ");

		  System.out.println(System.currentTimeMillis() - startTime + " ms");
		  } // main
		} // ReadHWData2
	

	public class UseArrayList4   {
	   {
		  ArrayList <Integer> numberList = new ArrayList<Integer>();
		  Random  r = new Random();
		  Integer n;
		  int index = 0;
		  System.out.println("Original numbers: ");
		  for (int k=1; numberList.size() < 10; ++k)  
		     {
		     n = new Integer(r.nextInt(100)+1);
		     System.out.println(n);
		     if (numberList.size() < 1)   // an empty list
		       {
		       numberList.add(n);
		       continue;
		       } // The first number 
		     if (numberList.contains(n))  
		      { 
		      System.out.println("Duplicated: " + n); 
		      continue; 
		      } // a duplicated number
		     index = 0;
		     for (Integer j : numberList)  
		       {
		       if (j.intValue() > n.intValue()) 
		        { // The new number is smaller
		        numberList.add(index, n);
		        break;
		        }
		      ++index;
		      } // for  j
		     if (index >= numberList.size())  // The current largest number
		       numberList.add(n);   // append to the end of the list
		   } // for k
		 System.out.println("In ascending order:");
		 for (Integer k : numberList)  
		    System.out.println(k); 


}
	}
}// main
class HWData
{
String  propertyID;
String  county;
double  price;
public HWData() {}
public HWData(String s)
  {
// Using StringTokenizer to split data line into fields.
  StringTokenizer st = new StringTokenizer(s, ",");
  propertyID = st.nextToken(",");
  county = st.nextToken(",");
// Using the wrapper class to conver from string to double.
  price = Double.valueOf(st.nextToken(","));
  } // constructor
// Reader methods
public String getPropertyID() { return propertyID; }
public String getCounty() { return county; }
public double getPrice() { return price; }
// Writer methods
public void setPrice(double p) { price=p; }
// Other
public String toString()
   { return propertyID + "  " + price; }
} // HWData

