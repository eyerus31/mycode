package Others;

/**
Author: Andy Yao, Ph.D.
A program to demonstrate how data lines from an input file are read into an ArrayList.
The data class is include in the same for demonstration purposes.
In reality, a data class needs to defined as a public class by iteself.
Input file is a csv file.
Input file name: hw3Data.csv
Input data format:
  Property ID, County, Price
Sample lines:
  119736,CLAY COUNTY,792148.9
  448094,CLAY COUNTY,1438163.57
  206893,CLAY COUNTY,192476.78
**/
import java.util.*;
import java.io.*;
public class ReadHWData
{
public static void main(String []args)
  {
  String line;
  ArrayList  <HWData> recs = new ArrayList <HWData> ();
  try 
    {
    BufferedReader inFile = 
      new BufferedReader(new FileReader("hw2Data.csv"));
    while ((line = inFile.readLine()) != null)
          recs.add(new HWData(line));
    inFile.close();
    }
  catch (IOException e) { System.err.println(e); System.exit(1); }

  System.out.println(recs.size() + " records processed.");
  } // main
} // ReadHWData


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
// Using the wrapper class to convert from string to double.
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





